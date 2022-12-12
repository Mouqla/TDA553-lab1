import java.util.ArrayList;

public class Loader
{   
    public ArrayList<Car>LoadCar(Car carToLoad,ArrayList<Car> carStorage,double loadingDistance,double loaderPosX,double loaderPosY)
    {
        if(CarIsLoadable(carToLoad, loadingDistance,loaderPosX,loaderPosY))
        {
            carStorage.add(carToLoad);
            return carStorage;
        }
        else
        {
            System.out.print("Car is not loadable");
            return carStorage;
        }
    }
    public ArrayList<Car> UnloadCar(Car carToUnload,ArrayList<Car> carStorage)
    {
        carStorage.remove(carToUnload);
        return carStorage;
    }
    public ArrayList<Car> UnloadCarIndex(int carToUnloadIndex,ArrayList<Car> carStorage)
    {
        carStorage.remove(carToUnloadIndex);
        return carStorage;
    }
    public boolean CarIsLoadable(Car carToCheck,double loadingDistance,double loaderPosX,double loaderPosY)
    {
        if(CheckDistance(carToCheck,loaderPosX,loaderPosY) <= loadingDistance)
        {
            return true;
        }
        else return false;
    }
    public Double CheckDistance(Car carPos,double loaderPosX,double loaderPosY)
    {
        return Math.sqrt(Math.pow((loaderPosX-carPos.getX()),2)
                                                + Math.pow((loaderPosY-carPos.getY()),2));
    }
    
}