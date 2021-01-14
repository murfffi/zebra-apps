package zebraui;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

@RunWith(TeaVMTestRunner.class)
public class QuestionTest extends zebra4j.QuestionTest {

	/**
	 * Ignored because Random(seed) constructor is not implemented in TeaVM
	 */
	@Override
	@Ignore
	public void testGenerate_Stable() {

	}
}
