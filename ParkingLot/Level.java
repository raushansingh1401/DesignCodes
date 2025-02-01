import Vehicles.Vehicle;
import Vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> spots;

    public Level(int floor, int capacity){
        this.spots = new ArrayList<>();
        this.floor = floor;

        int numSpots = capacity;
        double divBikes = 0.5;
        double divCars = 0.4;
        double divTrucks = 0.1;

        int numBikesSpots = (int) (divBikes * numSpots);
        int numCarsSpots = (int) (divCars * numSpots);
        int numTrucksSpots = (int) (divTrucks * numSpots);

        int i = 1;
        for(; i <= numBikesSpots; i++){
            spots.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for(; i <= numBikesSpots + numCarsSpots; i++){
            spots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for(; i <= numBikesSpots + numCarsSpots + numTrucksSpots; i++){
            spots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public boolean spotAvailable(VehicleType vehicleType){
        for(ParkingSpot spot : spots){
            if(!spot.isOccupied() && spot.getType() == vehicleType){
                return true;
            }
        }
        return false;
    }

    public void park(Vehicle vehicle){
        for(ParkingSpot spot : spots){
            if(!spot.isOccupied() && vehicle.getType() == spot.getType()){
                spot.occupy(vehicle);
                break;
            }
        }
    }

    public int findVehicle(Vehicle vehicle){
        for(ParkingSpot spot : spots){
            if(spot.getVehicle() == vehicle){
                return spot.getSpotNumber();
            }
        }
        return 0;
    }

    public void unpark(int spotNum){
        for(ParkingSpot spot : spots){
            if(spot.getSpotNumber() == spotNum){
                spot.free();
                break;
            }
        }
    }

    public void displayLevel() {
        System.out.println("At level - " + floor);
        for(ParkingSpot spot : spots){
            if(spot.isOccupied()){
                System.out.println("Parked vehicle number - " + spot.getVehicle().getNumberPlate());
            }
        }
    }
}
