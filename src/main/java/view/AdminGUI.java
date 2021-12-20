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

import model.Especialista;
import model.Paciente;
import org.jdesktop.swingx.*;
import service.AppService;
import service.EspecialistService;
import service.LoginService;
import utilities.IDgen;

/**
 * @author Billy Martinez
 */
public class AdminGUI extends JFrame {
    public AdminGUI() {
        initComponents();
        var servicio= new EspecialistService();
        llenarNivelesDeAcceso();
        fillEspecialist(servicio.getEspecialidades(),servicio.getAreas());
        llenaDelete();
        llenarUsuario();
    }

    private void fillEspecialist(ArrayList<String> especialidades, ArrayList<String> areas){
        label5.setText(IDgen.newID());
        for (String s: especialidades) {
            comboBox4.addItem(s);
        }
        for (String s:areas
             ) {
            comboBox3.addItem(s);
        }

    }
    private void llenarUsuario(){
        ArrayList<Paciente> logins =obtenerTodosPacientes();
        for (Paciente s: logins
             ) {
            comboBox1.addItem(s.getId());
        }

    }
    private Paciente selectorPaciente(String id){
        ArrayList<Paciente> pacientes;
        pacientes= obtenerTodosPacientes();
        for (Paciente p:pacientes
        ) {
            if (p.getId().equals(id)){
                return p;
            }
        }
        pacientes.clear();
        return null;
    }

