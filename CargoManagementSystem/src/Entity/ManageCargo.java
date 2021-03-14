package Entity;

import Exceptional.InvalidVehicleException;
import Exceptional.VehicleCapacityAlreadyExceeded;

import java.util.List;
import java.util.Map;

public interface ManageCargo {
    void addPackageToVehicle(PackageDetails packageDetails, int vehicleId) throws InvalidVehicleException, VehicleCapacityAlreadyExceeded;
    VehicleDetails fetchPackage(int packageId);
    void deliverPackage(int packageId);
    List<PackageDetails> deliveryPendingPackages();
    Map<Integer, Integer> fetchUndeliveredPackages();
}
