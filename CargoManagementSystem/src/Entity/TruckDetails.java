package Entity;

import java.util.List;

public class TruckDetails extends VehicleDetails{
    private double roadTax;

    public TruckDetails(int vehicleId, String vehicleName, int capacity, List<PackageDetails> packageDetails, double roadTax) {
        super(vehicleId, vehicleName, capacity, packageDetails);
        this.roadTax = roadTax;
    }

    public double getRoadTax() {
        return roadTax;
    }

    public void setRoadTax(double roadTax) {
        this.roadTax = roadTax;
    }

    @Override
    public String toString() {
        return super.toString()+"TruckDetails{" +
                "roadTax=" + roadTax +
                '}';
    }
}
