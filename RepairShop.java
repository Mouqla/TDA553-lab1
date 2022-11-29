import java.util.ArrayList;

import org.junit.Test;

public class RepairShop
{ 
    public double repairShopPosX = 0;
    public double repairShopPosY = 0;
    public double unloadingPosX = 30;
    public double unloadingPosY = 30;
    public ArrayList<Car> carsStorage = new ArrayList<Car>();
    public int storageCapacity = 6;
    public double loadingDistance = 20;

    public static void main(String[] args) {
        //Volvo240 newVolvo240 = new Volvo240();
        //RepairShop tempShop = new RepairShop();
        //tempShop.LoadCar(newVolvo240);
    }
    public void LoadCar(Car carToLoadCar)
    {
        if(CarIsLoadable(carToLoadCar))
        {
                //Todo:Load car to an array of carsstorage
            if(GetCarsStorageCapacity() < storageCapacity)
            {
                carsStorage.add(carToLoadCar);
                System.out.print("Car Loaded");
            }
            else
            {
                System.out.print("Repair shop is full of cars at the moment");
            }
        }
        else
        {
            System.out.print("Repair shop is not close enough at the moment");
        }
    }

    public void UnloadCar(Car carToUnload)
    {
        carsStorage.remove(carToUnload);
    }
    public void UnloadCarIndex(int carToUnloadIndex)
    {
        carsStorage.remove(carToUnloadIndex);
    }
    public boolean CarIsLoadable(Car carToCheck)
    {
        if(CheckDistance(carToCheck) <= loadingDistance)
        {
            return true;
        }
        else return false;
    }
    public Double CheckDistance(Car carPos)
    {
        double distanceBetweenObjects = Math.sqrt(Math.pow((this.repairShopPosX-carPos.x),2)
                                                + Math.pow((this.repairShopPosY-carPos.y),2));
        
        return distanceBetweenObjects;
    }
    public int GetCarsStorageCapacity()
    {
        return carsStorage.size();
    }





}