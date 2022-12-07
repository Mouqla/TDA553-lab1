import static org.junit.Assert.assertEquals;

import java.awt.*;

import org.junit.jupiter.api.Test;

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

    public Car(int nrDoors, double enginePower, double topSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.topSpeed = topSpeed;
        this.color = color;
        this.modelName = modelName;
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
        if (amount<=1 && amount >=0 ){
            incrementSpeed(amount);
        }
        else
        {
            incrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 ");
        }
    }
        
    public void brake(double amount) {
        if (amount<=1 && amount >=0 ){
            decrementSpeed(amount);
        }
        else
        {   decrementSpeed(0);
            System.out.print("Wrong value! Try between 0 and 1 ");}
    }

    @Override
    public void move(double x, double y) {
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

    @Test
    public void testEngine() {
        startEngine();
        double expectedStartSpeed = 0.1;
        assertEquals(currentSpeed, expectedStartSpeed, 0);
        stopEngine();
        double expectedStopSpeed = 0;
        assertEquals(currentSpeed, expectedStopSpeed, 0);
    }

    @Test
    public void testDoors() {
        int expectedDoors = 5;
        nrDoors = 5;
        assertEquals(getNrDoors(), expectedDoors);
    }

    @Test
    public void testPower() {
        double expectedPower = 480.5;
        enginePower = 480.5;
        assertEquals(getEnginePower(), expectedPower, 0);
    }

    @Test
    public void testSpeed() {
        double expectedSpeed = 285.5;
        currentSpeed = 285.5;
        assertEquals(getCurrentSpeed(), expectedSpeed, 0);
    }

    @Test
    public void testGetColor() {
        Color expectedGetColor = Color.black;
        color = Color.black;
        assertEquals(getColor(), expectedGetColor);
    }

    @Test
    public void testSetColor() {
        Color expectedSetColor = Color.red;
        setColor(Color.red);
        assertEquals(color, expectedSetColor);
    }
}