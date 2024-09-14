/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;


public class MyButton extends JButton {

    public MyButton(String text, String actionComand) {
        super();
        this.setText(text);
        setActionCommand(actionComand);
        this.setPreferredSize(new Dimension(223, 54));
        this.setBackground(new Color(0x909090));
        this.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        this.setForeground(Color.white);
        this.setFont(new Font("Inria Sans", Font.BOLD, 25));

    }
}    
