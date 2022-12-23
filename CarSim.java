import java.io.IOException;
import javax.swing.*;
public class CarSim extends JFrame {  
    
    public static void main(String[] args) {
        CarController cS= new CarController();
        CarView cV= new CarView("CarSim 1.0", cS);

    }
}