import java.awt.*;
import java.util.ArrayList;

public class Transporter extends Car{

    // if ramp is false, the ramp is lowered
    // Loading loader; 
    private boolean ramp = true;
    private ArrayList<Car> carsStorage = new ArrayList<Car>();
    private int storageCapacity = 2;
    private double loadingDistance = 20;

    public Transporter(int nrDoors, double enginePower, double topSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, topSpeed, color, modelName);
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
        double distanceBetweenObjects = Math.sqrt(Math.pow((this.getX()-carPos.getX()),2)
                                                + Math.pow((this.getY()-carPos.getY()),2));
        return distanceBetweenObjects;
    }
    
    public void lowerRamp() {
        if(getCurrentSpeed() == 0) {
            ramp = false;
        }
    }
    
    public void raiseRamp() {
        ramp = true;
    }

    @Override
    public void gas(double amount) {
        if(amount <=1 && amount >=0 && ramp == true) {
            incrementSpeed(amount);
        } else {
            incrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 or ramp is up ");
        }
    }
}
