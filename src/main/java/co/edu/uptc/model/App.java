package co.edu.uptc.model;

import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.ElectricRangeCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.data.VehicleMakerCount;
import co.edu.uptc.model.data.VehicleModelCount;
import co.edu.uptc.model.init.OnInit;
import co.edu.uptc.model.modules.GeographicalModule;
import co.edu.uptc.model.modules.VehicleModule;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class App {
    private OnInit onInit = new OnInit();
    private GeographicalModule gModule = new GeographicalModule();
    private VehicleModule vModule = new VehicleModule();

    public SimpleLinkedList<Vehicle> init(SimpleLinkedList<Vehicle> sample) {
        return onInit.launch(sample);
    }

    public StateCount[] listByState(SimpleLinkedList<Vehicle> sample) {
        return gModule.listByState(sample);
    }

    public CountyCount[] countByCounty(SimpleLinkedList<Vehicle> sample) {
        return gModule.countByCounty(sample);
    }

    public String[] listCitiesWithMostVehicles(SimpleLinkedList<Vehicle> sample) {
        return gModule.listCitiesWithMostVehicles(sample);
    }

    public VehicleModelCount[] countCarsByModel(SimpleLinkedList<Vehicle> sample) {
        return vModule.countCarsByModel(sample);
    }

    public VehicleMakerCount[] countCarsByMaker(SimpleLinkedList<Vehicle> sample) {
        return vModule.countCarsByMaker(sample);
    }

    public ElectricRangeCount[] countCarsByElectricRange(SimpleLinkedList<Vehicle> sample) {
        return vModule.countCarsByElectricRange(sample);
    }
}
