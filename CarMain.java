import static org.junit.Assert.assertEquals;
import java.util.*;
import java.awt.*;
import org.junit.jupiter.api.Test;

import java.util.List;
public class CarMain { 
    public static List createCars(){
        List<Car> cars = new ArrayList<Car>(10);
        cars.add(new Saab95(4, 175, 180, Color.black, "Saab95"));
        cars.add(new Volvo240(4, 210,200, Color.white, "Volvo240"));
        cars.add(new Scania(2, 75, 100, Color.red, "Scania"));
        return cars;
    }
    @Test
    public static void testEngine(Car carToTest) {
        carToTest.startEngine(); 
        double expectedStartSpeed = 0.1;
        double carCurrentspeed = carToTest.getCurrentSpeed();
        assertEquals(carCurrentspeed, expectedStartSpeed, 0);
        carToTest.stopEngine();
        double expectedStopSpeed = 0;
        assertEquals(carCurrentspeed, expectedStopSpeed, 0);
    }
    @Test
    public static void testDoors(Car carToTest) {
        int expectedDoors = 5;
        assertEquals(carToTest.getNrDoors(), expectedDoors);
    }

    @Test
    public static void testPower(Car carToTest) {
        double expectedPower = 480.5;
        assertEquals(carToTest.getEnginePower(), expectedPower, 0);
    }
    @Test
    public static void testGetColor(Car carToTest) {
        Color expectedGetColor = Color.black;
        assertEquals(carToTest.getColor(), expectedGetColor);
    }

    @Test
    public static void testSetColor(Car carToTest) {
        Color expectedSetColor = Color.red;
        carToTest.setColor(Color.red);
        assertEquals(carToTest.getColor(), expectedSetColor);
    }     
    @Test
    public static void testMove (Car testCar) {
        testCar.startEngine();
        testCar.turnRight();
        double currentX = testCar.getX();
        double currentY = testCar.getY();
        double exp = (currentX -= testCar.getCurrentSpeed());
        testCar.move(currentX,currentY);
        assertEquals(testCar.getX(), exp, 0);
        testCar.turnRight();
        double nextExp = (currentY -= testCar.getCurrentSpeed());
        testCar.move(currentX,currentY);
        assertEquals(currentY, nextExp, 0);
    }
    @Test
    public static void testGas(Car carToTest) {
        double expectedIncrementSpeed = carToTest.getCurrentSpeed() + carToTest.speedFactor() * 10.5;
        carToTest.gas(1);
        assertEquals(carToTest.getCurrentSpeed(), expectedIncrementSpeed, 0);
        double expectedDecrementSpeed = carToTest.getCurrentSpeed() - carToTest.speedFactor() * 10.5;
        carToTest.brake(0.5);
        assertEquals(carToTest.getCurrentSpeed(), expectedDecrementSpeed, 0);
    }
    @Test
    public static void testSpeed(Car carToTest) {
        double expectedIncrementSpeed = carToTest.getCurrentSpeed() + carToTest.speedFactor() * 10.5;
        carToTest.incrementSpeed(0.5);
        assertEquals(carToTest.getCurrentSpeed(), expectedIncrementSpeed, 0);
        double expectedDecrementSpeed = carToTest.getCurrentSpeed() - carToTest.speedFactor() * 10.5;
        carToTest.decrementSpeed(1);
        assertEquals(carToTest.getCurrentSpeed(), expectedDecrementSpeed, 0);
    }
    @Test
    public static void testSpeedFactor(Saab95 carToTest) {
        carToTest.setTurboOn();
        assertEquals(carToTest.speedFactor(), carToTest.getEnginePower() * 0.01 * 1.3, 0);
        carToTest.setTurboOff();
        assertEquals(carToTest.speedFactor(), carToTest.getEnginePower() * 0.01 * 1, 0);
    }
    public static void main(String[] args) { 
        
        List<Car> cars = createCars();
        for(Car car : cars)
        {
            testEngine(car);
            testDoors(car);
            testPower(car);
            testGetColor(car);
            testSetColor(car);
            testMove(car);
            testGas(car);
            testSpeed(car);
            if (car.getModelName()=="Saab95")
            {
                System.out.println("SAABJÄVEL");
            }   
        }
        
    }  
}
    

