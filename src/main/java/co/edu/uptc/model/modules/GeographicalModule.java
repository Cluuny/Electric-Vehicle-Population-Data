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

    public StateCount[] listByState(SimpleLinkedList<Vehicle> sample) {
        String[] states = new String[50];
        int[] counts = new int[200048];
        int numStates = 0;

        Node<Vehicle> actual = sample.getHead();

        while (actual != null) {
            String state = actual.getData().getState();

            boolean found = false;
            for (int i = 0; i < numStates; i++) {
                if (states[i].equals(state)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                states[numStates] = state;
                counts[numStates] = 1;
                numStates++;
            }

            actual = actual.getNext();
        }

        // Ordenar los states por el número de vehículos de mayor a menor (burbuja)
        for (int i = 0; i < numStates - 1; i++) {
            for (int j = 0; j < numStates - i - 1; j++) {
                if (counts[j] < counts[j + 1]) {
                    // Intercambiar counts
                    int tempConteo = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tempConteo;

                    // Intercambiar states
                    String tempState = states[j];
                    states[j] = states[j + 1];
                    states[j + 1] = tempState;
                }
            }
        }

        StateCount[] stateCount = new StateCount[numStates];
        for (int i = 0; i < numStates; i++) {
            stateCount[i] = new StateCount(states[i], counts[i]);
        }

        return stateCount;
    }

    // Método para contar registros por condado y state
    public CountyCount[] countByCounty(SimpleLinkedList<Vehicle> sample) {
        String[] states = new String[200048];
        String[] counties = new String[200048];
        int[] counts = new int[200048];
        int totalOcurrences = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualState = actual.getData().getState();
            String actualCounty = actual.getData().getCounty();

            // Buscar si el state y condado ya están en la lista
            boolean found = false;
            for (int i = 0; i < totalOcurrences; i++) {
                // Verificar que los elementos no sean nulos antes de comparar
                if (states[i] != null && counties[i] != null &&
                        states[i].equals(actualState) && counties[i].equals(actualCounty)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            // Si no se encuentra el state y condado, los agregamos a la lista
            if (!found) {
                states[totalOcurrences] = actualState;
                counties[totalOcurrences] = actualCounty;
                counts[totalOcurrences] = 1;
                totalOcurrences++;
            }

            actual = actual.getNext();
        }

        // Crear un arreglo de CountyCount
        CountyCount[] result = new CountyCount[totalOcurrences];
        for (int i = 0; i < totalOcurrences; i++) {
            result[i] = new CountyCount(states[i], counties[i], counts[i]);
        }

        // Ordenar primero por state alfabéticamente y luego por conteo de menor a
        // mayor
        for (int i = 0; i < totalOcurrences - 1; i++) {
            for (int j = 0; j < totalOcurrences - i - 1; j++) {
                // Comparar por state alfabéticamente
                if (result[j].getState().compareTo(result[j + 1].getState()) > 0) {
                    // Intercambiar
                    CountyCount temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                } else if (result[j].getState().compareTo(result[j + 1].getState()) == 0) {
                    // Si el state es igual, comparar por conteo de menor a mayor
                    if (result[j].getCount() > result[j + 1].getCount()) {
                        // Intercambiar
                        CountyCount temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                    }
                }
            }
        }

        return result;
    }

    // Método para listar la ciudad con mayor cantidad de vehículos
    public String[] listCitiesWithMostVehicles(SimpleLinkedList<Vehicle> sample) {
        // Suponiendo un máximo de 200,000 cities (ajustable)
        String[] cities = new String[200048];
        int[] counts = new int[200048];
        int totalCities = 0;

        Node<Vehicle> actual = sample.getHead();
        while (actual != null) {
            String actualCity = actual.getData().getCity(); // Posición 2 tiene la ciudad

            // Buscar si la ciudad ya está en la lista
            boolean found = false;
            for (int i = 0; i < totalCities; i++) {
                if (cities[i] != null && cities[i].equals(actualCity)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            // Si no se encuentra la ciudad, la agregamos a la lista
            if (!found) {
                cities[totalCities] = actualCity;
                counts[totalCities] = 1;
                totalCities++;
            }

            actual = actual.getNext();
        }

        // Encontrar el mayor conteo
        int maxVehicles = 0;
        for (int i = 0; i < totalCities; i++) {
            if (counts[i] > maxVehicles) {
                maxVehicles = counts[i];
            }
        }

        // Contar cuántas cities tienen el máximo número de vehículos
        int maxNumCities = 0;
        for (int i = 0; i < totalCities; i++) {
            if (counts[i] == maxVehicles) {
                maxNumCities++;
            }
        }

        // Crear un arreglo con las cities que tienen el máximo número de vehículos
        String[] mostCityVehicles = new String[maxNumCities];
        int index = 0;
        for (int i = 0; i < totalCities; i++) {
            if (counts[i] == maxVehicles) {
                mostCityVehicles[index] = cities[i];
                index++;
            }
        }

        return mostCityVehicles;
    }
}
