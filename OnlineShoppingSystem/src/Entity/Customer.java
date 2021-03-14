package Entity;

import java.util.Date;

public class Customer extends Person {

    private String customerId;
    private String address;
    private String phone;
    private String email;

    public Customer(String name, Date dob, String gender, String customerId, String address, String phone, String email) {
        super(name, dob, gender);
        this.customerId = customerId;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString()+"Customer{" +
                "customerId='" + customerId + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
