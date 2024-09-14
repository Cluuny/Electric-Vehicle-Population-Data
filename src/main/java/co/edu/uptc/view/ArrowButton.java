package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ArrowButton extends JButton {

    public ArrowButton() {
        // Establece el texto del botón vacío para que solo muestre el ícono
        super("");
        // Establece un tamaño preferido para el botón
        setPreferredSize(new Dimension(40, 40));
        
        ImageIcon originalIcon = new ImageIcon("Electric-Vehicle-Population-Data\\src\\main\\java\\co\\edu\\uptc\\view\\arrow.png");
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imagenEscalada);

        
        this.setIcon(scaleIcon);
        
        
        
    }

    

    
}    
