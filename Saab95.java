import java.awt.*;

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

}
