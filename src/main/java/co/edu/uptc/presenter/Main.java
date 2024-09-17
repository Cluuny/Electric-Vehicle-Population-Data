package co.edu.uptc.presenter;

import co.edu.uptc.model.App;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.view.View;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Main {
    public static App app = new App();
    public static View view;
    static SimpleLinkedList globaLinkedList = new SimpleLinkedList<Vehicle>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        globaLinkedList = app.init(globaLinkedList);
        app.listByState(globaLinkedList);
        app.countByCounty(globaLinkedList);
        app.listCitiesWithMostVehicles(globaLinkedList);
        app.countCarsByModel(globaLinkedList);
        app.countCarsByMaker(globaLinkedList);
        app.countCarsByElectricRange(globaLinkedList);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        double durationInSeconds = duration / 1000.0;
        System.out.println("Tiempo de ejecución: " + durationInSeconds + " segundos");
        /*
         * view = new View();
         * view.begin();
         */
    }
}
