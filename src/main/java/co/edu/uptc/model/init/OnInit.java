package co.edu.uptc.model.init;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.data.Root;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class OnInit {
    GetJson getJson = new GetJson();
    ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public SimpleLinkedList launch(SimpleLinkedList sample) {
        try {
            String data = getJson.getJsonData("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
            Root root = objectMapper.readValue(data, Root.class);
            for (ArrayList dList : root.data) {
                sample.add(dList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sample;
    }
}
