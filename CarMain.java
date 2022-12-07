import TDA553.lab1.Car;
import java.util.*;
import java.awt.*;
import org.junit.jupiter.api.Test;
import java.util.List;
public class CarMain { 
    public static void main(String[] args) { 
        private List<Car> cars;
        
        public createCars(){
            cars = new ArrayList<Car>();
            cars.add(new Saab95(4, 175, 180, black, "Saab95"));
            cars.add(new Volvo240(4, 210,200, white, "Volvo240"));
            cars.add(new Scania(2, 75, 100, red, "Scania"));
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
