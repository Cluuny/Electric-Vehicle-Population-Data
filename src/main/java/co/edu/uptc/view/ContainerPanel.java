/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class ContainerPanel extends JPanel {
    private InfoPanel stateInfoPanel;
    private InfoPanel countyInfoPanel;
    private InfoPanel cityInfoPanel;

    public ContainerPanel(String[][] stateData, String[][] countyData, String city) {
        super();
        setPreferredSize(new Dimension(740, 368));
        setOpaque(false);

        CardLayout cardLayout = new CardLayout();

        setLayout(cardLayout);

        stateInfoPanel = new InfoPanel();
        countyInfoPanel = new InfoPanel();
        cityInfoPanel = new InfoPanel();

        add(stateInfoPanel, "Tarjeta 1");
        add(countyInfoPanel, "Tarjeta 2");
        add(cityInfoPanel, "Tarjeta 3");

        setUpStateInfoPanel(stateData);
        setUpCountyInfoPanel(countyData);
        setUpCityInfoPanel(city);

    }

    public void setUpStateInfoPanel(String[][] stateData){

        String[] columnNames = new String[]{"Estado, Cant. Vehiculos"};

        JTable table = new JTable(stateData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        
        stateInfoPanel.add(scrollPane, BorderLayout.CENTER);


    }

    public void setUpCountyInfoPanel(String[][] countyData){

        String[] columnNames = new String[]{"Condado, Cant. Vehiculos"};

        JTable table = new JTable(countyData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        
        stateInfoPanel.add(scrollPane, BorderLayout.CENTER);


    }

    public void setUpCityInfoPanel(String cityData){

        String[] columnNames = new String[]{"Estado, Cant. Vehiculos"};

        JLabel mostRegisteredCity = new JLabel("Ciudad con mas registros: ");
        JTextField city = new JTextField(cityData);
        city.setEditable(false);


    }

    // Clase para personalizar el renderizado de celdas
    class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Obtener el componente predeterminado del renderizador
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Cambiar el color de fondo de las filas pares
            component.setBackground(row % 2 == 0 ? new Color(0x6abce2) : Color.WHITE);
            if (isSelected) {
                component.setForeground(Color.WHITE);
                component.setBackground(Color.lightGray);
            } else {
                component.setForeground(Color.BLACK);
            }

            return component;
        }
    }


}
