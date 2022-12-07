import static org.junit.Assert.assertEquals;

import java.awt.*;

import org.junit.jupiter.api.Test;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, double topSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, topSpeed, color, modelName);
        stopEngine();
        setTurboValue(trimFactor);
    }
    
    @Test
    public void testMove() {
        startEngine();
        turnRight();
        double currentX = getX();
        double exp = (currentX -= getCurrentSpeed());
        move(getX(), getY());
        assertEquals(getX(), exp, 0);
        turnRight();
        double currentY = getY();
        double nextExp = (currentY -= getCurrentSpeed());
        move(getX(), getY());
        assertEquals(getY(), nextExp, 0);
    }

    @Test
    public void testGas() {
        double expectedIncrementSpeed = Math.max(getCurrentSpeed() + speedFactor() * 10.5, 0);
        gas(10.5);
        assertEquals(getCurrentSpeed(), expectedIncrementSpeed, 0);
        double expectedDecrementSpeed = Math.max(getCurrentSpeed() - speedFactor() * 10.5, 0);
        brake(10.5);
        assertEquals(getCurrentSpeed(), expectedDecrementSpeed, 0);
    }

    @Test
    public void testSpeed() {
        double expectedIncrementSpeed = Math.max(getCurrentSpeed() + speedFactor() * 10.5, 0);
        incrementSpeed(10.5);
        assertEquals(getCurrentSpeed(), expectedIncrementSpeed, 0);
        double expectedDecrementSpeed = Math.max(getCurrentSpeed() - speedFactor() * 10.5, 0);
        decrementSpeed(10.5);
        assertEquals(getCurrentSpeed(), expectedDecrementSpeed, 0);
    }

    @Test
    public void testSpeedFactor() {
        assertEquals(speedFactor(), getEnginePower() * 0.01 * trimFactor, 0);
    }
}
