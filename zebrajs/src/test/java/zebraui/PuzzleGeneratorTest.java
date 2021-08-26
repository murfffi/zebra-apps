package zebraui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.chocosolver.solver.ChocoSettings;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

import zebra4j.AbstractPuzzleGenerator;
import zebra4j.BasicPuzzle;
import zebra4j.PuzzleGenerator;
import zebra4j.PuzzleSolution;
import zebra4j.PuzzleSolver;

@RunWith(TeaVMTestRunner.class)
public class PuzzleGeneratorTest {

	@Test
	@Ignore // very slow
	public void testGenerate() throws Exception {
		PuzzleSolution startSolution = zebra4j.PuzzleGeneratorTest.sampleSolution();
		PuzzleGenerator puzzleGenerator = new PuzzleGenerator(startSolution,
				AbstractPuzzleGenerator.DEFAULT_FACT_TYPES);
		puzzleGenerator.setChocoSettings(new ChocoSettings());
		BasicPuzzle puzzle = puzzleGenerator.generate();
		PuzzleSolver solver = new PuzzleSolver(puzzle);
		solver.setChocoSettings(new ChocoSettings());
		Collection<PuzzleSolution> result = solver.solve();
		assertTrue(result.contains(startSolution));
		assertEquals(1, result.size());
	}

}
