package zebra4j.apps;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

import zebra4j.*;

public class Client {
	public static void main(String[] args) {
		// System.setErr(LoggerFactory.getErrorPrintStream(LoggerFactory.getLogger(Client.class)));
		QuestionPuzzle puzzle = QuestionPuzzleGenerator.randomPuzzle(3);
		HTMLDocument document = HTMLDocument.current();
		HTMLElement div = document.createElement("div");
		div.appendChild(document.createTextNode(puzzle.toString()));
		document.getBody().appendChild(div);
	}
}
