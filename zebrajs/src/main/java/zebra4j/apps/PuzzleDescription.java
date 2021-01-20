package zebra4j.apps;

import java.util.List;

import org.teavm.flavour.json.JsonPersistable;

@JsonPersistable
public class PuzzleDescription {

	public List<String> facts;
	public String question;
	public List<String> answerOptions;
	public String answer;

}
