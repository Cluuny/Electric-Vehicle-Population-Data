package co.edu.uptc.model;

import java.util.ArrayList;

import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.geo.GeographicalModule;
import co.edu.uptc.model.init.OnInit;
import co.edu.uptc.model.structure.SimpleLinkedList;

@SuppressWarnings("rawtypes") 
public class App {
    private OnInit onInit = new  OnInit();
    GeographicalModule gModule = new GeographicalModule();
    
    public SimpleLinkedList init(SimpleLinkedList<ArrayList> sample){
        return onInit.launch(sample);
    }

    public StateCount[] listByState(SimpleLinkedList<ArrayList<String>> sample){
        return gModule.listByState(sample);
    }
    
    public CountyCount[] countByCounty(SimpleLinkedList<ArrayList<String>> sample){
        return gModule.countByCounty(sample);
    }
}
