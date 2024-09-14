package co.edu.uptc.model.init;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.data.Root;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class OnInit {
    GetJson getJson = new GetJson();
    GetJsonFromFile getJsonFromFile = new GetJsonFromFile();
    ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings({ "rawtypes" })
    public SimpleLinkedList launch(SimpleLinkedList<ArrayList> sample) {
        try {
            // Linea para obtener los datos desde la API
            /*
             * String data = getJson.getJsonData(
             * "https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
             */

            // Linea para obtener los datos desde el json ubicado en resources/
            String data = getJsonFromFile.getJson();
            Root root = objectMapper.readValue(data, Root.class);
            for (ArrayList<Object> dList : root.data) {
                dList.subList(0, 8).clear();
                sample.add(dList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sample;
    }
}
