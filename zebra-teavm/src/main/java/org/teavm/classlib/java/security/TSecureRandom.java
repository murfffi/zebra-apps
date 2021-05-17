package org.teavm.classlib.java.security;

import org.teavm.classlib.java.util.TRandom;

/**
 * A limited implementation of SecureRandom, used by commons-rng
 * 
 * <p>
 * The secure aspect of SecureRandom is not needed in the way we use
 * commons-rng. Seeding is not supported because commons-rng doesn't use it
 * either.
 *
 */
public class TSecureRandom extends TRandom {

}
