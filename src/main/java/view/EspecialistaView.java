/*
 * Created by JFormDesigner on Sat Dec 18 03:30:38 CLST 2021
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import model.Hora;
import org.jdesktop.swingx.*;
import service.DateTimeService;

/**
 * @author Billy Martinez
 */
public class EspecialistaView extends JFrame {
    private static String id = null;
    private ArrayList<Hora> horasEspecialista;

    public EspecialistaView(String Id) {
        id = Id;
        initComponents();
        agregarHorarios();
    }

    public static String getId() {
        return id;
    }

    private void agregarHorarios() {
        var service = new DateTimeService();
        for (Time time : service.horasPosibles()
        ) {
            comboBox2.addItem(time);
        }
        horarios(id);

    }

    private void horarios(String id) {
        comboBox3.removeAllItems();
        var service = new DateTimeService();
        horasEspecialista = service.getHour(id);
        for (Hora h : horasEspecialista) {
            comboBox3.addItem(h.getHora());
        }
    }

    private void horarios() {
        comboBox3.removeAllItems();
        for (Hora h : horasEspecialista) {
            comboBox3.addItem(h.getHora());
        }

            comboBox3.setSelectedIndex(lastposs());

    }

    private int lastposs() {
        int index = 0;
        for (Hora o:horasEspecialista
             ) {
            if (o.getHora()!=null){
                return index;
            }
            index++;
        }
        return -1;
    }

    private void button1(ActionEvent e) {
        cambiarHora();

    }

    private void cambiarHora() {
        var horaSelecionada = comboBox2.getSelectedItem();
        System.out.println(comboBox3.getItemAt(comboBox2.getSelectedIndex()));
        horasEspecialista.get(consutarDisponibilidad()).setHora((Time) horaSelecionada);
        System.out.println(horasEspecialista.get(comboBox2.getSelectedIndex()).getHora());
        horarios();
    }


    private int consutarDisponibilidad(){
        for (Hora h: horasEspecialista) {
            if (h.getHora()==null) {
                return horasEspecialista.indexOf(h);
            }
        }
        return -1;
    }

    private void button2(ActionEvent e) {
        var servicio= new DateTimeService();
        servicio.guardarHoras(horasEspecialista);
    }

    private void button3(ActionEvent e) {
     try{
        horasEspecialista.get(comboBox3.getSelectedIndex()).setHora(null);

    }catch(IndexOutOfBoundsException s){
        label3.setText("Horarios Vacios");
    }// TODO agregar
        horarios();

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        xDatePicker1 = new JXDatePicker();
        comboBox1 = new JComboBox();
        panel2 = new JPanel();
        comboBox2 = new JComboBox();
        comboBox3 = new JComboBox();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== tabbedPane1 ========
            {

                //======== panel1 ========
                {

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(174, Short.MAX_VALUE))
                    );
                }
                tabbedPane1.addTab("Ver Horas", panel1);

                //======== panel2 ========
                {

                    //---- label1 ----
                    label1.setText("Hora disponible");

                    //---- button1 ----
                    button1.setText("Modificar Hora");
                    button1.addActionListener(e -> button1(e));

                    //---- button2 ----
                    button2.setText("Agregar");
                    button2.addActionListener(e -> button2(e));

                    //---- button3 ----
                    button3.setText("Eliminar");
                    button3.addActionListener(e -> button3(e));

                    //---- label2 ----
                    label2.setText("Hora Seleccionada");

                    //---- label3 ----
                    label3.setText("text");

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(button1)
                                            .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(button3)
                                                .addGap(29, 29, 29)
                                                .addComponent(button2))
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1))
                                .addGap(25, 25, 25)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button1)
                                    .addComponent(button2)
                                    .addComponent(button3))
                                .addGap(17, 17, 17))
                    );
                }
                tabbedPane1.addTab("Editar horario de atencion", panel2);
            }
            dialogPane.add(tabbedPane1, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JXDatePicker xDatePicker1;
    private JComboBox comboBox1;
    private JPanel panel2;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
