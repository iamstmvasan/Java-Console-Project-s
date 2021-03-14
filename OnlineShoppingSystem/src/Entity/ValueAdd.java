package Entity;

import java.util.Date;

public class ValueAdd extends Customer {

    private long bonusPoint;

    public ValueAdd(String name, Date dob, String gender, String customerId, String address, String phone, String email, long bonusPoint) {
        super(name, dob, gender, customerId, address, phone, email);
        this.bonusPoint = bonusPoint;
    }

    public long getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(long bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    @Override
    public String toString() {
        return super.toString()+"ValueAdd{" +
                "bonusPoint=" + bonusPoint +
                '}';
    }
}
