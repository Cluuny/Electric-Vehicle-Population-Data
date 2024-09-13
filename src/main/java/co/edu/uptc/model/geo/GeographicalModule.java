package co.edu.uptc.model.geo;

import java.util.ArrayList;
import java.util.HashMap;

import co.edu.uptc.model.structure.SimpleLinkedList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SuppressWarnings({ "rawtypes"})
public class GeographicalModule {
    private SimpleLinkedList<ArrayList> globaLinkedList;

    public HashMap<String, Integer> listByState() {
        HashMap<String, Integer> stateCounts = new HashMap<>();

        for (ArrayList car : globaLinkedList) {
            String state = car.get(9 + 2).toString();
            if (stateCounts.containsKey(state)) {
                stateCounts.put(state, stateCounts.get(state) + 1);
            } else {
                stateCounts.put(state, 1);
            }
        }
        return stateCounts;
    }
}
