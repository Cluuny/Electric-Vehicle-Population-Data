package co.edu.uptc.model.modules;

import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.structure.Node;
import co.edu.uptc.model.structure.SimpleLinkedList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GeographicalModule {

    public SimpleLinkedList<StateCount> listByState(SimpleLinkedList<Vehicle> sample) {
        SimpleLinkedList<StateCount> stateCounts = new SimpleLinkedList<>();
        Node<Vehicle> current = sample.getHead();

        // Recorrer la lista de vehículos
        while (current != null) {
            String state = current.getData().getState();
            Node<StateCount> scNode = stateCounts.getHead();
            boolean found = false;

            // Buscar el estado en la lista stateCounts
            while (scNode != null) {
                if (scNode.getData().getState().equals(state)) {
                    // Si se encuentra, incrementar el conteo
                    scNode.getData().incrementCount();
                    found = true;
                    break;
                }
                scNode = scNode.getNext();
            }

            // Si no se encuentra, agregar un nuevo estado a la lista
            if (!found) {
                stateCounts.add(new StateCount(state, 1));
            }

            current = current.getNext();
        }

        // Ordenar la lista stateCounts usando el algoritmo burbuja
        for (int i = 0; i < stateCounts.size() - 1; i++) {
            Node<StateCount> currentNode = stateCounts.getHead();
            for (int j = 0; j < stateCounts.size() - i - 1; j++) {
                Node<StateCount> nextNode = currentNode.getNext();
                if (currentNode.getData().getCount() < nextNode.getData().getCount()) {
                    // Intercambiar los datos de los nodos
                    StateCount temp = currentNode.getData();
                    currentNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                currentNode = nextNode;
            }
        }

        return stateCounts;
    }

    // Método para contar registros por condado y state
    public SimpleLinkedList<CountyCount> countByCounty(SimpleLinkedList<Vehicle> sample) {
        SimpleLinkedList<String> states = new SimpleLinkedList<>();
        SimpleLinkedList<String> counties = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> counts = new SimpleLinkedList<>();
        int totalOcurrences = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualState = actual.getData().getState();
            String actualCounty = actual.getData().getCounty();

            // Buscar si el estado y condado ya están en la lista
            boolean found = false;
            for (int i = 0; i < totalOcurrences; i++) {
                if (states.get(i).equals(actualState) && counties.get(i).equals(actualCounty)) {
                    counts.set(i, counts.get(i) + 1);
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el estado y condado, agregarlos a las listas
            if (!found) {
                states.add(actualState);
                counties.add(actualCounty);
                counts.add(1);
                totalOcurrences++;
            }

            actual = actual.getNext();
        }

        // Crear una lista enlazada de CountyCount
        SimpleLinkedList<CountyCount> result = new SimpleLinkedList<>();
        for (int i = 0; i < totalOcurrences; i++) {
            result.add(new CountyCount(states.get(i), counties.get(i), counts.get(i)));
        }

        // Ordenar primero por estado alfabéticamente y luego por conteo de menor a
        // mayor
        for (int i = 0; i < totalOcurrences - 1; i++) {
            for (int j = 0; j < totalOcurrences - i - 1; j++) {
                CountyCount current = result.get(j);
                CountyCount next = result.get(j + 1);
                // Comparar por estado alfabéticamente
                if (current.getState().compareTo(next.getState()) > 0) {
                    result.set(j, next);
                    result.set(j + 1, current);
                } else if (current.getState().compareTo(next.getState()) == 0) {
                    // Si el estado es igual, comparar por conteo de menor a mayor
                    if (current.getCount() > next.getCount()) {
                        result.set(j, next);
                        result.set(j + 1, current);
                    }
                }
            }
        }

        return result;
    }

    // Método para listar la ciudad con mayor cantidad de vehículos
    public SimpleLinkedList<String> listCitiesWithMostVehicles(SimpleLinkedList<Vehicle> sample) {
        SimpleLinkedList<String> cities = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> counts = new SimpleLinkedList<>();
        int totalCities = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualCity = actual.getData().getCity();

            // Buscar si la ciudad ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalCities; i++) {
                if (cities.get(i).equals(actualCity)) {
                    counts.set(i, counts.get(i) + 1);
                    found = true;
                    break;
                }
            }

            // Si no se encuentra la ciudad, la agregamos a la lista
            if (!found) {
                cities.add(actualCity);
                counts.add(1);
                totalCities++;
            }

            actual = actual.getNext();
        }

        // Encontrar el mayor conteo de vehículos
        int maxVehicles = 0;
        for (int i = 0; i < totalCities; i++) {
            if (counts.get(i) > maxVehicles) {
                maxVehicles = counts.get(i);
            }
        }

        // Contar cuántas ciudades tienen el máximo número de vehículos
        int maxNumCities = 0;
        for (int i = 0; i < totalCities; i++) {
            if (counts.get(i) == maxVehicles) {
                maxNumCities++;
            }
        }

        // Crear una lista enlazada con las ciudades que tienen el máximo número de
        // vehículos
        SimpleLinkedList<String> mostCityVehicles = new SimpleLinkedList<>();
        for (int i = 0; i < totalCities; i++) {
            if (counts.get(i) == maxVehicles) {
                mostCityVehicles.add(cities.get(i));
            }
        }

        return mostCityVehicles;
    }

}
