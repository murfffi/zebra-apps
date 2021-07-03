package zebra4j.apps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;

import zebra4j.AtHouse;
import zebra4j.PersonName;
import zebra4j.Puzzle;
import zebra4j.PuzzleGeneratorTest;
import zebra4j.PuzzleSolution;
import zebra4j.Question;
import zebra4j.QuestionPuzzle;
import zebra4j.fact.BothTrue;
import zebra4j.fact.Fact;

/**
 * This test is intentionally run in Java, because the PuzzleGeneration is
 * covered in {@link zebraui.PuzzleGeneratorTest}.
 */
public class ClientTest {

	@Test
	public void testGenerateQuestionPuzzleDescription() {
		int numPeople = 3;
		PuzzleDescription output = Client.generateQuestionPuzzleDescription(numPeople, new SeededRandom(1), "1");
		assertNotNull(output.seed);
		assertEquals(numPeople, output.answerOptions.size());
		assertTrue(output.answerOptions.contains(output.answer));
		assertNotNull(output.question);
		assertTrue(output.facts.size() > numPeople);
	}

	@Test
	public void testDescribe_OnlyRelevantConstraints() throws Exception {
		PuzzleSolution solution = PuzzleGeneratorTest.sampleSolution();
		assertEquals(3, solution.getAttributeSets().size());
		Set<Fact> facts = Collections.singleton(new BothTrue(PersonName.PETER, new AtHouse(1)));
		QuestionPuzzle puzzle = new QuestionPuzzle(new Question(PersonName.PETER, AtHouse.TYPE),
				new Puzzle(solution.getAttributeSets(), facts));

		PuzzleDescription description = Client.describe(puzzle, Locale.getDefault());
		assertEquals(2 + facts.size(), description.facts.size());
	}

}
