package co.edu.uptc.model.geo;

import java.util.ArrayList;

import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.structure.Node;
import co.edu.uptc.model.structure.SimpleLinkedList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GeographicalModule {

    public StateCount[] listByState(SimpleLinkedList<ArrayList<String>> sample) {

        String[] estados = new String[50];
        int[] conteos = new int[200048];
        int numEstados = 0;

        Node<ArrayList<String>> actual = sample.getHead();

        while (actual != null) {
            String estado = actual.getData().get(3);

            boolean encontrado = false;
            for (int i = 0; i < numEstados; i++) {
                if (estados[i].equals(estado)) {
                    conteos[i]++;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                estados[numEstados] = estado;
                conteos[numEstados] = 1;
                numEstados++;
            }

            actual = actual.getNext();
        }

        // Ordenar los estados por el número de vehículos de mayor a menor (burbuja)
        for (int i = 0; i < numEstados - 1; i++) {
            for (int j = 0; j < numEstados - i - 1; j++) {
                if (conteos[j] < conteos[j + 1]) {
                    // Intercambiar conteos
                    int tempConteo = conteos[j];
                    conteos[j] = conteos[j + 1];
                    conteos[j + 1] = tempConteo;

                    // Intercambiar estados
                    String tempEstado = estados[j];
                    estados[j] = estados[j + 1];
                    estados[j + 1] = tempEstado;
                }
            }
        }

        StateCount[] stateCount = new StateCount[numEstados];
        for (int i = 0; i < numEstados; i++) {
            stateCount[i] = new StateCount(estados[i], conteos[i]);
        }

        return stateCount;
    }

    // Método para contar registros por condado y estado
    public CountyCount[] countByCounty(SimpleLinkedList<ArrayList<String>> sample) {
        // Suponiendo un máximo de 200,000 estados y condados (ajustable)
        String[] estados = new String[200048];
        String[] condados = new String[200048];
        int[] conteos = new int[200048];
        int totalRegistros = 0;

        Node<ArrayList<String>> actual = sample.getHead();
        while (actual != null) {
            String estadoActual = actual.getData().get(3); // Posición 3 tiene el estado
            String condadoActual = actual.getData().get(1); // Posición 1 tiene el condado

            // Buscar si el estado y condado ya están en la lista
            boolean encontrado = false;
            for (int i = 0; i < totalRegistros; i++) {
                // Verificar que los elementos no sean nulos antes de comparar
                if (estados[i] != null && condados[i] != null &&
                        estados[i].equals(estadoActual) && condados[i].equals(condadoActual)) {
                    conteos[i]++;
                    encontrado = true;
                    break;
                }
            }

            // Si no se encuentra el estado y condado, los agregamos a la lista
            if (!encontrado) {
                estados[totalRegistros] = estadoActual;
                condados[totalRegistros] = condadoActual;
                conteos[totalRegistros] = 1;
                totalRegistros++;
            }

            actual = actual.getNext();
        }

        // Crear un arreglo de CountyCount
        CountyCount[] resultado = new CountyCount[totalRegistros];
        for (int i = 0; i < totalRegistros; i++) {
            resultado[i] = new CountyCount(estados[i], condados[i], conteos[i]);
        }

        // Ordenar primero por estado alfabéticamente y luego por conteo de menor a
        // mayor
        for (int i = 0; i < totalRegistros - 1; i++) {
            for (int j = 0; j < totalRegistros - i - 1; j++) {
                // Comparar por estado alfabéticamente
                if (resultado[j].getEstado().compareTo(resultado[j + 1].getEstado()) > 0) {
                    // Intercambiar
                    CountyCount temp = resultado[j];
                    resultado[j] = resultado[j + 1];
                    resultado[j + 1] = temp;
                } else if (resultado[j].getEstado().compareTo(resultado[j + 1].getEstado()) == 0) {
                    // Si el estado es igual, comparar por conteo de menor a mayor
                    if (resultado[j].getConteo() > resultado[j + 1].getConteo()) {
                        // Intercambiar
                        CountyCount temp = resultado[j];
                        resultado[j] = resultado[j + 1];
                        resultado[j + 1] = temp;
                    }
                }
            }
        }

        return resultado;
    }

    // Método para listar la ciudad con mayor cantidad de vehículos
    public String[] listCitiesWithMostVehicles(SimpleLinkedList<ArrayList<String>> sample) {
        // Suponiendo un máximo de 200,000 ciudades (ajustable)
        String[] ciudades = new String[200048];
        int[] conteos = new int[200048];
        int totalCiudades = 0;

        Node<ArrayList<String>> actual = sample.getHead();
        while (actual != null) {
            String ciudadActual = actual.getData().get(2); // Posición 2 tiene la ciudad

            // Buscar si la ciudad ya está en la lista
            boolean encontrado = false;
            for (int i = 0; i < totalCiudades; i++) {
                if (ciudades[i] != null && ciudades[i].equals(ciudadActual)) {
                    conteos[i]++;
                    encontrado = true;
                    break;
                }
            }

            // Si no se encuentra la ciudad, la agregamos a la lista
            if (!encontrado) {
                ciudades[totalCiudades] = ciudadActual;
                conteos[totalCiudades] = 1;
                totalCiudades++;
            }

            actual = actual.getNext();
        }

        // Encontrar el mayor conteo
        int maxVehiculos = 0;
        for (int i = 0; i < totalCiudades; i++) {
            if (conteos[i] > maxVehiculos) {
                maxVehiculos = conteos[i];
            }
        }

        // Contar cuántas ciudades tienen el máximo número de vehículos
        int numCiudadesMax = 0;
        for (int i = 0; i < totalCiudades; i++) {
            if (conteos[i] == maxVehiculos) {
                numCiudadesMax++;
            }
        }

        // Crear un arreglo con las ciudades que tienen el máximo número de vehículos
        String[] ciudadesConMasVehiculos = new String[numCiudadesMax];
        int index = 0;
        for (int i = 0; i < totalCiudades; i++) {
            if (conteos[i] == maxVehiculos) {
                ciudadesConMasVehiculos[index] = ciudades[i];
                index++;
            }
        }

        return ciudadesConMasVehiculos;
    }

}
