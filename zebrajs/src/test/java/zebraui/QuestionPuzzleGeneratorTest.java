package zebraui;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.chocosolver.solver.ChocoSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

import zebra4j.AbstractPuzzleGenerator;
import zebra4j.Clothes;
import zebra4j.Criminal;
import zebra4j.PersonName;
import zebra4j.BasicPuzzle;
import zebra4j.PuzzleSolutionBuilder;
import zebra4j.Question;
import zebra4j.QuestionPuzzle;
import zebra4j.QuestionPuzzleGenerator;
import zebra4j.QuestionPuzzleSolver;

@RunWith(TeaVMTestRunner.class)
public class QuestionPuzzleGeneratorTest {

	/**
	 * Checks if the generated puzzle is minimal, given possible JS translation
	 * bugs.
	 */
	@Test
	public void testMinimal() {
		var question = new Question(Clothes.GREEN, PersonName.TYPE);
		var builder = new PuzzleSolutionBuilder();
		builder.addWithHouse(PersonName.PETER, Clothes.BLUE, Criminal.YES);
		builder.addWithHouse(PersonName.ELENA, Clothes.GREEN, Criminal.NO);
		builder.addWithHouse(PersonName.IVAN, Clothes.RED, Criminal.NO);
		var generator = new QuestionPuzzleGenerator(question, builder.build(),
				AbstractPuzzleGenerator.DEFAULT_FACT_TYPES);
		generator.setChocoSettings(new ChocoSettings());
		var puzzle = generator.generate();

		var newFacts = new HashSet<>(puzzle.getBasicPuzzle().getFacts());
		newFacts.remove(newFacts.iterator().next());
		var newPuzzle = new QuestionPuzzle(puzzle.getQuestion(),
				new BasicPuzzle(puzzle.getBasicPuzzle().getAttributeSets(), newFacts));
		QuestionPuzzleSolver solver = new QuestionPuzzleSolver(newPuzzle);
		solver.setChocoSettings(new ChocoSettings());
		assertTrue(solver.solveToStream().limit(2).count() > 1);
	}

}
