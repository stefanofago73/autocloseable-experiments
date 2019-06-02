package it.fago.experiment.test;

import static it.fago.experiment.autocloseable.dirty.AutoCloser.autoclose;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.fago.experiment.autocloseable.IService;
import it.fago.experiment.autocloseable.Service;

public class TestDirtyCloser {

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
		try (AutoCloseable c = autoclose(subject, IService::destroy)) {
			Assert.assertTrue("while is executing...", subject.isOpened());
			subject.execute("Hello World!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse("after try-with-resource...", subject.isOpened());
	}

	// ===========================================================
	//
	//
	// ===========================================================

	private IService subject() {
		return subject;
	}

}// END