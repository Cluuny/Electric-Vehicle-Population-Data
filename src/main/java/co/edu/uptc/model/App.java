package co.edu.uptc.model;

import co.edu.uptc.model.init.OnInit;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class App {
    private OnInit onInit = new  OnInit();
    
    @SuppressWarnings("rawtypes")
    public SimpleLinkedList init(SimpleLinkedList sample){
        return onInit.launch(sample);
    }
    
}
