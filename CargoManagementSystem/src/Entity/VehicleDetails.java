package Entity;

import java.util.List;

public class VehicleDetails {
    private int vehicleId;
    private String vehicleName;
    private int capacity;
    private List<PackageDetails> packageDetails;

    public VehicleDetails(int vehicleId, String vehicleName, int capacity, List<PackageDetails> packageDetails) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.packageDetails = packageDetails;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<PackageDetails> getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(List<PackageDetails> packageDetails) {
        this.packageDetails = packageDetails;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                ", capacity=" + capacity +
                ", packageDetails=" + packageDetails +
                '}';
    }
}
