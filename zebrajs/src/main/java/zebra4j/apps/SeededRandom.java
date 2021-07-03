package zebra4j.apps;

import java.util.List;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.core.source64.SplitMix64;
import org.apache.commons.rng.sampling.ListSampler;

import zebra4j.util.Randomness;

/**
 * {@link Randomness} with seed support based on commons-rng library
 */
public class SeededRandom implements Randomness {

	private UniformRandomProvider rnd;

	public SeededRandom(long seed) {
		rnd = new SplitMix64(seed);
	}

	@Override
	public void shuffle(List<?> list) {
		ListSampler.shuffle(rnd, list);
	}

	@Override
	public int nextInt(int bound) {
		return rnd.nextInt(bound);
	}

}
