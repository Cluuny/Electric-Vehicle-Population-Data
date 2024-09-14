package co.edu.uptc.presenter;

import java.util.ArrayList;

import co.edu.uptc.model.App;
import co.edu.uptc.model.structure.SimpleLinkedList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
    public static App app = new App();
    
    static SimpleLinkedList globaLinkedList = new SimpleLinkedList<ArrayList>();
    public static void main(String[] args) {
        globaLinkedList = app.init(globaLinkedList);

        String[] cities = app.listCitiesWithMostVehicles(globaLinkedList);
        for (String string : cities) {
            System.out.println(string);
        }
    }
}

