import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    CarModel model;
    
    public CarController(CarModel model)
    {
        this.model = model;
    }
    
    final Timer timer = new Timer(50,new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            model.moveCars();
        }
    }
   
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
            model.carsGas(gas);
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        model.carsBrake(brake);
    }

   
}
