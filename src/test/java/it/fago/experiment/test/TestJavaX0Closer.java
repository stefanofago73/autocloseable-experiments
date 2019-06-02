package it.fago.experiment.test;

import static it.fago.experiment.autocloseable.javax0.AutoCloser.useResource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.fago.experiment.autocloseable.javax0.AutoCloser;
import it.fago.experiment.autocloseable.javax0.NotAutoClosable;

public class TestJavaX0Closer {

	private NotAutoClosable subject;

	@Before
	public void setup() {
		subject = new NotAutoClosable();
	}

	@After
	public void shutdown() {
		subject = null;
	}

	@Test
	public void testSimpleUsage() {
		NotAutoClosable notAutoclosable = null;
		try (
				// using Java ( result in something more verbose but... it's
				// ok... maybe...
				AutoCloser<NotAutoClosable>.AutoClosableSupplier elem = 
				      useResource(subject())
						.closeWith(sp -> sp.get().dispose())) {
			notAutoclosable = elem.get();
			Assert.assertTrue("while using service...", notAutoclosable.isOpened());
		}
		Assert.assertFalse("after try-with-resource...", notAutoclosable.isOpened());
	}

	// ===========================================================
	//
	//
	// ===========================================================

	private NotAutoClosable subject() {
		return subject;
	}

}// END
