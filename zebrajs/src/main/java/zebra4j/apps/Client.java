package zebra4j.apps;

import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.teavm.flavour.json.JSON;
import org.teavm.jso.JSBody;

import zebra4j.AttributeType;
import zebra4j.Attributes;
import zebra4j.PuzzleSolution;
import zebra4j.Question;
import zebra4j.QuestionPuzzle;
import zebra4j.QuestionPuzzleGenerator;
import zebra4j.SolutionGenerator;
import zebra4j.fact.Fact;

public class Client {

	@JSBody(params = { "message" }, script = "console.log(message)")
	public static native void log(String message);

	@JSBody(params = { "name", "func" }, script = "window[name] = func")
	public static native void setGenerator(String name, Generator func);

	@JSBody(params = { "name", "numPeople" }, script = "console.log(window[name](numPeople))")
	public static native void logFunc(String name, int numPeople);

	public static void main(String[] args) {
		setGenerator("question", Client::generateQuestionPuzzle);
		log("Function initialized.");
	}

	static String generateQuestionPuzzle(int numPeople) {
		PuzzleDescription description = generateQuestionPuzzleDescription(numPeople);
		return JSON.serialize(description).stringify();
	}

	public static PuzzleDescription generateQuestionPuzzleDescription(int numPeople) {
		Locale locale = Locale.getDefault();
		PuzzleDescription description = new PuzzleDescription();
		description.seed = System.currentTimeMillis();
		Random rnd = new Random(description.seed);
		PuzzleSolution sampleSolution = new SolutionGenerator(Attributes.DEFAULT_TYPES, numPeople, rnd).generate();
		QuestionPuzzleGenerator generator = new QuestionPuzzleGenerator(Question.generate(sampleSolution.getAttributeSets(), rnd),
				sampleSolution, rnd, QuestionPuzzleGenerator.DEFAULT_FACT_TYPES);
		QuestionPuzzle puzzle = generator.generate();
		description.facts = puzzle.getPuzzle().describeConstraints(locale);
		description.question = puzzle.getQuestion().describe(locale);
		AttributeType about = puzzle.getQuestion().getAbout();
		description.answerOptions = puzzle.getPuzzle().getAttributeSets().get(about).stream()
				.map(a -> a.description(locale)).collect(Collectors.toList());
		description.answer = puzzle.getQuestion().answer(sampleSolution).get().description(locale);
		return description;
	}
}
