package co.edu.uptc.model.dataManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

public class App {
    public static void main(String[] args) {
        checkMemory();
        //ApiConsumer.writeDataInJson();
    }

    public static void checkMemory() {
        long heapSize = Runtime.getRuntime().totalMemory();
        long maxHeapSize = Runtime.getRuntime().maxMemory();
        long freeHeapSize = Runtime.getRuntime().freeMemory();

        System.out.println("Heap Size: " + heapSize / (1024 * 1024) + " MB");
        System.out.println("Max Heap Size: " + maxHeapSize / (1024 * 1024) + " MB");
        System.out.println("Free Heap Size: " + freeHeapSize / (1024 * 1024) + " MB");

        JsonConvertorService jsonService = new JsonConvertorService();
        TypeReference<Root> typeReference = new TypeReference<Root>() {
            
        };

        

        try {
            //leer datos
            long startTime = System.currentTimeMillis(); // Tiempo inicial
            Root rootData = jsonService.jsonToObject("src\\main\\java\\co\\edu\\uptc\\model\\files\\data.json", typeReference);
            System.out.println("Trabajo hecho");

            List<Vehicle> vehicles = new ArrayList<>();
            for (List<Object> vehicle : rootData.getData()) {
                int metadata = 7; // priemras posiciones del array que son metadata

                
                // cada valor que se le suma al metadata es la posicion despues del metadata de el atributo que queremos
                String vin = (String) vehicle.get(metadata + 1);
                String county = (String) vehicle.get(metadata + 2);
                String city = (String) vehicle.get(metadata + 3);
                String state = (String) vehicle.get(metadata + 4);
                String make = (String) vehicle.get(metadata + 7);
                String model = (String) vehicle.get(metadata + 8);
                int electricRange = Integer.parseInt((String) vehicle.get(metadata + 11));
        
                // Crear una nueva instancia de vehicle
                Vehicle newVehicle = new Vehicle(vin, county, state, city, make, model, electricRange);
        
                // Añadir la instancia a la lista de personas
                vehicles.add(newVehicle);

                

            }
            long endTime = System.currentTimeMillis(); // Tiempo final

            long elapsedTime = (endTime - startTime) / 1000;
            System.out.println("El tiempo de ejecución fue de: " + elapsedTime + " segundos.");
        } catch (IOException ex) {
            ex.printStackTrace();
        
        }

        
        
    }

}
