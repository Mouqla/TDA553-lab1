import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private CarModel carModel;
   
    private static List<GraphicalCar> graphicalCars = new ArrayList<GraphicalCar>();

    public void addGraphicalCar(BufferedImage carImage, String uniqueID) {
        graphicalCars.add(new GraphicalCar(carImage, uniqueID));
    }

    public List<GraphicalCar> getGraphicalCars() {
        return graphicalCars;
    }
    public BufferedImage getVolvoImage() throws IOException {
        return ImageIO.read(new File("Volvo240.jpg"));
    }

    public BufferedImage getSaabImage() throws IOException {
        return ImageIO.read(new File("Saab95.jpg"));
    }

    public BufferedImage getScaniaImage() throws IOException {
        return ImageIO.read(new File("Scania.jpg"));
    }
    public BufferedImage getTransporterImage() throws IOException {
        return ImageIO.read(new File("Transporter.jpg"));
    }
    
    private HashMap<String,BufferedImage> imageMap = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(boolean isDoubleBuffered,int x, int y, CarModel model) {
        super(isDoubleBuffered);
        this.carModel = model;
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        try {
            imageMap.put("Volvo240", getVolvoImage());
            imageMap.put("Saab95", getSaabImage());
            imageMap.put("Scania", getScaniaImage());
            imageMap.put("Transporter", getTransporterImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car car : carModel.cars)
        {
            g.drawImage(imageMap.get(car.getModelName()), (int)car.getX(),(int)car.getY(), null);
        }
        graphicalCars.stream().forEach(graphicalCar -> g.drawImage(graphicalCar.getCarImage(), graphicalCar.getCarPoint().x, graphicalCar.getCarPoint().y, null)); // see javadoc for more info on the parameters
    }
}
