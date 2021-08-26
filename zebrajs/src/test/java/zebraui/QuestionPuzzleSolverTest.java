package zebraui;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.chocosolver.solver.ChocoSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

import zebra4j.AbstractPuzzleGenerator;
import zebra4j.Attribute;
import zebra4j.PersonName;
import zebra4j.BasicPuzzle;
import zebra4j.PuzzleGenerator;
import zebra4j.PuzzleGeneratorTest;
import zebra4j.Question;
import zebra4j.QuestionPuzzle;
import zebra4j.QuestionPuzzleSolver;

@RunWith(TeaVMTestRunner.class)
public class QuestionPuzzleSolverTest {

	@Test
	public void testSolve() {
		PuzzleGenerator generator = new PuzzleGenerator(PuzzleGeneratorTest.simpleSolutionWithCriminal(),
				AbstractPuzzleGenerator.DEFAULT_FACT_TYPES);
		generator.setChocoSettings(new ChocoSettings());
		BasicPuzzle basicPuzzle = generator.generate();
		QuestionPuzzle questionPuzzle = new QuestionPuzzle(Question.NAME_OF_CRIMINAL, basicPuzzle);
		QuestionPuzzleSolver solver = new QuestionPuzzleSolver(questionPuzzle);
		solver.setChocoSettings(new ChocoSettings());
		Collection<Attribute> solutionNames = solver.solve();
		assertEquals(1, solutionNames.size());
		assertEquals(PersonName.TYPE, solutionNames.iterator().next().type());
	}
}
