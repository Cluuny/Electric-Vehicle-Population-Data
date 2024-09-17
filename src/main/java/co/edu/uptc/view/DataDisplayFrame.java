package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class DataDisplayFrame extends JFrame {
    public DataDisplayFrame(String title, Object[] data) {
        super(title);
        setLayout(new BorderLayout());
        setSize(300, 200);
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
