package org.teavm.classlib.java.util.concurrent.locks;

import org.teavm.classlib.java.lang.TInterruptedException;
import org.teavm.classlib.java.util.concurrent.TTimeUnit;

/**
 * Partial implementation of TReentrantLock
 * 
 * <p>
 * TReentrantLock is missing in TeaVM -
 * https://github.com/konsoletyper/teavm/issues/342 . commons-rng uses it but
 * the way zebrajs uses commons-rng doesn't require actual locking, so we can
 * have an empty implementation.
 * 
 * <p>
 * In JDK, ReentrantLock implements Lock but we don't need that either.
 */
public class TReentrantLock {

	public TReentrantLock() {
		this(false);
	}

	public TReentrantLock(boolean fair) {
	}

	public void lock() {
	}

	public void lockInterruptibly() throws TInterruptedException {
	}

	public boolean tryLock() {
		return true;
	}

	public boolean tryLock(long time, TTimeUnit unit) throws InterruptedException {
		return true;
	}

	public void unlock() {

	}

}
