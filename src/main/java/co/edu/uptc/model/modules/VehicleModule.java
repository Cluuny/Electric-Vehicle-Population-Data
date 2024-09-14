package co.edu.uptc.model.modules;

import java.util.ArrayList;

import co.edu.uptc.model.data.ElectricRangeCount;
import co.edu.uptc.model.data.VehicleMakerCount;
import co.edu.uptc.model.data.VehicleModelCount;
import co.edu.uptc.model.structure.Node;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class VehicleModule {
    // Método para contar la cantidad de vehículos por modelo
    public VehicleModelCount[] countCarsByModel(SimpleLinkedList<ArrayList<String>> sample) {
        String[] models = new String[200050];
        int[] counts = new int[200050];
        int totalModels = 0;

        Node<ArrayList<String>> actual = sample.getHead();
        while (actual != null) {
            String actualModel = actual.getData().get(7);

            // Buscar si el modelo ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalModels; i++) {
                if (models[i] != null && models[i].equals(actualModel)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el modelo, lo agregamos a la lista
            if (!found) {
                models[totalModels] = actualModel;
                counts[totalModels] = 1;
                totalModels++;
            }

            actual = actual.getNext();
        }

        // Crear un arreglo de VehicleModelCount
        VehicleModelCount[] result = new VehicleModelCount[totalModels];
        for (int i = 0; i < totalModels; i++) {
            result[i] = new VehicleModelCount(models[i], counts[i]);
        }

        // Ordenar el arreglo de VehicleModelCount de mayor a menor por conteo
        for (int i = 0; i < totalModels - 1; i++) {
            for (int j = 0; j < totalModels - i - 1; j++) {
                if (result[j].getConteo() < result[j + 1].getConteo()) {
                    // Intercambiar
                    VehicleModelCount temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }

    // Método para contar la cantidad de vehículos por fabricante
    public VehicleMakerCount[] countCarsByMaker(SimpleLinkedList<ArrayList<String>> sample) {
        String[] makers = new String[200050];
        int[] counts = new int[200050];
        int totalMakers = 0;

        Node<ArrayList<String>> actual = sample.getHead();
        while (actual != null) {
            String actualMaker = actual.getData().get(6);

            // Buscar si el fabricante ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalMakers; i++) {
                if (makers[i] != null && makers[i].equals(actualMaker)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el fabricante, lo agregamos a la lista
            if (!found) {
                makers[totalMakers] = actualMaker;
                counts[totalMakers] = 1;
                totalMakers++;
            }

            actual = actual.getNext();
        }

        // Crear un arreglo de VehicleMakerCount
        VehicleMakerCount[] result = new VehicleMakerCount[totalMakers];
        for (int i = 0; i < totalMakers; i++) {
            result[i] = new VehicleMakerCount(makers[i], counts[i]);
        }

        // Ordenar el arreglo de VehicleMakerCount de mayor a menor por conteo
        for (int i = 0; i < totalMakers - 1; i++) {
            for (int j = 0; j < totalMakers - i - 1; j++) {
                if (result[j].getConteo() < result[j + 1].getConteo()) {
                    // Intercambiar
                    VehicleMakerCount temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }

    // Método para contar la cantidad de vehículos por rango eléctrico
    public ElectricRangeCount[] countCarsByElectricRange(SimpleLinkedList<ArrayList<String>> sample) {
        String[] ranges = new String[200050];
        int[] counts = new int[200050];
        int totalRanges = 0;

        Node<ArrayList<String>> actual = sample.getHead();
        while (actual != null) {
            String actualElectricRange = actual.getData().get(10);

            // Buscar si el rango eléctrico ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalRanges; i++) {
                if (ranges[i] != null && ranges[i].equals(actualElectricRange)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el rango eléctrico, lo agregamos a la lista
            if (!found) {
                ranges[totalRanges] = actualElectricRange;
                counts[totalRanges] = 1;
                totalRanges++;
            }

            actual = actual.getNext();
        }

        // Crear un arreglo de ElectricRangeCount
        ElectricRangeCount[] result = new ElectricRangeCount[totalRanges];
        for (int i = 0; i < totalRanges; i++) {
            result[i] = new ElectricRangeCount(ranges[i], counts[i]);
        }

        // Ordenar el arreglo de ElectricRangeCount de mayor a menor por conteo
        for (int i = 0; i < totalRanges - 1; i++) {
            for (int j = 0; j < totalRanges - i - 1; j++) {
                if (result[j].getConteo() < result[j + 1].getConteo()) {
                    // Intercambiar
                    ElectricRangeCount temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }
}
