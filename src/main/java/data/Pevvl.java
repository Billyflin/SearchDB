package data;

import model.Especialista;
import model.Hora;
import model.Paciente;
import service.AppService;
import service.DateTimeService;
import service.EspecialistService;
import service.LoginService;
import view.AppGUI;
import view.FomularioView;
import view.LoginView;

public class Pevvl {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FomularioView GUI =  new FomularioView("QWEFA457","12031209");
                GUI.setVisible(true);
            }
        });
//        new LoginView().runEspecialista("QFO87YNX");
    }
}
