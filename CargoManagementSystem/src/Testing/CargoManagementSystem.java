package Testing;

import Entity.AirCargoDetails;
import Entity.PackageDetails;
import Entity.TruckDetails;
import Entity.VehicleDetails;
import Exceptional.InvalidVehicleException;
import Exceptional.VehicleCapacityAlreadyExceeded;
import Service.CargoManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CargoManagementSystem {
    public static void main(String[] args) {
        CargoManagement cargoManagement = new CargoManagement();

        PackageDetails p1 = new PackageDetails(10, "UnDelivered");
        PackageDetails p2 = new PackageDetails(11, "UnDelivered");
        PackageDetails p3 = new PackageDetails(12, "UnDelivered");
        PackageDetails p4 = new PackageDetails(13, "UnDelivered");
        PackageDetails p5 = new PackageDetails(14, "UnDelivered");
        PackageDetails p6 = new PackageDetails(15, "Delivered");

        Set<PackageDetails> packageDetailsList = new HashSet<>();
        packageDetailsList.add(p1);
        packageDetailsList.add(p2);
        packageDetailsList.add(p3);
        packageDetailsList.add(p4);
        packageDetailsList.add(p5);
        packageDetailsList.add(p6);

        cargoManagement.setPackageDetailsList(packageDetailsList);

        List<PackageDetails> tPackageDetailsList = new ArrayList<>();
        tPackageDetailsList.add(p1);
        tPackageDetailsList.add(p2);
        tPackageDetailsList.add(p3);
        List<PackageDetails> aPackageDetailsList = new ArrayList<>();
        aPackageDetailsList.add(p4);
        aPackageDetailsList.add(p5);
        aPackageDetailsList.add(p6);

        VehicleDetails v1 = new TruckDetails(100, "Thiru", 4, tPackageDetailsList, 2500.00);
        VehicleDetails v2 = new AirCargoDetails(101, "Malai", 5, aPackageDetailsList, 1500.00);


        List<VehicleDetails> vehicleDetailsList = new ArrayList<>();
        vehicleDetailsList.add(v1);
        vehicleDetailsList.add(v2);

        cargoManagement.setVehicleDetailsList(vehicleDetailsList);


        // Add Package to Vehicle
        try{
            cargoManagement.addPackageToVehicle(p5, 100);
        }catch (InvalidVehicleException e){
            System.out.println(e);
        }catch (VehicleCapacityAlreadyExceeded v){
            System.out.println(v);
        }

        //Fetch package from VehicleDetails List
        System.out.println("Fetch package by Id -> "+ cargoManagement.fetchPackage(15) );
        System.out.println("---------------------------------------------------------------------------------");


        //Deliver package
        cargoManagement.deliverPackage(10);


        System.out.println("Delivery Pending Packages -> "+ cargoManagement.deliveryPendingPackages() );
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Fetch Undelivered Packages -> "+cargoManagement.fetchUndeliveredPackages());

        System.out.println("---------------------------------------------------------------------------------");
    }
}
