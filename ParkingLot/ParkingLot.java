import Vehicles.Vehicle;
import Vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

   private static volatile ParkingLot parkingLot;

   private ParkingLot() {
   }

   public static ParkingLot getInstance(){
       if(parkingLot == null){
           synchronized (ParkingLot.class){
               if(parkingLot == null){
                   parkingLot = new ParkingLot();
               }
           }
       }
       return parkingLot;
   }

   private final List<Level> levels = new ArrayList<>();

   public void addLevel(int floor, int capacity){
       levels.add(new Level(floor, capacity));
   }

   public boolean parkVehicle(Vehicle vehicle){
       boolean parked = false;
       for(Level level : levels) {
           if(level.spotAvailable(vehicle.getType())){
               level.park(vehicle);
               parked = true;
               System.out.println("Vehicle parked. Details - " + vehicle.getNumberPlate());
               break;
           }
       }
       if(!parked){
           System.out.println("Parking full");
       }
       return parked;
   }

   public boolean unParkVehicle(Vehicle vehicle) {
       boolean unpark = false;
       for (Level level : levels) {
           int spotNum = level.findVehicle(vehicle);
           if (spotNum != 0) {
               level.unpark(spotNum);
               unpark = true;
               System.out.println("Vehicle unparked. Number plate - " + vehicle.getNumberPlate());
               break;
           }
       }
       if (!unpark) {
           System.out.println("Vehicle not found");
       }
       return unpark;
   }

   public void displayParking() {
       for(Level level : levels){
           level.displayLevel();
       }
   }


}
