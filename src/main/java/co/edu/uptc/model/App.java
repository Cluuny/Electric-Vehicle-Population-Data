package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;

import co.edu.uptc.model.geo.GeographicalModule;
import co.edu.uptc.model.init.OnInit;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class App {
    private OnInit onInit = new  OnInit();
    
    @SuppressWarnings("rawtypes")
    public SimpleLinkedList init(SimpleLinkedList sample){
        return onInit.launch(sample);
    }

    public HashMap<String, Integer> listByState(@SuppressWarnings("rawtypes") SimpleLinkedList<ArrayList> sample){
        GeographicalModule gModule = new GeographicalModule(sample);
        return gModule.listByState();
    }
    
}
