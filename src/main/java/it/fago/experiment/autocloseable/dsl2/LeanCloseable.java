package it.fago.experiment.autocloseable.dsl2;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LeanCloseable<S> implements Supplier<S>, AutoCloseable {

	private S target;
	private Consumer<S> callback;

	LeanCloseable(S target, Consumer<S> callback) {
		this.target = target;
		this.callback = callback;
	}

	@Override
	public void close() {
		callback.accept(target);
	}

	@Override
	public S get() {
		return target;
	}

}// END