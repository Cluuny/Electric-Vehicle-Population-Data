/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package co.edu.uptc.view;

 import java.awt.Dimension;
 import java.awt.FlowLayout;
 
 import javax.swing.JPanel;


 
public class ButtonsPanel extends JPanel {
     private OptionButton firstButton;
     private OptionButton secondButton;
     private OptionButton thirdButton;
 
 
     public ButtonsPanel(OptionButton first, OptionButton second, OptionButton third ) {
         super(new FlowLayout(FlowLayout.LEFT));
         setPreferredSize(new Dimension(740, 40));
         
         this.firstButton = first;
         this.secondButton = second;
         this.thirdButton = third;
 
         add(firstButton);
         add(secondButton);
         add(thirdButton);

         
     }

    public OptionButton getFirstButton() {
        return firstButton;
    }

    public OptionButton getSecondButton() {
        return secondButton;
    }

    public OptionButton getThirdButton() {
        return thirdButton;
    }

    
 
}
