package it.fago.experiment.autocloseable.javax0;

import org.slf4j.LoggerFactory;

public class NotAutoClosable {
	
	private boolean opened;
	
	public NotAutoClosable() {
		LoggerFactory.getLogger(getClass()).info("{} born...",this);
		opened = true;
	}

	public void dispose() {
		LoggerFactory.getLogger(getClass()).info("{} disposing...",this);
		opened = false;
	}
	
	public boolean isOpened(){
		return opened;
	}
	
}//END