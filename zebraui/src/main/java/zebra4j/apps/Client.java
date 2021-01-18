package zebra4j.apps;

import java.util.Locale;

import org.teavm.jso.JSBody;

import zebra4j.Criminal;
import zebra4j.QuestionPuzzleGenerator;

public class Client {

	@JSBody(params = { "message" }, script = "console.log(message)")
	public static native void log(String message);

	@JSBody(params = { "name", "func" }, script = "window[name] = func")
	public static native void setGenerator(String name, Generator func);

	@JSBody(params = { "name", "numPeople" }, script = "console.log(window[name](numPeople))")
	public static native void logFunc(String name, int numPeople);

	public static void main(String[] args) {
		setGenerator("question", numPeople -> QuestionPuzzleGenerator.randomPuzzle(numPeople).toString());
		log("Function initialized.");
		log(Criminal.TYPE.describeSet(null, Locale.getDefault()));
	}
}
