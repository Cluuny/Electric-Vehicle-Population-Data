package co.edu.uptc.presenter;

import java.util.ArrayList;

import co.edu.uptc.model.App;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class Main {
    public static App app = new App();
    @SuppressWarnings("rawtypes")
    static SimpleLinkedList globaLinkedList = new SimpleLinkedList<ArrayList>();
    public static void main(String[] args) {
        globaLinkedList = app.init(globaLinkedList);
        app.listByState(globaLinkedList);
    }
}
