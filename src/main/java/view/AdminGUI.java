/*
 * Created by JFormDesigner on Sat Dec 18 01:10:54 CLST 2021
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import org.jdesktop.swingx.*;
import service.EspecialistService;
import service.IDgen;

/**
 * @author Billy Martinez
 */
public class AdminGUI extends JFrame {
    public AdminGUI() {
        initComponents();
        var servicio= new EspecialistService();
        llenarNivelesDeAcceso();
        fillEspecialist(servicio.getEspecialidades());
    }

    private void fillEspecialist(ArrayList<String> especialidades){
        label5.setText(IDgen.newID());
        for (String s: especialidades) {
            comboBox4.addItem(s);
        }

    }
    private void llenarNivelesDeAcceso(){
        comboBox2.addItem("0 - PACIENTE");
        comboBox2.addItem("1 - ESPECIALISTA");
        comboBox2.addItem("2 - ADMIN");
    }

    private void button1(ActionEvent e) {
       var servicio= new EspecialistService();
       servicio.deleteUser(comboBox1.getSelectedItem());
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        comboBox2 = new JComboBox();
        label12 = new JLabel();
        label13 = new JLabel();
        xButton1 = new JXButton();
        xButton2 = new JXButton();
        button1 = new JButton();
        panel2 = new JPanel();
        textField1 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField2 = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        textField3 = new JTextField();
        label9 = new JLabel();
        comboBox3 = new JComboBox();
        label10 = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        label11 = new JLabel();
        textField5 = new JTextField();
        comboBox4 = new JComboBox();
        xButton3 = new JXButton();
        panel3 = new JPanel();
        xButton4 = new JXButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== tabbedPane1 ========
                {

                    //======== panel1 ========
                    {

                        //---- label1 ----
                        label1.setText("Usuario");

                        //---- label2 ----
                        label2.setText("Cambiar Nivel De Acceso");

                        //---- label12 ----
                        label12.setText("Nombre");

                        //---- label13 ----
                        label13.setText("Apellido");

                        //---- xButton1 ----
                        xButton1.setText("Buscar");

                        //---- xButton2 ----
                        xButton2.setText("Ok");

                        //---- button1 ----
                        button1.setText("Eliminar Usuario");
                        button1.addActionListener(e -> button1(e));

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                        .addComponent(comboBox2)
                                        .addComponent(label13, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                    .addGap(86, 86, 86)
                                    .addComponent(button1)
                                    .addGap(50, 50, 50))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addContainerGap(324, Short.MAX_VALUE)
                                    .addComponent(xButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(xButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                        );
                        panel1Layout.setVerticalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label12)
                                        .addComponent(label13)
                                        .addComponent(button1))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(23, 23, 23)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(xButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(xButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
                        );
                    }
                    tabbedPane1.addTab("Administrar Nivel De Acceso", panel1);

                    //======== panel2 ========
                    {

                        //---- label4 ----
                        label4.setText("ID");

                        //---- label5 ----
                        label5.setText("AAAAAAA");

                        //---- label6 ----
                        label6.setText("Apellido");

                        //---- label7 ----
                        label7.setText("Nombre");

                        //---- label8 ----
                        label8.setText("Rut");

                        //---- label9 ----
                        label9.setText("Area");

                        //---- label10 ----
                        label10.setText("Especialidad");

                        //---- checkBox1 ----
                        checkBox1.setText("Isapre");

                        //---- checkBox2 ----
                        checkBox2.setText("Fonasa");

                        //---- label11 ----
                        label11.setText("Direccion de Atencion");

                        //---- xButton3 ----
                        xButton3.setText("Agregar");

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(xButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                                        .addComponent(label8))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                        .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                            .addGap(106, 106, 106)
                                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(31, 31, 31)
                                                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                            .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(86, 86, 86)
                                                            .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, Short.MAX_VALUE)))))))
                                    .addGap(28, 28, 28))
                        );
                        panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(1, 1, 1)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label7)))
                                        .addComponent(label11, GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label8)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label9)
                                        .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label10)
                                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(checkBox1)
                                        .addComponent(checkBox2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                    .addComponent(xButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        );
                    }
                    tabbedPane1.addTab("Agregar Personal", panel2);

                    //======== panel3 ========
                    {

                        //---- xButton4 ----
                        xButton4.setText("Eliminar");

                        GroupLayout panel3Layout = new GroupLayout(panel3);
                        panel3.setLayout(panel3Layout);
                        panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addContainerGap(405, Short.MAX_VALUE)
                                    .addComponent(xButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46))
                        );
                        panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addContainerGap(221, Short.MAX_VALUE)
                                    .addComponent(xButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    tabbedPane1.addTab("Eliminar Personal", panel3);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(tabbedPane1)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(tabbedPane1)
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
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JLabel label12;
    private JLabel label13;
    private JXButton xButton1;
    private JXButton xButton2;
    private JButton button1;
    private JPanel panel2;
    private JTextField textField1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField3;
    private JLabel label9;
    private JComboBox comboBox3;
    private JLabel label10;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JLabel label11;
    private JTextField textField5;
    private JComboBox comboBox4;
    private JXButton xButton3;
    private JPanel panel3;
    private JXButton xButton4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
