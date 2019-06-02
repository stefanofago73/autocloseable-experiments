package it.fago.experiment.autocloseable.dsl2;

import java.util.function.Consumer;

public class AutocloserDsl2 {

	public static final <S> LeanCloseable<S> useResource(S element, Consumer<S> refMethod) {
		return new LeanCloseable<S>(element, refMethod);
	}

	public static final <S> Consumer<S> closeWith(Consumer<S> refMethod) {
		return refMethod;
	}

}// END
