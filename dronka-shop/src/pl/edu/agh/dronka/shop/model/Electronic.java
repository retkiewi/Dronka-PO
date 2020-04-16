package pl.edu.agh.dronka.shop.model;

public class Electronic extends Item {

    private boolean mobile;
    private boolean warranty;

    public Electronic(String name, Category category, int price, int quantity, boolean mobile, boolean warranty) {
        super(name, category, price, quantity);
        this.mobile = mobile;
        this.warranty = warranty;
    }

    public Electronic(){}

    public boolean getMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean getWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}
