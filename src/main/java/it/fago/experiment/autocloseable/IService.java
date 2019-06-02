package it.fago.experiment.autocloseable;

public interface IService {

	void init();
	
	void destroy();
	
	void execute(Object ... arguments);
	
	boolean isOpened();
	
}
