import Vehicles.Vehicle;
import Vehicles.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private boolean isAvailable;
    private VehicleType type;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.isAvailable = true;
        this.type = type;
        this.vehicle = null;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied(){
        return !isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void occupy(Vehicle vehicle){
        this.vehicle = vehicle;
        isAvailable = false;
    }

    public void free() {
        this.vehicle = null;
        isAvailable = true;
    }
}
