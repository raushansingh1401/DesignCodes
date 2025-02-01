package Vehicles;

public abstract class Vehicle {
    private String numberPlate;
    private VehicleType type;

    public Vehicle(String plate, VehicleType type){
        this.numberPlate = plate;
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getType(){
        return type;
    }
}
