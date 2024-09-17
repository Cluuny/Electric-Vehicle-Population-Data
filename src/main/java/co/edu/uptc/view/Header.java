/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;

@Getter
public class Header extends JPanel {
    private JLabel titleLabel;
    private ArrowButton backButton;

    public Header(String title) {
        super(new FlowLayout());
        setBackground(new Color(0x53788C));
        setPreferredSize(new Dimension(960, 74));

        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Inria Sans", Font.PLAIN, 30));
        titleLabel.setForeground(Color.white);

        backButton = new ArrowButton();
        backButton.setActionCommand("back");

        add(backButton);
        add(titleLabel);

    }

}