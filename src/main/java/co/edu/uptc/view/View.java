package co.edu.uptc.view;

import co.edu.uptc.interfaces.ProyectInterface;
import co.edu.uptc.model.data.CountyCount;
import co.edu.uptc.model.data.ElectricRangeCount;
import co.edu.uptc.model.data.StateCount;
import co.edu.uptc.model.data.VehicleMakerCount;
import co.edu.uptc.model.data.VehicleModelCount;
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
        geoFrame = new ShowInfoFrame(new Header("Análisis Geográfico"), createBodyGeo());
        vehicleFrame = new ShowInfoFrame(new Header("Análisis Vehicular"), createBodyVehicle() );
        addActionListenerToButtons();
        begin();
    }

    public static View getInstanceOfView(Presenter pr){
        if (inView == null){
            inView = new View(pr);
        }

        return inView;
    }

    public Body createBodyGeo(){
        StateCount[] dataState = presenter.getStateData().toArray(new StateCount[0]);
        CountyCount[] dataCounty = presenter.getCountyData().toArray(new CountyCount[0]);
        String[] dataCity = presenter.getCityData().toArray(new String[0]);

        // Crear una matriz de String con dos columnas (state y count)
        String[][] stringMatrix = new String[dataState.length][2];

        // Rellenar la matriz con los valores de state y count convertidos a String
        for (int i = 0; i < dataState.length; i++) {
            stringMatrix[i][0] = dataState[i].getState();           // Columna 1: state
            stringMatrix[i][1] = String.valueOf(dataState[i].getCount()); // Columna 2: count convertido a String
        }

        String[][] stringMatrix2 = new String[dataCounty.length][2];

        // Rellenar la matriz con los valores de state y count convertidos a String
        for (int i = 0; i < dataCounty.length; i++) {
            stringMatrix2[i][0] = dataCounty[i].getCounty();           // Columna 1: county
            stringMatrix2[i][1] = String.valueOf(dataCounty[i].getCount()); // Columna 2: count convertido a String
        }

        String[][] dataCity2 = new String[1][1];
        dataCity2[0][0] = dataCity[0];

        
        
        
        Body geBody = new Body(stringMatrix, stringMatrix2, dataCity2, 0);

        return geBody;
        
        
    }

    public Body createBodyVehicle(){
        VehicleModelCount[] dataModel = presenter.getModelData().toArray(new VehicleModelCount[0]);
        VehicleMakerCount[] dataMaker =  presenter.getMakerData().toArray(new VehicleMakerCount[0]);
        ElectricRangeCount[] dataRange = presenter.getRangeData().toArray(new ElectricRangeCount[0]);
        // Crear una matriz de String con dos columnas (Model y count)
        String[][] stringMatrix = new String[dataModel.length][2];

        // Rellenar la matriz con los valores de Model y count convertidos a String
        for (int i = 0; i < dataModel.length; i++) {
            stringMatrix[i][0] = dataModel[i].getModelo();           // Columna 1: Model
            stringMatrix[i][1] = String.valueOf(dataModel[i].getConteo()); // Columna 2: count convertido a String
        }

        String[][] stringMatrix2 = new String[dataMaker.length][2];

        // Rellenar la matriz con los valores de Maker convertidos a String
        for (int i = 0; i < dataMaker.length; i++) {
            stringMatrix2[i][0] = dataMaker[i].getFabricante();           // Columna 1: Maker
            stringMatrix2[i][1] = String.valueOf(dataMaker[i].getConteo()); // Columna 2: count convertido a String
        }

        String[][] stringMatrix3 = new String[dataRange.length][2];

        // Rellenar la matriz con los valores de range y count convertidos a String
        for (int i = 0; i < dataRange.length; i++) {
            stringMatrix3[i][0] = dataRange[i].getRangoElectrico();           // Columna 1: range

            stringMatrix3[i][1] = String.valueOf(dataRange[i].getConteo()); // Columna 2: count convertido a String
        }
        
        
        Body geBody = new Body(stringMatrix, stringMatrix2, stringMatrix3, 1);

        return geBody;
        
        
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
