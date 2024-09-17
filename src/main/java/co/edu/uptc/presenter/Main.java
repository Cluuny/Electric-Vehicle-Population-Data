package co.edu.uptc.presenter;

import co.edu.uptc.model.App;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    public App app = new App();
    public View view;
    static SimpleLinkedList<Vehicle> globaLinkedList = new SimpleLinkedList<>();

    public static void main(String[] args) {
        Main mainInstance = new Main();
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
        Object[] data;
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
                data = app.listByState(globaLinkedList);
                view.showStringDisplayFrame("Listado por Estados", data);
                break;

            case "county":
                data = app.countByCounty(globaLinkedList);
                view.showStringDisplayFrame("Listado por Condado", data);
                break;

            case "city":
                data = app.listCitiesWithMostVehicles(globaLinkedList);
                view.showStringDisplayFrame("Cuidad con mas registros", data);
                break;

            case "model":
                data = app.countCarsByModel(globaLinkedList);
                view.showStringDisplayFrame("Listado por Modelo", data);
                break;

            case "amount":
                data = app.countCarsByMaker(globaLinkedList);
                view.showStringDisplayFrame("Listado por Fabricante", data);
                break;

            case "range":
                data = app.countCarsByElectricRange(globaLinkedList);
                view.showStringDisplayFrame("Listado por ER", data);
                break;
        }
    }
}