package zebra4j.apps;

import java.util.Locale;
import java.util.stream.Collectors;

import org.chocosolver.solver.ChocoSettings;
import org.teavm.flavour.json.JSON;
import org.teavm.jso.JSBody;

import zebra4j.Attribute;
import zebra4j.AttributeType;
import zebra4j.Attributes;
import zebra4j.PuzzleSolution;
import zebra4j.Question;
import zebra4j.QuestionPuzzle;
import zebra4j.QuestionPuzzleGenerator;
import zebra4j.SolutionGenerator;
import zebra4j.util.Randomness;

public class Client {

	private static final String EXPORT_SCRIPT = """
			exports[name] = func
			export let name = func
			""";

	@JSBody(params = { "message" }, script = "console.log(message)")
	private static native void log(String message);

	@JSBody(params = { "name", "func" }, script = EXPORT_SCRIPT)
	private static native void setSeededGenerator(String name, SeededGenerator func);

	public static void main(String[] args) {
		setSeededGenerator("generateQuestionPuzzle", Client::generatePuzzleWithSeed);
		log("Function initialized.");
	}

	private static String generatePuzzleWithSeed(int numPeople, String seed) {
		if ("".equals(seed)) {
			seed = String.valueOf(System.currentTimeMillis());
		}
		SeededRandom rnd = new SeededRandom(Long.valueOf(seed));
		PuzzleDescription description = generateQuestionPuzzleDescription(numPeople, rnd, seed);
		return JSON.serialize(description).stringify();
	}

	static PuzzleDescription generateQuestionPuzzleDescription(int numPeople, Randomness rnd, String seed) {
		Locale locale = Locale.getDefault();
		PuzzleSolution sampleSolution = new SolutionGenerator(Attributes.DEFAULT_TYPES, numPeople, rnd).generate();
		QuestionPuzzleGenerator generator = new QuestionPuzzleGenerator(
				Question.generate(sampleSolution.getAttributeSets(), rnd), sampleSolution, rnd,
				QuestionPuzzleGenerator.DEFAULT_FACT_TYPES);
		generator.setChocoSettings(new ChocoSettings());
		QuestionPuzzle puzzle = generator.generate();
		Attribute answer = puzzle.getQuestion().answer(sampleSolution).get();
		PuzzleDescription description = describe(puzzle, locale);
		description.answer = answer.description(locale);
		description.seed = seed;
		return description;
	}

	static PuzzleDescription describe(QuestionPuzzle puzzle, Locale locale) {
		PuzzleDescription description = new PuzzleDescription();
		description.facts = puzzle.describeConstraints(locale);
		description.question = puzzle.getQuestion().describe(locale);
		AttributeType about = puzzle.getQuestion().getAbout();
		description.answerOptions = puzzle.getBasicPuzzle().getAttributeSets().get(about).stream()
				.map(a -> a.description(locale)).collect(Collectors.toList());
		return description;
	}
}
