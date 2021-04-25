package zebra4j.apps;

import java.util.Random;

import org.teavm.jso.JSBody;

/**
 * TeaVM random with seed support based on seedrandom library
 * 
 * <p>
 * Requires https://github.com/davidbau/seedrandom#readme to be imported.
 *
 */
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
