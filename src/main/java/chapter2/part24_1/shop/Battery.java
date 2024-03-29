package chapter2.part24_1.shop;

public class Battery extends Product {

    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    // 게터 및 세터
    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }

    public boolean getRechargeable() {
        return rechargeable;
    }
}
