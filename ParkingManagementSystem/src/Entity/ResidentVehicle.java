package Entity;

public class ResidentVehicle extends Vehicle {
    private int flatNumber;
    private boolean parkedStatus;

    public ResidentVehicle(String regNumber, String ownerName, long mobileNumber, int flatNumber, boolean parkedStatus) {
        super(regNumber, ownerName, mobileNumber);
        this.flatNumber = flatNumber;
        this.parkedStatus = parkedStatus;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public boolean isParkedStatus() {
        return parkedStatus;
    }

    public void setParkedStatus(boolean parkedStatus) {
        this.parkedStatus = parkedStatus;
    }

    @Override
    public String toString() {
        return super.toString()+"ResidentVehicle{" +
                "flatNumber=" + flatNumber +
                ", parkedStatus=" + parkedStatus +
                '}';
    }
}
