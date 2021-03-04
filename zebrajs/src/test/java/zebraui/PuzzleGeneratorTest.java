package zebraui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

@RunWith(TeaVMTestRunner.class)
public class PuzzleGeneratorTest {

	private final zebra4j.PuzzleGeneratorTest wrappedTest = new zebra4j.PuzzleGeneratorTest();

	@Test
	public void testGenerate() throws Exception {
		wrappedTest.testGenerate();
	}

}
