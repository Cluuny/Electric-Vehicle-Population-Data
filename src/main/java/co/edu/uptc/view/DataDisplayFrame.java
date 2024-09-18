package co.edu.uptc.view;

import javax.swing.*;

import co.edu.uptc.model.structure.SimpleLinkedList;

import java.awt.*;

public class DataDisplayFrame extends JFrame {
    public DataDisplayFrame(String title, SimpleLinkedList<Object> data) {
        super(title);
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (Object item : data) {
            textArea.append(item.toString() + "\n");
        }

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }
}
