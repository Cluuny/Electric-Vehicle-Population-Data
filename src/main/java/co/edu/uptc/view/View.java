package co.edu.uptc.view;

import co.edu.uptc.interfaces.ProyectInterface;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.presenter.Presenter;

public final class View implements ProyectInterface.View {
    private static View inView;
    private StartFrame startPageFrame;
    private ShowInfoFrame geoFrame;
    private ShowInfoFrame vehicleFrame;
    private Presenter presenter;

    private View(Presenter presenter) {
        this.presenter = presenter;
        startPageFrame = new StartFrame("Página de inicio");
        //geoFrame = new ShowInfoFrame(new Header("Análisis Geográfico"), );
        //vehicleFrame = new ShowInfoFrame(new Header("Análisis Vehicular"), );
        addActionListenerToButtons();
        begin();
    }

    public static View getInstanceOfView(Presenter pr){
        if (inView == null){
            inView = new View(pr);
        }

        return inView;
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
