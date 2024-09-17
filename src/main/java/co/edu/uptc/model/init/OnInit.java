package co.edu.uptc.model.init;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.data.Root;
import co.edu.uptc.model.data.Vehicle;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class OnInit {
    ObjectMapper objectMapper = new ObjectMapper();
    ApiConsumer apiConsumer = new ApiConsumer();

    public SimpleLinkedList<Vehicle> launch(SimpleLinkedList<Vehicle> sample) {
        try {
            String data = apiConsumer.getData();
            Root root = objectMapper.readValue(data, Root.class);
            int metadata = 7;

            for (ArrayList<Object> dList : root.data) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(getStringValue(dList, metadata + 1));
                vehicle.setCounty(getStringValue(dList, metadata + 2));
                vehicle.setCity(getStringValue(dList, metadata + 3));
                vehicle.setState(getStringValue(dList, metadata + 4));
                vehicle.setManufacturer(getStringValue(dList, metadata + 7));
                vehicle.setModel(getStringValue(dList, metadata + 8));
                vehicle.setElectricRange(getStringValue(dList, metadata + 11));

                sample.add(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sample;
    }

    private String getStringValue(ArrayList<Object> dList, int index) {
        Object value = dList.get(index);
        return value != null ? value.toString() : ""; // Devuelve un valor por defecto si es null
    }
}
