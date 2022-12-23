import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


public class CarModel extends JPanel
{
    List<Car> cars = new ArrayList<>();
    List<Observer> observers = new ArrayList<>();
   
    
    //Constructor
    public CarModel()
    {
        cars.add(new Volvo240(4,200,250,Color.red,"Volvo240",0,0));
        cars.add(new Saab95(4, 175, 250, Color.orange, "Saab95",100,0));
        cars.add(new Scania(2, 400, 50, Color.PINK, "Scania",200,0));
        cars.add(new Transporter(2,420, 100, Color.black, "Transporter",300,0));
        
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public void moveCars()
    {
        for (Car car : cars)
        {
            car.move();
            
        }
        notifyView();
    }

    // Calls the gas method for each car once
    public void carsGas(double amount) {
        for (Car car : cars) 
        {
            car.gas(amount);
        }
    }
    public void carsBrake(double amount) { 
        for (Car car : cars)
        {
            car.brake(amount);
        }
    }
    public void notifyView()
    {
        for (Observer observer : observers)
        {
            observer.update();
        }
    }
}