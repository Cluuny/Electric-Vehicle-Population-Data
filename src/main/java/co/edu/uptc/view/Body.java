/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.uptc.view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import lombok.Getter;

@Getter
public class Body extends JPanel{
    private ButtonsPanel buttonsPanel;
    private ContainerPanel containerPanel;

    public Body(ButtonsPanel buttonsPanel) {
        
        super(new FlowLayout());
        this.buttonsPanel = buttonsPanel;
        containerPanel = new ContainerPanel();


        add(buttonsPanel);
        add(containerPanel);
    
    }

}    

