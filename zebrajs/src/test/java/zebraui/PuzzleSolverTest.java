package zebraui;

import org.chocosolver.solver.ChocoSettings;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

import zebra4j.Puzzle;
import zebra4j.PuzzleSolver;

@RunWith(TeaVMTestRunner.class)
public class PuzzleSolverTest extends zebra4j.PuzzleSolverTest {

	@Override
	protected PuzzleSolver createTestSolver(Puzzle puzzle) {
		return new PuzzleSolver(puzzle, new ChocoSettings());
	}

}
