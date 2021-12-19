/*
 * Created by JFormDesigner on Sat Dec 18 01:30:16 CLST 2021
 */

package view;

import model.Paciente;
import service.AppService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Billy Martinez
 */
public class AppGUI extends JFrame {
    String id;
    Paciente active;
    public AppGUI(String ID) {
        this.id=ID;
        initComponents();
        perfilActivo();
    }

    private void perfilActivo() {
        var servicio=new AppService();
        active=servicio.activo(id);
        fillPerfil();
    }

    private void fillPerfil() {
        label8.setText(active.getNombre());
        label9.setText(active.getApellido());
        label13.setText(active.getRut());
        label10.setText(String.valueOf(active.getEdad()));
//        label11.setText(active.getFechaNacimiento().toString());
        label11.setText(String.valueOf(active.getFechaNacimiento()));
        textField1.setText(active.getCorreo());
        textField2.setText(active.getNumero());
        label15.setText(String.valueOf(active.getFechaCreacion()));
        label16.setText(active.getId());
        checkBox1.setSelected(active.isIsapre());
        checkBox2.setSelected(active.isFonasa());

    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        var service = new AppService();
        active.setCorreo(textField1.getText());
        active.setNumero(textField2.getText());
        active.setFonasa(checkBox2.isSelected());
        active.setIsapre(checkBox1.isSelected());
        service.actualizar(active);
        perfilActivo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textField1 = new JTextField();
        label12 = new JLabel();
        textField2 = new JTextField();
        checkBox1 = new JCheckBox();
        label13 = new JLabel();
        label14 = new JLabel();
        checkBox2 = new JCheckBox();
        label15 = new JLabel();
        label16 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGap(0, 698, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGap(0, 331, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Pedir Hora", panel1);

            //======== panel2 ========
            {

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 698, Short.MAX_VALUE)
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 331, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Buscar Especialista", panel2);

            //======== panel3 ========
            {

                //---- label1 ----
                label1.setText("Nombre");

                //---- label2 ----
                label2.setText("Apellido");

                //---- label3 ----
                label3.setText("ID");

                //---- label4 ----
                label4.setText("Edad");

                //---- label5 ----
                label5.setText("Fecha de Nacimiento");

                //---- label6 ----
                label6.setText("Correo");

                //---- label7 ----
                label7.setText("Fecha Creacion");

                //---- label8 ----
                label8.setText("nombre");

                //---- label9 ----
                label9.setText("apellido");

                //---- label10 ----
                label10.setText("edad");

                //---- label11 ----
                label11.setText("fechanas");

                //---- textField1 ----
                textField1.setText("correo");

                //---- label12 ----
                label12.setText("Telefono");

                //---- checkBox1 ----
                checkBox1.setText("Isapre");

                //---- label13 ----
                label13.setText("Rut");

                //---- label14 ----
                label14.setText("Rut");

                //---- checkBox2 ----
                checkBox2.setText("Fonasa");

                //---- label15 ----
                label15.setText("fechacrea");

                //---- label16 ----
                label16.setText("id");

                //---- button1 ----
                button1.setText("Actualizar Datos");
                button1.addActionListener(e -> button1(e));

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label9, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                .addComponent(label8, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(label10)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                    .addGap(68, 68, 68))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addGap(40, 40, 40)
                                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField1))
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField2)))
                                    .addGap(133, 133, 133)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label16, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                                    .addGap(94, 94, 94))))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(82, 82, 82))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(label3)
                                .addComponent(label8)
                                .addComponent(label16))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(label7)
                                .addComponent(label9)
                                .addComponent(label15))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(label4)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label10)
                                    .addComponent(label14)
                                    .addComponent(label13)))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(label5)
                                .addComponent(label11))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkBox1)
                                .addComponent(checkBox2))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label12)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(39, 39, 39))
                );
            }
            tabbedPane1.addTab("Perfil", panel3);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField1;
    private JLabel label12;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JLabel label13;
    private JLabel label14;
    private JCheckBox checkBox2;
    private JLabel label15;
    private JLabel label16;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
