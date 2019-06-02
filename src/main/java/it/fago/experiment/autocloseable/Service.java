package it.fago.experiment.autocloseable;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

public class Service implements IService {

	private boolean opened;

	@Override
	public void init() {
		LoggerFactory.getLogger(getClass()).info("{} : init ", this);
		opened = true;
	}

	@Override
	public void destroy() {
		LoggerFactory.getLogger(getClass()).info("{} : destroy ", this);
		opened = false;
	}

	@Override
	public void execute(Object... arguments) {
		LoggerFactory.getLogger(getClass()).info("executing with: {}", Arrays.toString(arguments));
	}

	@Override
	public boolean isOpened() {
		return opened;
	}

}// END