/*
 * Created by JFormDesigner on Sat Dec 18 15:38:36 CLST 2021
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import model.Paciente;
import org.jdesktop.swingx.*;
import service.AppService;

/**
 * @author Billy Martinez
 */
public class FomularioView extends JFrame {
    private String Rut;
    private String Id;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public FomularioView(String id,String rut) {
        Id = id;
        Rut=rut;
        initComponents();
        xDatePicker1.setFormats(dateFormat);

    }


    private boolean notEmpty() {
        return !textField1.getText().equals("") && textField1.getText() != null &&
                !textField2.getText().equals("") && textField2.getText() != null &&
                !xDatePicker1.getDate().equals("")&&
                !textField4.getText().equals("") && textField4.getText() != null;
    }

    private void button1(ActionEvent e) {
       if (notEmpty()){
           var service= new AppService();
           ArrayList<String> pacienteData=new ArrayList<String>();
           pacienteData.add(Id);
           pacienteData.add(Rut);
           pacienteData.add(textField1.getText());
           pacienteData.add(textField2.getText());
           pacienteData.add(String.valueOf(xDatePicker1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
           pacienteData.add(textField3.getText());
           pacienteData.add(textField4.getText());
           pacienteData.add(String.valueOf(checkBox1.isSelected()));
           pacienteData.add(String.valueOf(checkBox2.isSelected()));
           service.guardar(service.create(pacienteData));
           dispose();
       }
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Billy
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField4 = new JTextField();
        xDatePicker1 = new JXDatePicker();
        button1 = new JButton();
        label5 = new JLabel();
        textField3 = new JTextField();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/doctor.png")).getImage());
        setTitle("Bienvenido!");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,dialogPane. getBorder
            ( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== panel1 ========
                {

                    //---- label1 ----
                    label1.setText("Nombre");

                    //---- label2 ----
                    label2.setText("Apellido");

                    //---- label3 ----
                    label3.setText("Fecha Nacimiento");

                    //---- label4 ----
                    label4.setText("Correo");

                    //---- checkBox1 ----
                    checkBox1.setText("Isapre");

                    //---- checkBox2 ----
                    checkBox2.setText("Fonasa");

                    //---- button1 ----
                    button1.setText("Registrarse");
                    button1.addActionListener(e -> button1(e));

                    //---- label5 ----
                    label5.setText("Telefono");

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(230, Short.MAX_VALUE)
                                .addComponent(button1)
                                .addGap(53, 53, 53))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3)
                                    .addComponent(label5)
                                    .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xDatePicker1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(textField2)
                                    .addComponent(textField1)
                                    .addComponent(textField4)
                                    .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(checkBox2)
                                .addContainerGap(84, Short.MAX_VALUE))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkBox2)
                                    .addComponent(checkBox1))
                                .addGap(30, 30, 30)
                                .addComponent(button1)
                                .addGap(46, 46, 46))
                    );
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 20, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Billy
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JXDatePicker xDatePicker1;
    private JButton button1;
    private JLabel label5;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
