package zebra4j.apps;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testGenerateQuestionPuzzleDescription() {
		PuzzleDescription output = Client.generateQuestionPuzzleDescription(3);
		System.out.println(output);
		assertNotNull(output);
	}

}
