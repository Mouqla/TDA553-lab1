import java.awt.*;

public class Saab95 extends Car{

    public Saab95(int nrDoors, double enginePower, double topSpeed, Color color, String modelName,double xPos,double yPos) {
        super(nrDoors, enginePower, topSpeed, color, modelName,xPos,yPos);
        stopEngine();
    }

    public void setTurboOn() {
        setTurboValue(1.3);
    }

    public void setTurboOff() {
        setTurboValue(1);
    }

}
