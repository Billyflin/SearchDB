/*
 * Created by JFormDesigner on Sat Dec 18 01:30:16 CLST 2021
 */

package view;

import javax.swing.event.*;
import model.Especialista;
import model.Hora;
import model.Paciente;
import org.jdesktop.swingx.*;
import service.AppService;
import service.DateTimeService;
import service.EspecialistService;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

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
        pedirHora();
        llenarBuscador();

    }

    private void pedirHora() {
        var servicio=new EspecialistService();
        var especialistas=servicio.getAllEspecialistas();
        for (Especialista e:especialistas
             ) {
            comboBox1.addItem(e.getEspecialidad());
        }
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
    private Especialista buscarEspecialista(String especialidad){
        var service = new EspecialistService();
        for (Especialista e:service.getAllEspecialistas()
             ) {
            if (e.getEspecialidad().equals(especialidad)){
                return e;
            }
        }
        return null;
    }

    private void comboBox1(ActionEvent e) {
       var especialista= buscarEspecialista(String.valueOf(comboBox1.getSelectedItem()));
        assert especialista != null;
        mostrarLabels(especialista);

    }

    private void mostrarLabels(Especialista especialista) {
        label24.setText(especialista.getNombre());
        label25.setText(especialista.getApellido());
        label26.setText(especialista.getEspecialidad());
        label27.setText(especialista.getDireccionAtencion());
        horasEspecilista();
    }

    private void horasEspecilista() {
        var service = new DateTimeService();
        var especialista= buscarEspecialista(String.valueOf(comboBox1.getSelectedItem()));
        var horas= service.getHour(especialista.getId());
        System.out.println(horas);
        llenar(horas);
    }

    private void llenar(ArrayList<Hora> horas) {
        comboBox2.removeAllItems();
        if(horas!=null){

            for (Hora h: horas
            ) {
            if (h.getHora()!=null)
                comboBox2.addItem(h.getHora());
            }
        }
    }


    private void button2(ActionEvent e) {
        var service = new DateTimeService();
        var especialista= buscarEspecialista(String.valueOf(comboBox1.getSelectedItem()));
        var horaString=String.valueOf(comboBox2.getSelectedItem());
        var hora= LocalTime.parse(horaString);
        var fecha= xDatePicker1.getDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        if(service.disponible(LocalDateTime.of(fecha,hora),especialista.getId())){
            registrarHora(LocalDateTime.of(fecha,hora),especialista.getId());
        }
    }

    private void registrarHora(LocalDateTime of, String id) {
        var service = new DateTimeService();
        service.agendarHora(of, this.id,id);
    }

    private void comboBox3(ActionEvent e) {
        llenarLista(String.valueOf(comboBox3.getSelectedItem()));
    }

    private void llenarBuscador(){
        var servicio=new EspecialistService();
        var especialistas=servicio.getEspecialidades();
        for (String esp:especialistas
        ) {
            comboBox3.addItem(esp);
        }
        llenarLista(String.valueOf(comboBox3.getSelectedItem()));
    }

    private void llenarLista(String selectedItem) {
        var servicio=new EspecialistService();
        var especialistas=servicio.getAllEspecialistas();
        ArrayList<String> lista=new ArrayList<>();
        for (Especialista esp:especialistas
        ) {
            System.out.println(esp);
            if (esp.getEspecialidad().equals(selectedItem))
                if(buscarLista(esp))
                lista.add(esp.getNombre() +" "+ esp.getApellido());
        }
        System.out.println(lista);
       list1.setListData(lista.toArray());
    }

    private boolean buscarLista(Especialista esp) {
        return (esp.isFonasa()==checkBox4.isSelected())||(esp.isIsapre()==checkBox3.isSelected());
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        var obj=(String) list1.getSelectedValue();
        if (obj!=null){
            var esp=buscarEspecialistaComp(obj);
            assert esp != null;
            label31.setText(esp.getNombre()+" "+esp.getApellido());
            label37.setText(esp.getDireccionAtencion());
            label34.setText(String.valueOf(esp.isFonasa()));
            label35.setText(String.valueOf(esp.isIsapre()));
            System.out.println(obj);
        }
    }

    private Especialista buscarEspecialistaComp(String obj) {
            var service = new EspecialistService();
            for (Especialista e:service.getAllEspecialistas()
            ) {
                if ((e.getNombre()+" "+e.getApellido()).equals(obj)){
                    return e;
                }
            }
            return null;
    }

    private void checkBox3(ActionEvent e) {
        // TODO add your code here

        llenarLista(String.valueOf(comboBox3.getSelectedItem()));
    }

    private void checkBox4(ActionEvent e) {
        // TODO add your code here

        llenarLista(String.valueOf(comboBox3.getSelectedItem()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Billy
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label17 = new JLabel();
        comboBox1 = new JComboBox();
        xDatePicker1 = new JXDatePicker();
        label18 = new JLabel();
        label19 = new JLabel();
        comboBox2 = new JComboBox();
        button2 = new JButton();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        label28 = new JLabel();
        panel2 = new JPanel();
        comboBox3 = new JComboBox();
        label29 = new JLabel();
        checkBox3 = new JCheckBox();
        checkBox4 = new JCheckBox();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label30 = new JLabel();
        label31 = new JLabel();
        label32 = new JLabel();
        label33 = new JLabel();
        label34 = new JLabel();
        label35 = new JLabel();
        label36 = new JLabel();
        label37 = new JLabel();
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
        setIconImage(new ImageIcon(getClass().getResource("/doctor.png")).getImage());
        setTitle("Dr Search");
        setBackground(new Color(177, 255, 216));
        setAlwaysOnTop(true);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBackground(new Color(204, 255, 204));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(221, 255, 221));

                //---- label17 ----
                label17.setText("Solicitar Hora A");

                //---- comboBox1 ----
                comboBox1.addActionListener(e -> comboBox1(e));

                //---- label18 ----
                label18.setText("El Dia");

                //---- label19 ----
                label19.setText("Horas Disponibles del Especilista");

                //---- button2 ----
                button2.setText("Solicitar");
                button2.setBackground(new Color(160, 245, 160));
                button2.addActionListener(e -> button2(e));

                //---- label20 ----
                label20.setText("Nombre");

                //---- label21 ----
                label21.setText("Apellido");

                //---- label22 ----
                label22.setText("Especialidad");

                //---- label23 ----
                label23.setText("Direccion de Atenci\u00f3n");

                //---- label24 ----
                label24.setText("text");

                //---- label25 ----
                label25.setText("text");

                //---- label26 ----
                label26.setText("text");

                //---- label27 ----
                label27.setText("text");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label17, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                            .addGap(74, 74, 74)
                                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                            .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(label21, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label20, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label22, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label23, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label19, GroupLayout.Alignment.TRAILING))
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(label24, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label25, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label26, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label27, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(46, 46, 46)
                                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 187, Short.MAX_VALUE))))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap(465, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label28, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                            .addGap(24, 24, 24)))))
                            .addGap(72, 72, 72))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label17)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label18)
                                .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label20)
                                .addComponent(label24))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label21)
                                .addComponent(label25))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label26)
                                .addComponent(label22))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label27)
                                .addComponent(label23))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label28)
                            .addGap(22, 22, 22)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label19)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(34, 34, 34))
                );
            }
            tabbedPane1.addTab("Pedir Hora", panel1);

            //======== panel2 ========
            {

                //---- comboBox3 ----
                comboBox3.addActionListener(e -> comboBox3(e));

                //---- label29 ----
                label29.setText("Especialidad");

                //---- checkBox3 ----
                checkBox3.setText("Isapre");
                checkBox3.addActionListener(e -> checkBox3(e));

                //---- checkBox4 ----
                checkBox4.setText("Fonasa");
                checkBox4.addActionListener(e -> checkBox4(e));

                //======== scrollPane1 ========
                {

                    //---- list1 ----
                    list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    list1.setVisibleRowCount(4);
                    list1.addListSelectionListener(e -> list1ValueChanged(e));
                    scrollPane1.setViewportView(list1);
                }

                //---- label30 ----
                label30.setText("Nombre");

                //---- label32 ----
                label32.setText("Fonasa");

                //---- label33 ----
                label33.setText("Isapre");

                //---- label36 ----
                label36.setText("Direccion");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(label29, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                            .addGap(90, 90, 90)
                            .addComponent(checkBox3)
                            .addGap(54, 54, 54)
                            .addComponent(checkBox4)
                            .addContainerGap(139, Short.MAX_VALUE))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addComponent(label30, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label32, GroupLayout.Alignment.TRAILING))
                                        .addComponent(label33))
                                    .addGap(34, 34, 34)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label35)
                                        .addComponent(label34)
                                        .addComponent(label31, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(label37, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                                .addComponent(label36))
                            .addContainerGap(129, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label29)
                                .addComponent(checkBox3)
                                .addComponent(checkBox4)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label30)
                                        .addComponent(label31))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label36)
                                        .addComponent(label37))
                                    .addGap(9, 9, 9)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label32)
                                        .addComponent(label34))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label33)
                                        .addComponent(label35)))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(70, Short.MAX_VALUE))
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
                                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(39, 39, 39))
                );
            }
            tabbedPane1.addTab("Perfil", panel3);
        }
        contentPane.add(tabbedPane1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Billy
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label17;
    private JComboBox comboBox1;
    private JXDatePicker xDatePicker1;
    private JLabel label18;
    private JLabel label19;
    private JComboBox comboBox2;
    private JButton button2;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JLabel label28;
    private JPanel panel2;
    private JComboBox comboBox3;
    private JLabel label29;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label30;
    private JLabel label31;
    private JLabel label32;
    private JLabel label33;
    private JLabel label34;
    private JLabel label35;
    private JLabel label36;
    private JLabel label37;
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
