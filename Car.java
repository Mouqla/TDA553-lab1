import java.awt.*;
import java.util.UUID;



public class Car implements Movable{

    private int cardinal; // Determines direction of the car
    private double x; // X value of the car
    private double y; // Y value of the car
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double topSpeed; // The top speed of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double turbo = 1; // Turbo value
    private String uniqueID;

    public Car(int nrDoors, double enginePower, double topSpeed, Color color, String modelName,double xPos, double yPos) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.topSpeed = topSpeed;
        this.color = color;
        this.modelName = modelName;
        this.uniqueID = UUID.randomUUID().toString();
        this.x = xPos;
        this.y = yPos;
    }

    public double[] getPosition() {
        double[] position = {x,y};
        return position;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void setTurboValue(double turbo) {
        this.turbo = turbo;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getTopSpeed());
        
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if (amount<=1 && amount >=0 )
        {
                        incrementSpeed(amount);
        }
        else
        {
            System.out.print("Wrong value! Try between 0 and 1 ");
        }
    }
        
    public void brake(double amount) {
        if (amount<=1 && amount >=0 ){
            decrementSpeed(amount);
        }
        else
        {  
            System.out.print("Wrong value! Try between 0 and 1 ");}
    }


    @Override
    public void move() {
        
        switch (cardinal % 360) {
            case 0:
                y += currentSpeed;
                break;
            case 90:
                x += currentSpeed;
                break;
            case 180:
                y -= currentSpeed;
                break;
            case 270:
                x -= currentSpeed;
                break;
        }
    }

    @Override
    public void turnLeft() {
        cardinal -= 90;
    }

    @Override
    public void turnRight() {
        cardinal += 90;
    }

   
}