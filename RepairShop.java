import java.util.ArrayList;

public class RepairShop
{ 
    public double repairShopPosX = 0;
    public double repairShopPosY = 0;
    public double unloadingPosX = 30;
    public double unloadingPosY = 30;
    public ArrayList<Car> carsStorage = new ArrayList<Car>();
    public int storageCapacity = 6;
    public double loadingDistance = 20;
    public Loader loader;
    
    public void LoadCar(Car carToLoadCar)
    {
        if(GetCarsStorageCurrentCapacity() < storageCapacity)
            {
                loader.LoadCar(carToLoadCar, carsStorage, loadingDistance, repairShopPosX, loadingDistance);
            }
        else
            {
                System.out.print("No plats for you bil mate");
            }
    }

    public void UnloadCar(Car carToUnload)
    {
        loader.UnloadCar(carToUnload, carsStorage);
    }
    public void UnloadCarIndex(int carToUnloadIndex)
    {
        loader.UnloadCarIndex(carToUnloadIndex, carsStorage);
    }
    public int GetCarsStorageCurrentCapacity()
    {
        return carsStorage.size();
    }





}