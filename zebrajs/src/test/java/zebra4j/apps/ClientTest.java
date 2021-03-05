package zebra4j.apps;

import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

/**
 * This test is intentionally run in Java, because the PuzzleGeneration is
 * covered in {@link zebraui.PuzzleGeneratorTest}.
 */
public class ClientTest {

	@Test
	public void testGenerateQuestionPuzzleDescription() {
		PuzzleDescription output = Client.generateQuestionPuzzleDescription(3, new Random(), "1");
		System.out.println(output);
		assertNotNull(output.seed);
	}

}
