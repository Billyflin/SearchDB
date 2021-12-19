import view.LoginView;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        runCreator();
    }
    public static void runCreator(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginView GUI =  new LoginView();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);
            }
        });

    }
}
