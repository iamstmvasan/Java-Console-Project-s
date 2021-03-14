package Entity;

import java.util.Date;

public class Privilege extends Customer {

    private double discountPercent;

    public Privilege(String name, Date dob, String gender, String customerId, String address, String phone, String email, double discountPercent) {
        super(name, dob, gender, customerId, address, phone, email);
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return super.toString()+"Privilege{" +
                "discountPercent=" + discountPercent +
                '}';
    }
}
