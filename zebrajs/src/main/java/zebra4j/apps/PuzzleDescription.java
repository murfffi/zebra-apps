package zebra4j.apps;

import java.util.List;

import org.teavm.flavour.json.JsonPersistable;

@JsonPersistable
public class PuzzleDescription {

	public List<String> facts;
	public String question;
	public List<String> answerOptions;
	public String answer;
	public long seed;

	@Override
	public String toString() {
		return "PuzzleDescription\n[facts=" + facts + ",\nquestion=" + question + ",\nanswerOptions=" + answerOptions
				+ ",\nanswer=" + answer + "]";
	}

}
