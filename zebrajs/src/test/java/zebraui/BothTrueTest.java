package zebraui;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

@RunWith(TeaVMTestRunner.class)
public class BothTrueTest extends zebra4j.fact.BothTrueTest {

	/**
	 * Ignored because {@link Character.UnicodeBlock} is missing in TeaVM
	 */
	@Override
	@Ignore
	public void testDescribe() {

	}
}
