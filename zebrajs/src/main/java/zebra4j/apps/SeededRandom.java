package zebra4j.apps;

import java.util.Random;

import org.teavm.jso.JSBody;

public class SeededRandom extends Random {

	private static final long serialVersionUID = 1L;

	public SeededRandom(long seed) {
		seedRandom(String.valueOf(seed));
	}

	public SeededRandom(String seed) {
		seedRandom(seed);
	}

	@JSBody(params = { "seed" }, script = "Math.seedrandom(seed);")
	private static native void seedRandom(String seed);

}
