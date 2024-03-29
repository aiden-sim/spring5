package chapter2.part2_1;

public class Battery extends Product {

	private boolean rechargeable;

	public Battery() {
		super();
	}

	public Battery(String name, double price) {
		super(name, price);
	}

	public boolean isRechargeable() {
		return rechargeable;
	}

	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}
}