    private ArrayList<Paciente> obtenerTodosPacientes() {
        var service = new AppService();
        return service.getAllPacientes();
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
    private void llenaDelete(){
        comboBox5.removeAllItems();
        ArrayList<Especialista> especialistas;
        especialistas=obtenerTodosEspecialistas();
        for (Especialista e:especialistas) {
            comboBox5.addItem(e.getId());
        }
        especialistas.clear();
    }
//
    private ArrayList<Especialista> obtenerTodosEspecialistas(){
        var servicio =new EspecialistService();
        return servicio.getAllEspecialistas();
    }

    private void xButton3(ActionEvent e) {
        var servicio = new EspecialistService();
        servicio.createEspecialista(getData());
        label3.setText("Hecho");
        borrarCampos();
        label5.setText(IDgen.newID());
    }

    private void borrarCampos() {
        label5.setText("");
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField5.setText("");
        comboBox3.setSelectedIndex(-1);
        comboBox4.setSelectedIndex(-1);
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
    }

    private ArrayList<String> getData() {
        ArrayList<String> array = new ArrayList<>();
        array.add(label5.getText());
        array.add(textField3.getText());
        array.add(textField1.getText());
        array.add(textField2.getText());
        array.add((String) comboBox3.getSelectedItem());
        array.add((String) comboBox4.getSelectedItem());
        array.add(String.valueOf(checkBox1.isSelected()));
        array.add(String.valueOf(checkBox2.isSelected()));
        array.add(textField5.getText());
        return array;
    }

    private void comboBox5(ActionEvent e) {
        var obj= selectorEspecilista(String.valueOf(comboBox5.getSelectedItem()));
        if(obj != null){
            label15.setText(obj.getApellido());
            label16.setText(obj.getEspecialidad());
            label14.setText(obj.getNombre());
        }
    }
    private Especialista selectorEspecilista(String id){
        ArrayList<Especialista> especialistas= new ArrayList<>();
        especialistas= obtenerTodosEspecialistas();
        for (Especialista e:especialistas
             ) {
            if (e.getId().equals(id)){
                return e;
            }
        }
        especialistas.clear();
        return null;
    }

    private void comboBox3(ActionEvent e) {
        if(comboBox4.getSelectedIndex()!=-1) {
            comboBox4.setSelectedIndex(comboBox3.getSelectedIndex());
        }
    }

    private void comboBox4(ActionEvent e) {
        if(comboBox3.getSelectedIndex()!=-1) {
            comboBox3.setSelectedIndex(comboBox4.getSelectedIndex());
        }
    }

    private void xButton4(ActionEvent e) {
        var servicio= new EspecialistService();
        servicio.delete(comboBox5.getSelectedItem());
    }

    private void borrarcombo5(){
       comboBox5.removeAll();
    }

    private void button2(ActionEvent e) {
        llenaDelete();
    }

    private void comboBox1(ActionEvent e) {
        var obj= selectorPaciente(String.valueOf(comboBox1.getSelectedItem()));
        if(obj != null){
            label12.setText(obj.getNombre());
            label13.setText(obj.getApellido());
        }
    }

    private void xButton2(ActionEvent e) {
        var servicio =new LoginService();
        servicio.accessChange(String.valueOf(comboBox1.getSelectedItem()),comboBox2.getSelectedIndex());
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
        xButton2 = new JXButton();
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
        label3 = new JLabel();
        panel3 = new JPanel();
        xButton4 = new JXButton();
        comboBox5 = new JComboBox();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        button2 = new JButton();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/doctor.png")).getImage());
        setTitle("Admin");
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

                        //---- comboBox1 ----
                        comboBox1.addActionListener(e -> comboBox1(e));

                        //---- label2 ----
                        label2.setText("Cambiar Nivel De Acceso");

                        //---- label12 ----
                        label12.setText("Nombre");

                        //---- label13 ----
                        label13.setText("Apellido");

                        //---- xButton2 ----
                        xButton2.setText("Ok");
                        xButton2.addActionListener(e -> xButton2(e));

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
                                    .addGap(256, 256, 256))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addComponent(label13))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(23, 23, 23)
                                    .addComponent(xButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

                        //---- comboBox3 ----
                        comboBox3.addActionListener(e -> comboBox3(e));

                        //---- label10 ----
                        label10.setText("Especialidad");

                        //---- checkBox1 ----
                        checkBox1.setText("Isapre");

                        //---- checkBox2 ----
                        checkBox2.setText("Fonasa");

                        //---- label11 ----
                        label11.setText("Direccion de Atencion");

                        //---- comboBox4 ----
                        comboBox4.addActionListener(e -> comboBox4(e));

                        //---- xButton3 ----
                        xButton3.setText("Agregar");
                        xButton3.addActionListener(e -> xButton3(e));

                        //---- label3 ----
                        label3.setForeground(new Color(51, 255, 51));

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label3)
                                            .addGap(188, 188, 188)
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
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(xButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3)))
                        );
                    }
                    tabbedPane1.addTab("Agregar Personal", panel2);

                    //======== panel3 ========
                    {

                        //---- xButton4 ----
                        xButton4.setText("Eliminar");
                        xButton4.addActionListener(e -> xButton4(e));

                        //---- comboBox5 ----
                        comboBox5.addActionListener(e -> comboBox5(e));

                        //---- label14 ----
                        label14.setText("text");

                        //---- label15 ----
                        label15.setText("text");

                        //---- label16 ----
                        label16.setText("text");

                        //---- label17 ----
                        label17.setText("Especialidad");

                        //---- label18 ----
                        label18.setText("Nombre completo");

                        //---- button2 ----
                        button2.setText("Actualizar");
                        button2.addActionListener(e -> button2(e));

                        GroupLayout panel3Layout = new GroupLayout(panel3);
                        panel3.setLayout(panel3Layout);
                        panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addContainerGap(235, Short.MAX_VALUE)
                                            .addComponent(button2)
                                            .addGap(84, 84, 84)
                                            .addComponent(xButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                            .addGroup(panel3Layout.createParallelGroup()
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                    .addGap(144, 144, 144)
                                                    .addComponent(label14, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(label17)
                                                    .addGap(49, 49, 49)))
                                            .addGroup(panel3Layout.createParallelGroup()
                                                .addComponent(label16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                    .addComponent(label15, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 24, Short.MAX_VALUE)))))
                                    .addGap(46, 46, 46))
                        );
                        panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(label18)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label14)
                                        .addComponent(label15))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label16)
                                        .addComponent(label17))
                                    .addGap(68, 68, 68)
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(xButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2))
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
    private JXButton xButton2;
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
    private JLabel label3;
    private JPanel panel3;
    private JXButton xButton4;
    private JComboBox comboBox5;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
