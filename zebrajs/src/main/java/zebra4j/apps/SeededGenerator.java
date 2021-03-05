package zebra4j.apps;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

@JSFunctor
public interface SeededGenerator extends JSObject {

	String generate(int numPeople, String seed);

}
