package co.edu.uptc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.interfaces.ProyectInterface;

public final class View implements ProyectInterface.View, ActionListener {
    //private ProyectInterface.Presenter presenter;
    private StartFrame startPageFrame;
    private ShowInfoFrame geoFrame;
    private ShowInfoFrame vehicleFrame;
    public View(/*Presenter pr */){
        //presenter = pr; 
        startPageFrame = new StartFrame("Pagina de inico");
        geoFrame = new ShowInfoFrame(new Header("Anàlisis Geogràfico"), createGeoBody());
        vehicleFrame = new ShowInfoFrame(new Header("Anàlisis Vehícular"), createVehicleBody());
        addActionListenerToButtons();
        begin();
        
    }

    public Body createGeoBody(){
        OptionButton stateButton = new OptionButton("Registro por Estados", "state");
        OptionButton countyButton = new OptionButton("Registro por Condado", "county");
        OptionButton cityButton = new OptionButton("Registro por ciudad", "city");

        ButtonsPanel geoButtonsPanel = new ButtonsPanel(stateButton, countyButton, cityButton);

        Body geoBody = new Body(geoButtonsPanel);

        return geoBody;

    }
    public Body createVehicleBody(){
        OptionButton stateButton = new OptionButton("Registro por Estados", "state");
        OptionButton amountButton = new OptionButton("Registro por Condado", "county");
        OptionButton rangeButton =new OptionButton("Registro por ciudad", "city");

        ButtonsPanel vehicleButtonsPanel = new ButtonsPanel(stateButton, amountButton, rangeButton);

        Body vehicleBody = new Body(vehicleButtonsPanel);

        return vehicleBody;

    }

    @Override
    public void begin() {
        startPageFrame.setVisible(true);
    }

    private void addActionListenerToButtons(){
        startPageFrame.getAnalisisGeoJbutton().addActionListener(this);
        startPageFrame.getAnalisisVehicleJbutton().addActionListener(this);
        

        geoFrame.getOptionButtons()[0].addActionListener(this);
        geoFrame.getOptionButtons()[1].addActionListener(this);
        geoFrame.getOptionButtons()[2].addActionListener(this);
        geoFrame.getHeaderPanel().getBackButton().addActionListener(this);

        vehicleFrame.getOptionButtons()[0].addActionListener(this);
        vehicleFrame.getOptionButtons()[1].addActionListener(this);
        vehicleFrame.getOptionButtons()[2].addActionListener(this);
        vehicleFrame.getHeaderPanel().getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("analisisGeo")){
            geoFrame.setVisible(true);
            startPageFrame.dispose();

        }

        if(e.getActionCommand().equals("analisisVehicle")){
            vehicleFrame.setVisible(true);
            startPageFrame.dispose();

        }

        if(e.getActionCommand().equals("back")){
            if(geoFrame.isVisible()){
                geoFrame.dispose();
                
            }else{
                vehicleFrame.dispose();
                
            }

            startPageFrame.setVisible(true);

        }
    }

    public static void main(String[] args) {
        View vw = new View();
    }
}    
