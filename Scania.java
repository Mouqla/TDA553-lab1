import java.awt.*;

public class Scania extends Car{

    private double platAngle;
    private final static double platMax = 70;
    private final static double platMin = 0;
    private final static double platAngleamount = 5;

    private Scania() {
        nrDoors = 2;
        color = Color.black; 
        enginePower = 75;
        modelName = "Scania";
        stopEngine();
    }
    
    
    public void raise(){
        double currentValue = platAngle;
        if (currentSpeed == 0 && platAngle < platMax){
            currentValue += platAngleamount;
            if(currentValue > platMax){
                platAngle = platMax;
            
            } else platAngle = currentValue;
        }
    }
    public void lower(){
        double currentValue = platAngle;
        if (currentSpeed == 0 && platAngle > platMin ){
            currentValue -= platAngleamount;
            if(currentValue < platMin){
                platAngle = platMin;
            
            } else platAngle = currentValue; 
        }

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
        if (amount <=1 && amount >=0 && platAngle == platMin ){
            incrementSpeed(amount);
        }
        else
        {
            incrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 ");
        }
    }
        
    public void brake(double amount) {
        if (amount <=1 && amount >=0  ){
            decrementSpeed(amount);
        }
        else
        {   decrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 ");}
    }
    
}
