package co.edu.uptc.view;

import co.edu.uptc.interfaces.ProyectInterface;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.presenter.Presenter;

public final class View implements ProyectInterface.View {
    private StartFrame startPageFrame;
    private ShowInfoFrame geoFrame;
    private ShowInfoFrame vehicleFrame;
    private Presenter presenter;

    public View(Presenter presenter) {
        this.presenter = presenter;
        startPageFrame = new StartFrame("Página de inicio");
        geoFrame = new ShowInfoFrame(new Header("Análisis Geográfico"), createGeoBody());
        vehicleFrame = new ShowInfoFrame(new Header("Análisis Vehicular"), createVehicleBody());
        addActionListenerToButtons();
        begin();
    }

    public Body createGeoBody() {
        OptionButton stateButton = new OptionButton("Listado por Estados", "state");
        OptionButton countyButton = new OptionButton("Listado por Condado", "county");
        OptionButton cityButton = new OptionButton("Listado por Ciudad", "city");

        // Agregar un ActionListener para cada botón que apunte al presenter
        stateButton.addActionListener(presenter);
        countyButton.addActionListener(presenter);
        cityButton.addActionListener(presenter);

        ButtonsPanel geoButtonsPanel = new ButtonsPanel(stateButton, countyButton, cityButton);
        Body geoBody = new Body(geoButtonsPanel);

        return geoBody;
    }

    public Body createVehicleBody() {
        OptionButton stateButton = new OptionButton("Listado por Modelo", "model");
        OptionButton amountButton = new OptionButton("Listado por Fabricante", "amount");
        OptionButton rangeButton = new OptionButton("Listado por ER", "range");

        // Agregar un ActionListener para cada botón que apunte al presenter
        stateButton.addActionListener(presenter);
        amountButton.addActionListener(presenter);
        rangeButton.addActionListener(presenter);

        ButtonsPanel vehicleButtonsPanel = new ButtonsPanel(stateButton, amountButton, rangeButton);
        Body vehicleBody = new Body(vehicleButtonsPanel);

        return vehicleBody;
    }

    public StartFrame getStartPageFrame() {
        return startPageFrame;
    }

    @Override
    public void begin() {
        startPageFrame.setVisible(true);
    }

    private void addActionListenerToButtons() {
        startPageFrame.getAnalisisGeoJbutton().addActionListener(presenter);
        startPageFrame.getAnalisisVehicleJbutton().addActionListener(presenter);

        geoFrame.getHeaderPanel().getBackButton().addActionListener(presenter);
        vehicleFrame.getHeaderPanel().getBackButton().addActionListener(presenter);
    }

    // Métodos para mostrar diferentes vistas
    public void showGeoFrame() {
        geoFrame.setVisible(true);
        startPageFrame.dispose();
    }

    public void showVehicleFrame() {
        vehicleFrame.setVisible(true);
        startPageFrame.dispose();
    }

    public void showStartFrame() {
        if (geoFrame.isVisible()) {
            geoFrame.dispose();
        } else {
            vehicleFrame.dispose();
        }
        startPageFrame.setVisible(true);
    }

    public void showStringDisplayFrame(String title, SimpleLinkedList data) {
        DataDisplayFrame frame = new DataDisplayFrame(title, data);
        frame.setVisible(true); // Mostrar la nueva ventana
    }
}
