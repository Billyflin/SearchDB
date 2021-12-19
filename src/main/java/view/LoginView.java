/*
 * Created by JFormDesigner on Tue Dec 14 07:40:53 CLST 2021
 */

package view;

import service.LoginService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Billy Martinez
 */
public class LoginView extends JFrame {
    public LoginView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        initComponents();

    }

    private void ok(ActionEvent e) {
        if(loginRut.getText()!=null&&loginPass.getText()!=null&&!loginRut.getText().equals("")&&!loginPass.getText().equals("")){
            var service= new LoginService();
            var acceso=service.access(loginRut.getText(),loginPass.getText());
            System.out.println(acceso);
            if(acceso){
               init();
            }
        }else if(loginRut.getText()==null||loginRut.getText().equals("")) {
            label4.setText("Ingrese Usuario");
        }else if(loginPass.getText()==null||loginPass.getText().equals("")) {
            label4.setText("Ingrese Contraseña");
        }
    }
    private void init(){
        var service= new LoginService();
        var ID=service.sessionID(loginRut.getText(),loginPass.getText());
        windowsRuner(service.accessLevel(ID),ID);
    }

    private void windowsRuner(int accesslevel, Object ID){
        if (accesslevel==0) {
            runApp((String) ID);
            dispose();
        }else if (accesslevel==1){
            runEspecialista(ID);
            dispose();
        }else if (accesslevel==2){
            runAdmin();
            dispose();
        }
    }

    private void runApp(String ID) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppGUI GUI =  new AppGUI(ID);
                GUI.setVisible(true);
            }
        });
    }
//    Todo private
    public void runEspecialista(Object ID) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EspecialistaView GUI =  new EspecialistaView((String) ID);
                GUI.setVisible(true);
            }
        });
    }


    private void runAdmin() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminGUI GUI =  new AdminGUI();
                GUI.setVisible(true);
            }
        });
    }

    private void button1(ActionEvent e) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegisterView GUI =  new RegisterView();
                GUI.setVisible(true);
            }
        });
    }
//    private int getAccessLevel(String id){
//        ConexionLogin conexion= null;
//        try {
//            conexion = new ServiceLogin();
//            var lvl= conexion.AccessLevel("CG14O7MV");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return lvl;
//    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label3 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        loginRut = new JTextField();
        loginPass = new JPasswordField();
        label4 = new JLabel();
        buttonBar = new JPanel();
        button1 = new JButton();
        okButton = new JButton();

        //======== this ========
        setTitle("Login");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label3 ----
                label3.setText("Dr Search");
                label3.setFont(new Font("I Want My TTR! Condensed", label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 15));

                //---- label1 ----
                label1.setText("Rut");

                //---- label2 ----
                label2.setText("Contrase\u00f1a");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(129, Short.MAX_VALUE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(loginRut, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addComponent(loginPass, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                            .addGap(63, 63, 63))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(142, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(loginRut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(loginPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- button1 ----
                button1.setText("Registrarse");
                button1.addActionListener(e -> button1(e));
                buttonBar.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("Login");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label3;
    private JLabel label1;
    private JLabel label2;
    private JTextField loginRut;
    private JPasswordField loginPass;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton button1;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
