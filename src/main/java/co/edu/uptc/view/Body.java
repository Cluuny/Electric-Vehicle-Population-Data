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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import lombok.Getter;

@Getter
public class Body extends JPanel {
    private JPanel buttonsPanel;
    private JPanel containerPanel;
    private CardLayout cardLayout;

    public Body(String[][] data1, String[][] data2, String[][] data3, int type) {

        super(new FlowLayout());
        cardLayout = new CardLayout();

        //variable type que indica el tipo de body
        if(type == 0){
            //body geo
            containerPanel = setUpContainerPanelGeo(data1, data2, data3);
            buttonsPanel = setUpButtonsPanelGeo();
        }else{
            //body vehicle
            containerPanel = setUpContainerPanelVehicle(data1, data2, data3);
            buttonsPanel = setUpButtonsPanelVehicle();

        }
    
        add(buttonsPanel);
        add(containerPanel);

    }

    private JPanel setUpContainerPanelGeo(String[][] data1, String[][] data2, String[][] data3){
        containerPanel = new JPanel();
        containerPanel.setLayout(cardLayout);
        containerPanel.setBackground(Color.white);
        containerPanel.setPreferredSize(new Dimension(740, 368));
        containerPanel.setOpaque(false);
        containerPanel.add(setUpStateInfoPanel(data1), "card1");
        containerPanel.add(setUpCountyInfoPanel(data2), "card2");
        containerPanel.add(setUpCityInfoPanel(data3), "card3");

        return containerPanel;

    }

    private JPanel setUpContainerPanelVehicle(String[][] data1, String[][] data2, String[][] data3){
        containerPanel = new JPanel();
        containerPanel.setLayout(cardLayout);
        containerPanel.setBackground(Color.white);
        containerPanel.setPreferredSize(new Dimension(740, 368));
        containerPanel.setOpaque(false);
        containerPanel.add(setUpModelPanel(data1), "card1");
        containerPanel.add(setUpMakerPanel(data2), "card2");
        containerPanel.add(setUpRangePanel(data3), "card3");

        return containerPanel;

    }

    private JPanel setUpButtonsPanelGeo(){
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setPreferredSize(new Dimension(740, 40));

        OptionButton stateButton = new OptionButton("Listado por Estados", "state");
        OptionButton countyButton = new OptionButton("Listado por Condado", "county");
        OptionButton cityButton = new OptionButton("Listado por Ciudad", "city");


        stateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "card1");
                
            }
            
        });

        countyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "card2");
            }
            
        });

        cityButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "card3");
            }
            
        });

        add(stateButton);
        add(countyButton);
        add(cityButton);

        return buttonsPanel;

    }

    private JPanel setUpStateInfoPanel(String[][] stateData){
        InfoPanel stateInfoPanel = new InfoPanel();

        String[] columnNames = new String[]{"Estado"," Cant. Vehiculos"};

        JTable table = new JTable(stateData, columnNames);

        table.setDefaultRenderer(String.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        
        stateInfoPanel.add(scrollPane, BorderLayout.CENTER);

        return stateInfoPanel;


    }

    private JPanel setUpCountyInfoPanel(String[][] countyData){
        InfoPanel countyInfoPanel = new InfoPanel();

        String[] columnNames = new String[]{"Condado"," Cant. Vehiculos"};

        JTable table = new JTable(countyData, columnNames);

        table.setDefaultRenderer(String.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        
        countyInfoPanel.add(scrollPane, BorderLayout.CENTER);

        return countyInfoPanel;


    }

    private JPanel setUpCityInfoPanel(String[][] cityData){
    
        InfoPanel cityInfoPanel = new InfoPanel();

        JLabel mostRegisteredCity = new JLabel("Ciudad con mas registros: ");

        JTextField city = new JTextField(cityData[0][0]);

        cityInfoPanel.setLayout(new FlowLayout());
        cityInfoPanel.add(mostRegisteredCity);
        cityInfoPanel.add(city);



        city.setEditable(false);

        return cityInfoPanel;


    }

    private JPanel setUpButtonsPanelVehicle(){
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setPreferredSize(new Dimension(740, 40));

        OptionButton modelButton = new OptionButton("Listado por Modelo", "model");
        OptionButton makerButton = new OptionButton("Listado por Fabricante", "amount");
        OptionButton rangeButton = new OptionButton("Listado por ER", "range");

        modelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "card1");
                
            }
            
        });

        makerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "card2");
            }
            
        });

        rangeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "card3");
            }
            
        });

        buttonsPanel.add(modelButton);
        buttonsPanel.add(makerButton);
        buttonsPanel.add(rangeButton);

        return buttonsPanel;

    }
   
    private JPanel setUpModelPanel(String[][] modelData){
        InfoPanel modelInfoPanel = new InfoPanel();

        String[] columnNames = new String[]{"Modelo","Cant. Vehiculos" };

        JTable table = new JTable(modelData, columnNames);

        table.setDefaultRenderer(String.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        
        modelInfoPanel.add(scrollPane, BorderLayout.CENTER);

        return modelInfoPanel;

    }

    private JPanel setUpMakerPanel(String[][] makerData){
        InfoPanel makerInfoPanel = new InfoPanel();

        String[] columnNames = new String[]{"Fabricante "," Cant. Vehiculos"};

        JTable table = new JTable(makerData, columnNames);

        table.setDefaultRenderer(String.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        
        makerInfoPanel.add(scrollPane, BorderLayout.CENTER);

        return makerInfoPanel;

    }

    private JPanel setUpRangePanel(String[][] rangeData){
        InfoPanel rangeInfoPanel = new InfoPanel();

        String[] columnNames = new String[]{"Rango electrico"," Cant. Vehiculos"};

        JTable table = new JTable(rangeData, columnNames);

        table.setDefaultRenderer(String.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        
        rangeInfoPanel.add(scrollPane, BorderLayout.CENTER);

        return rangeInfoPanel;

    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Obtener el componente predeterminado del renderizador
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Cambiar el color de fondo de las filas pares
            component.setBackground(row % 2 == 0 ? new Color(173, 216, 230) : Color.WHITE);
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
