import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(4,200,250,Color.red,"Volvo 240 Double Turbo rs6 forged in hell"));
        cc.cars.add(new Saab95(4, 175, 250, Color.orange, "Saab 95 C63 AMG super"));
        cc.cars.add(new Scania(2, 400, 50, Color.PINK, "Leif's Scania A-Traktor Super Turbo Böttad"));
        cc.cars.add(new Transporter(2,420, 100, Color.black, "Kodak's Transporter Of Grass Clippings"));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        try {
            cc.frame.getDrawPanel().addGraphicalCar(ImageIO.read(new File("Volvo240.jpg")) , cc.cars.get(0).getUniqueID());
            cc.frame.getDrawPanel().addGraphicalCar(ImageIO.read(new File("Saab95.jpg")) , cc.cars.get(1).getUniqueID());
            cc.frame.getDrawPanel().addGraphicalCar(ImageIO.read(new File("Scania.jpg")) , cc.cars.get(2).getUniqueID());
            cc.frame.getDrawPanel().addGraphicalCar(ImageIO.read(new File("Scania.jpg")) , cc.cars.get(3).getUniqueID());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.getDrawPanel().getGraphicalCars().stream().filter(graphicalCar -> graphicalCar.getUniqueID().equals(car.getUniqueID())).forEach(graphicalCar -> graphicalCar.movePoints(x, y));
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.brake(brake);
        }
    }
}
