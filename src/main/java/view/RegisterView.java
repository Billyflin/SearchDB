/*
 * Created by JFormDesigner on Tue Dec 14 07:46:25 CLST 2021
 */

package view;

import java.awt.event.*;
import service.IDgen;
import service.LoginService;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Billy Martinez
 */
public class RegisterView extends JFrame {
    public RegisterView() {
        initComponents();
        initRegister();
    }

    private void initRegister() {
        label5.setText(IDgen.newID());
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        if(notEmpty()&&Equals()&&rutValido(textField1.getText())){
            runFormulario(label5.getText(),textField1.getText());
            register();
            dispose();
        }else if (notEmpty()){
            label6.setText("Las contraseñas no coinciden");
        }
    }

    private void register() {
        var servicio= new LoginService();
        servicio.register(textField1.getText(),passwordField1.getText(),0,label5.getText());
    }

    private boolean rutValido(String rut) {

            boolean validacion = false;
            try {
                rut =  rut.toUpperCase();
                rut = rut.replace(".", "");
                rut = rut.replace("-", "");
                int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

                char dv = rut.charAt(rut.length() - 1);

                int m = 0, s = 1;
                for (; rutAux != 0; rutAux /= 10) {
                    s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
                }
                if (dv == (char) (s != 0 ? s + 47 : 75)) {
                    validacion = true;
                }
            } catch (Exception ignored) {
            }
        return validacion;
    }

    private void runFormulario(String id,String rut){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            FomularioView GUI =  new FomularioView(id,rut);
            GUI.setVisible(true);
        }
    });}

    private boolean Equals() {
        return passwordField1.getText().equals(passwordField2.getText());
    }

    private boolean notEmpty() {
        return !passwordField2.getText().equals("")&&!passwordField1.getText().equals("");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        passwordField2 = new JPasswordField();
        label5 = new JLabel();
        label6 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setTitle("Register");
        setIconImage(new ImageIcon(getClass().getResource("/doctor.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("Rut");

                //---- label2 ----
                label2.setText("Contrase\u00f1a");

                //---- label3 ----
                label3.setText("Este ser\u00e1 tu ID podr\u00e1s consultarlo siempre que quieras dentro de la app");

                //---- label4 ----
                label4.setText("Confirme contrase\u00f1a");

                //---- label5 ----
                label5.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 23));
                label5.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label6 ----
                label6.setForeground(Color.red);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(label1)
                                    .addGap(122, 122, 122))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label4))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label6)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                            .addGap(58, 58, 58))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("Registrarse");
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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JPasswordField passwordField2;
    private JLabel label5;
    private JLabel label6;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
