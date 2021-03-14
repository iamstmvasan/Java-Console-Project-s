package Service;

import Entity.ResidentVehicle;
import Entity.Vehicle;
import Entity.VisitorVehicle;
import Exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingManagement {
    private List<Vehicle> vehicleList = new ArrayList<>();
    private List<Integer> parkingSlot = new ArrayList<>();

    public String addVehicle(Vehicle  vehicle) throws ParkingSlotNotAvailableException {
             if( parkingSlot.size() < 10 ){
                 vehicleList.add(vehicle);
                 parkingSlot.add(1);
                 return "Vehicle parked at Parking Slot no : "+parkingSlot.size();
             }
             throw new ParkingSlotNotAvailableException("No Parking Slots Available !");
    }

    public String setVisitorVehicleOutTime(String regNumber, int outTime) throws VehicleNotFoundException {
        /*for (Vehicle vehicle : vehicleList)
            if(vehicle instanceof VisitorVehicle && vehicle.getRegNumber().equalsIgnoreCase(regNumber)){
                ((VisitorVehicle) vehicle).setOutTime(outTime);
                return "Vehicle with Reg Number : "+regNumber+" updated successfully";
            }
        throw new VehicleNotFoundException("Searched Vehicle Not Found: "+regNumber);*/
        List<Vehicle> vehicleList1 = (vehicleList.stream().
                                            filter(i->i instanceof  VisitorVehicle && i.getRegNumber().equalsIgnoreCase(regNumber)).
                                            collect(Collectors.toList()));
        if(vehicleList1.isEmpty())
            throw new VehicleNotFoundException("Searched Vehicle Not Found: "+regNumber);
        ((VisitorVehicle) vehicleList1.get(0)).setOutTime(outTime);
        return "Vehicle with Reg Number : "+regNumber+" updated successfully";
    }

    public int getParkedResidentVehicleCount(){
        /*int count = 0;
        for(Vehicle vehicle : vehicleList)
            if( vehicle instanceof ResidentVehicle && ((ResidentVehicle) vehicle).isParkedStatus())
                count++;
        return count;*/

        return (int)vehicleList.stream().filter(i->i instanceof ResidentVehicle && ((ResidentVehicle)i).isParkedStatus()).count();
    }

    public List<Vehicle> displayAllVehicles(){
        return vehicleList;
    }

}
