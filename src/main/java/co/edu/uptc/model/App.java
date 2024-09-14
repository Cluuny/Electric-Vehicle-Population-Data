package co.edu.uptc.model;

import java.util.ArrayList;

import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.ElectricRangeCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.data.VehicleMakerCount;
import co.edu.uptc.model.data.VehicleModelCount;
import co.edu.uptc.model.init.OnInit;
import co.edu.uptc.model.modules.GeographicalModule;
import co.edu.uptc.model.modules.VehicleModule;
import co.edu.uptc.model.structure.SimpleLinkedList;

@SuppressWarnings("rawtypes") 
public class App {
    private OnInit onInit = new  OnInit();
    private GeographicalModule gModule = new GeographicalModule();
    private VehicleModule vModule = new VehicleModule();
    
    public SimpleLinkedList init(SimpleLinkedList<ArrayList> sample){
        return onInit.launch(sample);
    }

    public StateCount[] listByState(SimpleLinkedList<ArrayList<String>> sample){
        return gModule.listByState(sample);
    }
    
    public CountyCount[] countByCounty(SimpleLinkedList<ArrayList<String>> sample){
        return gModule.countByCounty(sample);
    }

    public String[] listCitiesWithMostVehicles(SimpleLinkedList<ArrayList<String>> sample){
        return gModule.listCitiesWithMostVehicles(sample);
    }

    public VehicleModelCount[] countCarsByModel(SimpleLinkedList<ArrayList<String>> sample){
        return vModule.countCarsByModel(sample);
    }

    public VehicleMakerCount[] countCarsByMaker(SimpleLinkedList<ArrayList<String>> sample){
        return vModule.countCarsByMaker(sample);
    }

    public ElectricRangeCount[] countCarsByElectricRange(SimpleLinkedList<ArrayList<String>> sample){
        return vModule.countCarsByElectricRange(sample);
    }
}
