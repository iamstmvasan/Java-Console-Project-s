package Service;

import Entity.*;
import Exceptional.InvalidVehicleException;
import Exceptional.VehicleCapacityAlreadyExceeded;

import java.util.*;
import java.util.stream.Collectors;

public class CargoManagement implements ManageCargo {
    List<VehicleDetails> vehicleDetailsList = new ArrayList<>();
    Set<PackageDetails> packageDetailsList = new HashSet<>();


    public List<VehicleDetails> getVehicleDetailsList() {
        return vehicleDetailsList;
    }

    public void setVehicleDetailsList(List<VehicleDetails> vehicleDetailsList) {
        this.vehicleDetailsList = vehicleDetailsList;
    }

    public Set<PackageDetails> getPackageDetailsList() {
        return packageDetailsList;
    }

    public void setPackageDetailsList(Set<PackageDetails> packageDetailsList) {
        this.packageDetailsList = packageDetailsList;
    }

    @Override
    public void addPackageToVehicle(PackageDetails packageDetails, int vehicleId)
                                                    throws InvalidVehicleException, VehicleCapacityAlreadyExceeded {
        List<VehicleDetails> detailsList = vehicleDetailsList.stream().
                filter(i -> i.getVehicleId() == vehicleId).
                collect(Collectors.toList());

        if( detailsList.isEmpty() )
            throw new InvalidVehicleException("Vehicle Id could not match !");

        VehicleDetails vehicleDetails = detailsList.get(0);

        if( vehicleDetails.getCapacity() <= vehicleDetails.getPackageDetails().size())
            throw new VehicleCapacityAlreadyExceeded("Vehicle Capacity Already Exceed !");

        packageDetails.setStatus("UnDelivered");
        packageDetailsList.add(packageDetails);
        vehicleDetails.getPackageDetails().add(packageDetails);
    }


    @Override
    public VehicleDetails fetchPackage(int packageId) {
        /*VehicleDetails result = null;
        for(VehicleDetails vehicleDetails : vehicleDetailsList)
            for (PackageDetails packageDetails : vehicleDetails.getPackageDetails())
                if( packageDetails.getPackageId() == packageId ){
                    result = vehicleDetails;
                    return vehicleDetails;
                }*/


        List<VehicleDetails> detailsList = vehicleDetailsList.stream().filter(i -> i.getPackageDetails().stream().
                        filter(j -> j.getPackageId() == packageId).count() != 0 ).collect(Collectors.toList());

        return detailsList.get(0);
    }

    @Override
    public void deliverPackage(int packageId) {
        PackageDetails packageDetails = packageDetailsList.stream().
                filter(i -> i.getPackageId() == packageId && i.getStatus().equalsIgnoreCase("UnDelivered")).
                collect(Collectors.toList()).get(0);



        List<VehicleDetails> vehicleDetails = vehicleDetailsList.stream().
                        filter(i -> i.getPackageDetails().stream().filter(j -> j.getPackageId() == packageId).
                        count() != 0).collect(Collectors.toList());

        VehicleDetails v = vehicleDetails.get(0);
        v.getPackageDetails().remove(packageDetails);
        packageDetails.setStatus("Delivered");
        v.getPackageDetails().add(packageDetails);

    }

    @Override
    public List<PackageDetails> deliveryPendingPackages() {
        List<PackageDetails> packageDetails = packageDetailsList.stream().
                filter(i -> i.getStatus().equalsIgnoreCase("UnDelivered")).
                sorted(Comparator.comparingInt(PackageDetails::getPackageId)).collect(Collectors.toList());

        return packageDetails;

    }

    @Override
    public Map<Integer, Integer> fetchUndeliveredPackages() {

        Map<Integer, Integer> map = new HashMap<>();
        for(VehicleDetails vehicleDetails : vehicleDetailsList){
            int vehicleId = vehicleDetails.getVehicleId(), count = 0;
            for(PackageDetails packageDetails : vehicleDetails.getPackageDetails())
                if(packageDetails.getStatus().equalsIgnoreCase("UnDelivered"))
                    count++;
            map.put(vehicleId, count);
        }
        return map;


    }
    public void disp(){
        for (VehicleDetails v : vehicleDetailsList)
            if(v instanceof TruckDetails)
                System.out.println((TruckDetails)v);
            else
                System.out.println((AirCargoDetails)v);
    }
}
