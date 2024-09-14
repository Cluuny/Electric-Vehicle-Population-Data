package co.edu.uptc.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;


public class OptionButton extends JButton{

    public OptionButton(String text, String actionCommand) {
        super(text);
        setActionCommand(actionCommand);
        setBackground(new Color(0xB2CEE7));
        setFont(new Font("Inria Sans", Font.BOLD, 15));
        setPreferredSize(new Dimension(200, 34));
    }

    
    
}
