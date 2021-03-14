package Entity;

import java.util.List;

public class AirCargoDetails extends VehicleDetails {

    private double airForce;

    public AirCargoDetails(int vehicleId, String vehicleName, int capacity, List<PackageDetails> packageDetails, double airForce) {
        super(vehicleId, vehicleName, capacity, packageDetails);
        this.airForce = airForce;
    }

    public double getAirForce() {
        return airForce;
    }

    public void setAirForce(double airForce) {
        this.airForce = airForce;
    }

    @Override
    public String toString() {
        return super.toString()+"AirCargoDetails{" +
                "airForce=" + airForce +
                '}';
    }
}
