package co.edu.uptc.interfaces;

import java.awt.event.ActionListener;

public interface ProyectInterface {

    public interface Model {
        public void setPresenter(Presenter presenter);
    }
    
    public interface View{
        public void begin();
    }

    public interface Presenter{
        public void setView(View view);
        public void setModel(Model model);
    }
} 
