import org.junit.Assert;
import java.util.*;
import java.util.List;
import java.util.stream.*;
import java.awt.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class CarMain { 
    private static List<Car> createCars(){
        List<Car> cars = new ArrayList<Car>(10);
        cars.add(new Saab95(4, 175, 180, Color.black, "Saab95"));
        cars.add(new Volvo240(4, 210,200, Color.white, "Volvo240"));
        cars.add(new Scania(2, 75, 100, Color.red, "Scania"));
        return cars;
    }

    @ParameterizedTest
    @MethodSource("engine")
    void testEngine(Car carToTest) {
        carToTest.startEngine(); 
        double expectedStartSpeed = 0.1;
        double carSpeedOnStart = carToTest.getCurrentSpeed();
        Assert.assertEquals(expectedStartSpeed, carSpeedOnStart, 0);
        carToTest.stopEngine();
        double expectedStopSpeed = 0;
        double carSpeedAfterStop = carToTest.getCurrentSpeed();
        Assert.assertEquals(expectedStopSpeed, carSpeedAfterStop, 0);
    }

    @ParameterizedTest
    @MethodSource("doors")
    void testDoors(Car carToTest) {
        if (carToTest.getModelName() == "Scania") {
            int expectedNrOfDoors = 2;
            Assert.assertEquals(expectedNrOfDoors, carToTest.getNrDoors(), 0);
        } else if (carToTest.getModelName() == "Volvo240") {
            int expectedNrOfDoors = 4;
            Assert.assertEquals(expectedNrOfDoors, carToTest.getNrDoors(), 0);
        } else if (carToTest.getModelName() == "Saab95") {
            int expectedNrOfDoors = 4;
            Assert.assertEquals(expectedNrOfDoors, carToTest.getNrDoors(), 0);
        }
    }

    @ParameterizedTest
    @MethodSource("power")
    void testPower(Car carToTest) {
        if (carToTest.getModelName() == "Scania") {
            int expectedPower = 75;
            Assert.assertEquals(expectedPower, carToTest.getEnginePower(), 0);
        } else if (carToTest.getModelName() == "Volvo240") {
            int expectedPower = 210;
            Assert.assertEquals(expectedPower, carToTest.getEnginePower(), 0);
        } else if (carToTest.getModelName() == "Saab95") {
            int expectedPower = 210;
            Assert.assertEquals(expectedPower, carToTest.getEnginePower(), 0);
        }
    }

    @ParameterizedTest
    @MethodSource("getColor")
    void testGetColor(Car carToTest) {
        if (carToTest.getModelName() == "Scania") {
            Color expectedColor = Color.red;
            Assert.assertEquals(expectedColor, carToTest.getColor());
        } else if (carToTest.getModelName() == "Volvo240") {
            Color expectedColor = Color.white;
            Assert.assertEquals(expectedColor, carToTest.getColor());
        } else if (carToTest.getModelName() == "Saab95") {
            Color expectedColor = Color.black;
            Assert.assertEquals(expectedColor, carToTest.getColor());
        }
    }

    @ParameterizedTest
    @MethodSource("setColor")
    void testSetColor(Car carToTest) {
        Color expectedSetColor = Color.blue;
        carToTest.setColor(Color.blue);
        Assert.assertEquals(expectedSetColor, carToTest.getColor());
    } 

    @ParameterizedTest
    @MethodSource("move")
    void testMove (Car testCar) {
        testCar.startEngine();
        testCar.turnRight();
        double currentX = testCar.getX();
        double currentY = testCar.getY();
        double exp = (currentX += testCar.getCurrentSpeed());
        testCar.move();
        Assert.assertEquals(exp, testCar.getX(), 0);
        testCar.turnRight();
        double nextExp = (currentY -= testCar.getCurrentSpeed());
        testCar.move();
        Assert.assertEquals(nextExp, currentY, 0);
    }
    
    @ParameterizedTest
    @MethodSource("gas")
    void testGas(Car carToTest) {
        double expectedIncrementSpeed = carToTest.getCurrentSpeed() + carToTest.speedFactor() * 1;
        carToTest.gas(1);
        Assert.assertEquals(expectedIncrementSpeed, carToTest.getCurrentSpeed(), 0);
        double expectedDecrementSpeed = carToTest.getCurrentSpeed() - carToTest.speedFactor() * 0.5;
        carToTest.brake(0.5);
        Assert.assertEquals(expectedDecrementSpeed, carToTest.getCurrentSpeed(), 0);
    }

    @ParameterizedTest
    @MethodSource("speed")
    void testSpeed(Car carToTest) {
        double expectedIncrementSpeed = Math.min(carToTest.getCurrentSpeed() + carToTest.speedFactor() * 0.5, carToTest.getTopSpeed());
        carToTest.incrementSpeed(0.5);
        Assert.assertEquals(expectedIncrementSpeed, carToTest.getCurrentSpeed(), 0);
        double expectedDecrementSpeed = Math.max(carToTest.getCurrentSpeed() - carToTest.speedFactor() * 1, 0);;
        carToTest.decrementSpeed(1);
        Assert.assertEquals(expectedDecrementSpeed, carToTest.getCurrentSpeed(), 0);
    }

    @ParameterizedTest
    @MethodSource("speedFactorSaab")
    void testSpeedFactor(Saab95 carToTest) {
        carToTest.setTurboOn();
        double expectedSpeedFactorWithTurbo = carToTest.getEnginePower() * 0.01 * 1.3;
        Assert.assertEquals(expectedSpeedFactorWithTurbo, carToTest.speedFactor(), 0);
        carToTest.setTurboOff();
        double expectedSpeedFactorWithoutTurbo = carToTest.getEnginePower() * 0.01 * 1;
        Assert.assertEquals(expectedSpeedFactorWithoutTurbo, carToTest.speedFactor(), 0);
    }

    static Stream<Car> engine() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> doors() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> power() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> getColor() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> setColor() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> move() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> gas() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Car> speed() {
        return Stream.of(createCars().stream().toArray(Car[]::new));
    }

    static Stream<Saab95> speedFactorSaab() {
        return Stream.of(new Saab95(4, 175, 180, Color.black, "Saab95"));
    }
}
    

