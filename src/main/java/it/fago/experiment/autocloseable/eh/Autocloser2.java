package it.fago.experiment.autocloseable.eh;

import java.util.function.Consumer;

public class Autocloser2 {

	public static final <S> LeanCloseable<S> autoclose(S element, Consumer<S> elementInvocation) {
		return new LeanCloseable<S>(element, elementInvocation);
	}

}// END
