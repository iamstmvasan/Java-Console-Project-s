package Entity;

import java.util.Iterator;

public class Supplier {
    private long supplierId;
    private String name;
    private String address;
    private Item item;

    public Supplier(long supplierId, String name, String address, Item item) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.item = item;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", item=" + item +
                '}';
    }
}
