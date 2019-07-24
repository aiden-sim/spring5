package chapter2.part19_1.calculator;

public class CounterImpl implements Counter {
	private int count;

	@Override public void increase() {
		count++;
	}

	@Override public int getCount() {
		return count;
	}
}
