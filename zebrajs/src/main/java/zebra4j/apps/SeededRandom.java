package zebra4j.apps;

import java.util.Random;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.core.source64.SplitMix64;

/**
 * TeaVM random with seed support based on commons-rng library
 * 
 * <p>
 * Similar to {@link org.apache.commons.rng.simple.JDKRandomBridge} but without
 * all the reflection.
 */
public class SeededRandom extends Random {

	private static final long serialVersionUID = 1L;

	private transient UniformRandomProvider delegate;

	public SeededRandom(long seed) {
		delegate = new SplitMix64(seed);
	}

	@Override
	protected int next(int n) {
		synchronized (this) {
			return delegate.nextInt() >>> (32 - n);
		}
	}

}
