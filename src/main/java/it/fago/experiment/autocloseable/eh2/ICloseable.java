package it.fago.experiment.autocloseable.eh2;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ICloseable<S> extends  AutoCloseable {

	default void close() {
		doClose();
	}

	void doClose();
	
	static <S> ICloseable<S> withResource(S subject, Consumer<S> callback){
       return ()->callback.accept(subject);	
	}

}// END