package Testing;

import Entity.ResidentVehicle;
import Entity.Vehicle;
import Entity.VisitorVehicle;
import Exception.*;
import Service.ParkingManagement;

public class ParkingDemo {
    public static void main(String[] args) {
        ParkingManagement parkingManagement = new ParkingManagement();

        try {
            System.out.println( parkingManagement.addVehicle(new ResidentVehicle(
                    "TN49A2222",
                    "Senthil",
                    1212121212,
                    201,
                    true)));
        }catch (ParkingSlotNotAvailableException e){
            System.out.println(e);
        }

        try {
            System.out.println( parkingManagement.addVehicle(new ResidentVehicle(
                    "TN49B4444",
                    "Ragavan",
                    1414141414,
                    202,
                    false)));
        }catch (ParkingSlotNotAvailableException e){
            System.out.println(e);
        }

        try {
            System.out.println( parkingManagement.addVehicle(new ResidentVehicle(
                    "TN49C6666",
                    "Srimathi",
                    1616161616,
                    204,
                    true)));
        }catch (ParkingSlotNotAvailableException e){
            System.out.println(e);
        }

        try {
            System.out.println( parkingManagement.addVehicle(new VisitorVehicle(
                    "TN49A2222",
                    "Senthil",
                    1212121212,
                    201,
                    9)));
        }catch (ParkingSlotNotAvailableException e){
            System.out.println(e);
        }

        try {
            System.out.println( parkingManagement.addVehicle(new VisitorVehicle(
                    "TN49B4444",
                    "Ragavan",
                    1414141414,
                    202,
                    8)));
        }catch (ParkingSlotNotAvailableException e){
            System.out.println(e);
        }

        try {
            System.out.println( parkingManagement.addVehicle(new VisitorVehicle(
                    "TN49C6666",
                    "Srimathi",
                    1616161616,
                    204,
                    15)));
        }catch (ParkingSlotNotAvailableException e){
            System.out.println(e);
        }

        try{
            System.out.println(parkingManagement.setVisitorVehicleOutTime("TN49C6666", 16));
        } catch (VehicleNotFoundException e) {
            System.out.println(e);
        }

        System.out.println("Parked Resident Vehicle Count -> "+parkingManagement.getParkedResidentVehicleCount());
        System.out.println("All Vehicles -> \n "+parkingManagement.displayAllVehicles());

    }
}
