import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, double topSpeed, Color color, String modelName,double xPos,double yPos) {
        super(nrDoors, enginePower, topSpeed, color, modelName,xPos,yPos);
        stopEngine();
        setTurboValue(trimFactor);
    }
    
    
}
