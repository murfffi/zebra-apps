package zebraui;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

import zebra4j.AbstractPuzzleGenerator;
import zebra4j.Clothes;
import zebra4j.Criminal;
import zebra4j.PersonName;
import zebra4j.Puzzle;
import zebra4j.PuzzleSolutionBuilder;
import zebra4j.Question;
import zebra4j.QuestionPuzzle;
import zebra4j.QuestionPuzzleGenerator;
import zebra4j.QuestionPuzzleSolver;
import zebra4j.fact.Fact;

@RunWith(TeaVMTestRunner.class)
@Ignore // very slow
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
		var puzzle = generator.generate();

		for (Fact f : puzzle.getPuzzle().getFacts()) {
			var newFacts = new HashSet<>(puzzle.getPuzzle().getFacts());
			newFacts.remove(f);
			var newPuzzle = new QuestionPuzzle(puzzle.getQuestion(),
					new Puzzle(puzzle.getPuzzle().getAttributeSets(), newFacts));
			var solutions = new QuestionPuzzleSolver(newPuzzle).solve();
			System.out.println(newPuzzle);
			System.out.println(solutions);
			assertTrue(solutions.size() > 1);
		}
	}

}
