import static org.junit.Assert.assertEquals;

import java.awt.*;

import org.junit.jupiter.api.Test;

public class Saab95 extends Car{

    public Saab95(int nrDoors, double enginePower, double topSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, topSpeed, color, modelName);
        stopEngine();
    }

    public void setTurboOn() {
        setTurboValue(1.3);
    }

    public void setTurboOff() {
        setTurboValue(1);
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
        double expectedIncrementSpeed = getCurrentSpeed() + speedFactor() * 10.5;
        gas(10.5);
        assertEquals(getCurrentSpeed(), expectedIncrementSpeed, 0);
        double expectedDecrementSpeed = getCurrentSpeed() - speedFactor() * 10.5;
        brake(10.5);
        assertEquals(getCurrentSpeed(), expectedDecrementSpeed, 0);
    }

    @Test
    public void testSpeed() {
        double expectedIncrementSpeed = getCurrentSpeed() + speedFactor() * 10.5;
        incrementSpeed(10.5);
        assertEquals(getCurrentSpeed(), expectedIncrementSpeed, 0);
        double expectedDecrementSpeed = getCurrentSpeed() - speedFactor() * 10.5;
        decrementSpeed(10.5);
        assertEquals(getCurrentSpeed(), expectedDecrementSpeed, 0);
    }

    @Test
    public void testSpeedFactor() {
        setTurboOn();
        assertEquals(speedFactor(), getEnginePower() * 0.01 * 1.3, 0);
        setTurboOff();
        assertEquals(speedFactor(), getEnginePower() * 0.01 * 1, 0);
    }
}
