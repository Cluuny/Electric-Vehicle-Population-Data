package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.interfaces.ProyectInterface;
import co.edu.uptc.model.App;
import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.ElectricRangeCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.data.VehicleMakerCount;
import co.edu.uptc.model.data.VehicleModelCount;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.view.View;

public class Presenter implements ActionListener, ProyectInterface.Presenter {
    public App app = new App();
    public View view;
    static SimpleLinkedList<Vehicle> globaLinkedList = new SimpleLinkedList<>();

    public static void main(String[] args) {
        Presenter mainInstance = new Presenter();
        mainInstance.startInitialization();
    }

    private void startInitialization() {
        System.out.println("Descargando Datos...");
        globaLinkedList = app.init(globaLinkedList);
        System.out.println("Descargan Finalizada");
        view = new View(this);
        view.begin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "analisisGeo":
                view.showGeoFrame();
                break;

            case "analisisVehicle":
                view.showVehicleFrame();
                break;

            case "back":
                view.showStartFrame();
                break;

            case "state":
                SimpleLinkedList<StateCount> stateCounts = app.listByState(globaLinkedList);
                view.showStringDisplayFrame("Listado por Estados", stateCounts.clone());
                break;

            case "county":
                SimpleLinkedList<CountyCount> countyCounts = app.countByCounty(globaLinkedList);
                view.showStringDisplayFrame("Listado por Condado", countyCounts.clone());
                break;

            case "city":
                SimpleLinkedList<String> citiesWithMostVechicles = app.listCitiesWithMostVehicles(globaLinkedList);
                view.showStringDisplayFrame("Cuidad con mas registros", citiesWithMostVechicles.clone());
                break;

            case "model":
                SimpleLinkedList<VehicleModelCount> vehicleModelCounts = app.countCarsByModel(globaLinkedList);
                view.showStringDisplayFrame("Listado por Modelo", vehicleModelCounts.clone());
                break;

            case "amount":
                SimpleLinkedList<VehicleMakerCount> vehicleMakerCounts = app.countCarsByMaker(globaLinkedList);
                view.showStringDisplayFrame("Listado por Fabricante", vehicleMakerCounts.clone());
                break;

            case "range":
                SimpleLinkedList<ElectricRangeCount> electricRangeCounts = app
                        .countCarsByElectricRange(globaLinkedList);
                view.showStringDisplayFrame("Listado por ER", electricRangeCounts.clone());
                break;
        }
    }

    @Override
    public void setView(ProyectInterface.View view) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setModel(ProyectInterface.Model model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}