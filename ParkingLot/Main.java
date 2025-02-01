import Vehicles.Bike;
import Vehicles.Car;
import Vehicles.Truck;
import Vehicles.Vehicle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("This is Parking lot");

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(1,5);

        Vehicle i10 = new Car("BR01");
        Vehicle pulsar = new Bike("HR01");
        Vehicle tata = new Truck("PU01");
        Vehicle hayabusa = new Bike("UP01");

        parkingLot.parkVehicle(i10);
        parkingLot.parkVehicle(pulsar);
        parkingLot.parkVehicle(tata);
        parkingLot.parkVehicle(hayabusa);

        parkingLot.displayParking();

        parkingLot.unParkVehicle(i10);
        parkingLot.displayParking();
    }
}