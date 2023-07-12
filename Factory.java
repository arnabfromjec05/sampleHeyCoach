
interface LogisticVehicle {
    drive();
    supply();
    offload();
}

class Truck implements Vehicle {
    public drive() {
        // drive via roadways
    }
}

class Ship implements Vehicle {
    public drive() {
        // drive via waterways
    }
}

Enum ModeOfTransport {
    "RoadWays",
    "WaterWays"
}

class VehicleFactory {
    public static Vehicle getVehicle(ModeOfTransport modeOfTransport) {
        //logic 
        if (modeOfTransport == ModeOfTransport.RoadWays) {
            return new Truck();
        } else if (modeOfTransport == ModeOfTransport.WaterWays) {
            return new Ship();
        } else {
            // default case
        }
    }    
}

// client
public static class Client {
    public static void main() {
        Vehicle vehicleWaterWays = VehicleFactory.getVehicle(ModeOfTransport.WaterWays);
        Vehicle vehicleForRoadWays = VehicleFactory.getVehicle(ModeOfTransport.RoadWays);

        // later part in client code
        vehicleForRoadWays.drive();
        vehicleForRoadWays.supply();

        vehicleForWaterWays.drive();
        vehicleForRoadWays.supply();
    }
}


// advantage:
/**
Factory design pattern provides approach to code for interface rather than implementation.
Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
Factory pattern provides abstraction between implementation and client classes through inheritance.
 * 
 * 
 */