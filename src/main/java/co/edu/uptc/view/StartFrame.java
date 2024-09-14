/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;

@Getter
public class StartFrame extends JFrame {
    private JPanel titleJpanel;
    private MyButton analisisGeoJbutton;
    private MyButton analisisVehicleJbutton;

    public StartFrame(String name){
        super(name);
        this.setSize(669, 466);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xF5F5F5));
        this.setLayout(null);

        setUpTitlePanel();
        setUpButtons();

        this.add(analisisGeoJbutton);
        this.add(analisisVehicleJbutton);
        this.add(titleJpanel);

    }

    private void setUpTitlePanel(){
        titleJpanel = new JPanel();
        titleJpanel.setBounds(new Rectangle(0, 0, 669, 106));
        titleJpanel.setBackground(new Color(0x53788c));
        titleJpanel.setVisible(true);
        titleJpanel.setOpaque(true);

        JLabel titleLabel = new JLabel("Datos Poblacionales de Carros Elèctricos");
        titleLabel.setFont(new Font("Inria Sans", Font.PLAIN, 30));
        titleLabel.setForeground(Color.white);

        titleJpanel.add(titleLabel);
    }

    private void setUpButtons(){
        analisisGeoJbutton = new MyButton("Analisis geográfico", "analisisGeo");
        analisisGeoJbutton.setBounds(new Rectangle(223, 206, 235, 54));
        
        

        analisisVehicleJbutton = new MyButton("Analisis Vehicular", "analisisVehicle");
        analisisVehicleJbutton.setBounds(new Rectangle(223, 309, 235, 54));
    }

}




    




