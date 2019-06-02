package it.fago.experiment.test;

import static it.fago.experiment.autocloseable.eh.Autocloser2.autoclose;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.fago.experiment.autocloseable.IService;
import it.fago.experiment.autocloseable.Service;
import it.fago.experiment.autocloseable.eh.LeanCloseable;

public class TestLeanCloser {

	private IService subject;

	@Before
	public void setup() {
		subject = new Service();
		subject.init();
	}

	@After
	public void shutdown() {
		subject = null;
	}

	@Test
	public void testSimpleUsage() {
		try (LeanCloseable<IService> service = autoclose(subject(), IService::destroy)) {
			Assert.assertTrue("while executing...", subject().isOpened());
			service.get().execute("Hello World!");
		}
		;
		Assert.assertFalse("after try-with-resource...", subject().isOpened());
	}

	// ===========================================================
	//
	//
	// ===========================================================

	private IService subject() {
		return subject;
	}

}// END