import java.util.*;
import java.awt.*;

public class Trucks extends Car{ 
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double topSpeed; // The top speed of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double platAngle = 0;
    private final static double platMax = 70;
    private final static double platMin = 0;
    private final static double platAngleamount = 5;
    private boolean ramp = true;
    
    public Trucks(int nrDoors, double enginePower, double topSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, topSpeed, color, modelName);
    }
    public void raise(){
        double currentValue = platAngle;
        if (getCurrentSpeed() == 0 && platAngle < platMax){
            currentValue += platAngleamount;
            if(currentValue > platMax){
                platAngle = platMax;
            
            } else platAngle = currentValue;
        }
    }
    
    public void lower(){
        double currentValue = platAngle;
        if (getCurrentSpeed() == 0 && platAngle > platMin ){
            currentValue -= platAngleamount;
            if(currentValue < platMin){
                platAngle = platMin;
            
            } else platAngle = currentValue; 
        }
    }
    public void lowerRamp() {
        if(getCurrentSpeed() == 0) {
            ramp = false;
        }
    }
    
    public void raiseRamp() {
        ramp = true;
    }
}