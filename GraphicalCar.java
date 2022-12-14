import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalCar {
    
    private BufferedImage carImage;
    private String uniqueID;
    private Point carPoint;

    public GraphicalCar(BufferedImage carImage, String uniqueID) {
        this.carImage = carImage;
        this.uniqueID = uniqueID;
        this.carPoint = new Point();
    }

    public BufferedImage getCarImage() {
        return carImage;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public Point getCarPoint() {
        return carPoint;
    }

    public void movePoints(int x, int y) {
        carPoint.x = x;
        carPoint.y = y;
    }
}
