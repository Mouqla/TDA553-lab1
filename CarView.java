import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements Observer{
    private static final int X = 800;
    private static final int Y = 800;

    private DrawPanel drawPanel;

    private JPanel controlPanel = new JPanel();

    private JPanel gasPanel = new JPanel();
    private SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
    private JSpinner gasSpinner = new JSpinner(spinnerModel);
    private int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");
    
    CarModel model;
    CarController carcController;
    double[] volvoPos;
    double[] saabPos;
    double[] scaniaPos;
    double[] transporterPos;
    // Constructor
    public CarView(String framename,CarController controller, CarModel model){
        this.carcController = controller;
        this.model = model;
        this.drawPanel = new DrawPanel(true,800,500,model);
        initComponents(framename);
        update();
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JSpinner getGasSpinner() {
        return gasSpinner;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int amount) {
        gasAmount = amount;
    }
    

    

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        
        

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e)
            {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);



        gasButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                carcController.gas(gasAmount);
                
            }
        });
        brakeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                carcController.brake(15);
                
            }
        });
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        double[] volvoPos = model.cars.get(0).getPosition();
        double[] saabPos = model.cars.get(1).getPosition();
        double[] scaniaPos = model.cars.get(2).getPosition();
        double[] transporterPos = model.cars.get(3).getPosition();
        
        drawPanel.repaint();
        
    }
}
