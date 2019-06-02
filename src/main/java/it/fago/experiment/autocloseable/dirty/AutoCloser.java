package it.fago.experiment.autocloseable.dirty;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AutoCloser {

	public static final <S> AutoCloseable autoclose(S element, Consumer<S> elementInvocation) {
		return ((BiFunction<S, Consumer<S>, AutoCloseable>) (subject, callback) -> () -> callback.accept(subject)).apply(element, elementInvocation);
	}

}// END
