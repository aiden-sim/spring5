package chapter2.part3_1;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
	private PrefixGenerator prefixGenerator;
	private String suffix;
	private int initial;
	private final AtomicInteger counter = new AtomicInteger();

	public SequenceGenerator() {
	}

	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public String getSequence() {
		String builder = prefixGenerator.getPrefix() +
				initial +
				counter.getAndIncrement() +
				suffix;
		return builder;
	}
}
