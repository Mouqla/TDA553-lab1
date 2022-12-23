import java.awt.*;
import java.util.ArrayList;

public class Transporter extends Car{

    // if ramp is false, the ramp is lowered
    // Loading loader; 
    private boolean ramp = true;
    private ArrayList<Car> carsStorage = new ArrayList<Car>();
    private int storageCapacity = 2;
    private double loadingDistance = 20;
    private Loader loader;

    public Transporter(int nrDoors, double enginePower, double topSpeed, Color color, String modelName,double xPos,double yPos) {
        super(nrDoors, enginePower, topSpeed, color, modelName,xPos,yPos);
        stopEngine();
    }

    public void LoadCar(Car carToLoadCar) {
            if(carsStorage.size() < storageCapacity) {
                loader.LoadCar(carToLoadCar, carsStorage, loadingDistance, this.getX(), this.getY());
                System.out.print("Car Loaded");
            } 
            else System.out.print("The transporter is full of cars at the moment");
    }

    public void UnloadCar(Car carToUnload) {
        if(ramp == false) {
            loader.UnloadCar(carToUnload, carsStorage);
        } 
        else System.out.print("The transporter ramp is not down.");
    }

    public void UnloadCarIndex(int carToUnloadIndex) {
        if(ramp == false) {
            loader.UnloadCarIndex(carToUnloadIndex, carsStorage);
        } 
        else System.out.print("The transporter ramp is not down.");
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
