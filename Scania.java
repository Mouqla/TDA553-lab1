import java.awt.*;

public class Scania extends Car{

    private double platAngle = 0;
    private final static double platMax = 70;
    private final static double platMin = 0;
    private final static double platAngleamount = 5;

    public Scania(int nrDoors, double enginePower, double topSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, topSpeed, color, modelName);
        stopEngine();
    } 
    @Override
    public void gas(double amount) {
        if (amount <=1 && amount >=0 && platAngle == platMin ){
            incrementSpeed(amount);
        }
        else
        {
            incrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1  or the angle of the ramp is too high");
        }
    }
}
