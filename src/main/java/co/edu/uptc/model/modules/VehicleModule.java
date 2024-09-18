package co.edu.uptc.model.modules;

import co.edu.uptc.model.data.ElectricRangeCount;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.data.VehicleMakerCount;
import co.edu.uptc.model.data.VehicleModelCount;
import co.edu.uptc.model.structure.Node;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class VehicleModule {
    // Método para contar la cantidad de vehículos por modelo
    public SimpleLinkedList<VehicleModelCount> countCarsByModel(SimpleLinkedList<Vehicle> sample) {
        SimpleLinkedList<String> models = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> counts = new SimpleLinkedList<>();
        int totalModels = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualModel = actual.getData().getModel();

            // Buscar si el modelo ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalModels; i++) {
                if (models.get(i).equals(actualModel)) {
                    counts.set(i, counts.get(i) + 1);
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el modelo, agregarlo a las listas
            if (!found) {
                models.add(actualModel);
                counts.add(1);
                totalModels++;
            }

            actual = actual.getNext();
        }

        // Crear una lista enlazada de VehicleModelCount
        SimpleLinkedList<VehicleModelCount> result = new SimpleLinkedList<>();
        for (int i = 0; i < totalModels; i++) {
            result.add(new VehicleModelCount(models.get(i), counts.get(i)));
        }

        // Ordenar la lista de VehicleModelCount de mayor a menor por conteo
        for (int i = 0; i < totalModels - 1; i++) {
            for (int j = 0; j < totalModels - i - 1; j++) {
                VehicleModelCount current = result.get(j);
                VehicleModelCount next = result.get(j + 1);
                if (current.getConteo() < next.getConteo()) {
                    result.set(j, next);
                    result.set(j + 1, current);
                }
            }
        }

        return result;
    }

    // Método para contar la cantidad de vehículos por fabricante
    public SimpleLinkedList<VehicleMakerCount> countCarsByMaker(SimpleLinkedList<Vehicle> sample) {
        SimpleLinkedList<String> makers = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> counts = new SimpleLinkedList<>();
        int totalMakers = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualMaker = actual.getData().getManufacturer();

            // Buscar si el fabricante ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalMakers; i++) {
                if (makers.get(i).equals(actualMaker)) {
                    counts.set(i, counts.get(i) + 1);
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el fabricante, agregarlo a las listas
            if (!found) {
                makers.add(actualMaker);
                counts.add(1);
                totalMakers++;
            }

            actual = actual.getNext();
        }

        // Crear una lista enlazada de VehicleMakerCount
        SimpleLinkedList<VehicleMakerCount> result = new SimpleLinkedList<>();
        for (int i = 0; i < totalMakers; i++) {
            result.add(new VehicleMakerCount(makers.get(i), counts.get(i)));
        }

        // Ordenar la lista de VehicleMakerCount de mayor a menor por conteo
        for (int i = 0; i < totalMakers - 1; i++) {
            for (int j = 0; j < totalMakers - i - 1; j++) {
                VehicleMakerCount current = result.get(j);
                VehicleMakerCount next = result.get(j + 1);
                if (current.getConteo() < next.getConteo()) {
                    result.set(j, next);
                    result.set(j + 1, current);
                }
            }
        }

        return result;
    }

    // Método para contar la cantidad de vehículos por rango eléctrico
    public SimpleLinkedList<ElectricRangeCount> countCarsByElectricRange(SimpleLinkedList<Vehicle> sample) {
        SimpleLinkedList<String> ranges = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> counts = new SimpleLinkedList<>();
        int totalRanges = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualElectricRange = actual.getData().getElectricRange();

            // Buscar si el rango eléctrico ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalRanges; i++) {
                if (ranges.get(i).equals(actualElectricRange)) {
                    counts.set(i, counts.get(i) + 1);
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el rango eléctrico, lo agregamos a las listas
            if (!found) {
                ranges.add(actualElectricRange);
                counts.add(1);
                totalRanges++;
            }

            actual = actual.getNext();
        }

        // Crear una lista enlazada de ElectricRangeCount
        SimpleLinkedList<ElectricRangeCount> result = new SimpleLinkedList<>();
        for (int i = 0; i < totalRanges; i++) {
            result.add(new ElectricRangeCount(ranges.get(i), counts.get(i)));
        }

        // Ordenar la lista enlazada de ElectricRangeCount de mayor a menor por conteo
        for (int i = 0; i < totalRanges - 1; i++) {
            for (int j = 0; j < totalRanges - i - 1; j++) {
                ElectricRangeCount current = result.get(j);
                ElectricRangeCount next = result.get(j + 1);
                if (current.getConteo() < next.getConteo()) {
                    // Intercambiar
                    result.set(j, next);
                    result.set(j + 1, current);
                }
            }
        }

        return result;
    }
}
