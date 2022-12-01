import java.awt.*;
import java.util.ArrayList;

public class Transporter extends Car{

    // if ramp is false, the ramp is lowered
    private boolean ramp = false;
    private ArrayList<Car> carsStorage = new ArrayList<Car>();
    private int storageCapacity = 2;
    private double loadingDistance = 20;

    private Transporter() {
        nrDoors = 2;
        color = Color.black; 
        enginePower = 75;
        modelName = "Transporter";
        stopEngine();
    }

    public void LoadCar(Car carToLoadCar) {
        if(CheckDistance(carToLoadCar) <= loadingDistance && ramp == false) {
            if(carsStorage.size() < storageCapacity) {
                carsStorage.add(carToLoadCar);
                System.out.print("Car Loaded");
            } else System.out.print("The transporter is full of cars at the moment");
        } else System.out.print("The transporter is not close enough at the moment");
    }

    public void UnloadCar(Car carToUnload) {
        if(ramp == false) {
            carsStorage.remove(carToUnload);
        } else System.out.print("The transporter ramp is not down.");
    }

    public void UnloadCarIndex(int carToUnloadIndex) {
        if(ramp == false) {
            carsStorage.remove(carToUnloadIndex);
        } else System.out.print("The transporter ramp is not down.");
    }

    public Double CheckDistance(Car carPos) {
        double distanceBetweenObjects = Math.sqrt(Math.pow((this.x-carPos.x),2)
                                                + Math.pow((this.y-carPos.y),2));
        return distanceBetweenObjects;
    }
    
    public void lowerRamp() {
        if(currentSpeed == 0) {
            ramp = false;
        }
    }

    public void raiseRamp() {
        ramp = true;
    }

    private double speedFactor() {
        return enginePower * 0.01;
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if(amount <=1 && amount >=0 && ramp == true) {
            incrementSpeed(amount);
        } else {
            incrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 ");
        }
    }
        
    public void brake(double amount) {
        if(amount <=1 && amount >=0) {
            decrementSpeed(amount);
        } else {
            decrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 ");
        }
    }
    
}
