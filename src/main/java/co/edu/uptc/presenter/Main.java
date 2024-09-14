package co.edu.uptc.presenter;

import java.util.ArrayList;

import co.edu.uptc.model.App;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.view.View;

@SuppressWarnings({"rawtypes"})
public class Main {
    public static App app = new App();
    public static View view;
    static SimpleLinkedList globaLinkedList = new SimpleLinkedList<ArrayList>();

    public static void main(String[] args) {
        view = new View();
        view.begin();
    }
}

