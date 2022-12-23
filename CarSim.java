import java.io.IOException;
import javax.swing.*;
public class CarSim extends JFrame {  
    
    public static void main(String[] args) {
        CarModel model = new CarModel();
        CarController carController= new CarController(model);
        CarView carView= new CarView("SwagalamFam", carController,model);

        model.observers.add(carView);
        carController.timer.start();
    }
}