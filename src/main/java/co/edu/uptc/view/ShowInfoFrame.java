/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import lombok.Getter;

@Getter
public class ShowInfoFrame extends JFrame {
    private Header headerPanel;
    private Body bodyPanel;

    public ShowInfoFrame(Header header, Body body) {
        super("Informe");
        this.setSize(960, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0xF5F5F5));
        setLayout(new BorderLayout(50, 20));

        headerPanel = header;
        headerPanel.setVisible(true);
        headerPanel.setOpaque(true);

        bodyPanel = body;
        bodyPanel.setVisible(true);
        bodyPanel.setOpaque(true);

        add(bodyPanel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

    }

}
