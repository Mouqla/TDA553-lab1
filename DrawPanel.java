import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private static List<GraphicalCar> graphicalCars = new ArrayList<GraphicalCar>();

    public void addGraphicalCar(BufferedImage carImage, String uniqueID) {
        graphicalCars.add(new GraphicalCar(carImage, uniqueID));
    }

    public List<GraphicalCar> getGraphicalCars() {
        return graphicalCars;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphicalCars.stream().forEach(graphicalCar -> g.drawImage(graphicalCar.getCarImage(), graphicalCar.getCarPoint().x, graphicalCar.getCarPoint().y, null)); // see javadoc for more info on the parameters
    }
}
