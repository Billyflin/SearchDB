/*
 * Created by JFormDesigner on Sat Dec 18 03:30:38 CLST 2021
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

import model.Agenda;
import model.Hora;
import org.jdesktop.swingx.*;
import service.DateTimeService;

/**
 * @author Billy Martinez
 */
public class EspecialistaView extends JFrame {
    private static String id = null;
    private ArrayList<Hora> horasEspecialista=new ArrayList<>();
    private final DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
        if (horasEspecialista!= null){
            for (Hora h : horasEspecialista) {
                comboBox3.addItem(h.getHora());
            }
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
    private ArrayList<Agenda> generarHorarios(){
        var servicio= new DateTimeService();
        return servicio.getAgendas(id);
    }
    private void setCalendar(){
        deleteAllRows();
        var date1=xDatePicker1.getDate();
        var datemod=date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        var horarios=generarHorarios();
        for (Agenda a:horarios) {
            if(datemod.format(formato).equals(a.getFecha().format(formato))){
                placeAt(a.getFecha().getHour(),a.getIdPaciente());
            }
        }

    }
    public void deleteAllRows() {
        for (int i = 0; i < table1.getRowCount(); i++)
            for(int j = 0; j < table1.getColumnCount(); j++) {
                table1.setValueAt("", i, j);
            }
    }

    private void placeAt(int hour,String valor) {
        if (hour ==8)
            table1.setValueAt(valor,0,0);
        if  (hour == 9)
            table1.setValueAt(valor,0,1);
        if  (hour ==10)
            table1.setValueAt(valor,0,2);
        if  (hour ==11)
            table1.setValueAt(valor,0,3);
        if  (hour ==12)
            table1.setValueAt(valor,0,4);
        if  (hour ==13)
            table1.setValueAt(valor,0,5);
        if  (hour ==15)
            table1.setValueAt(valor,0,6);
        if  (hour ==16)
            table1.setValueAt(valor,0,7);
        if  (hour ==17)
            table1.setValueAt(valor,0,8);
        if  (hour ==18)
            table1.setValueAt(valor,0,9);
    }


    private void xDatePicker1(ActionEvent e) {
        setCalendar();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Billy
        dialogPane = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        xDatePicker1 = new JXDatePicker();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
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
        setIconImage(new ImageIcon(getClass().getResource("/doctor.png")).getImage());
        setTitle("Especialista");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(202, 247, 224));
            dialogPane.setLayout(new BorderLayout());

            //======== tabbedPane1 ========
            {

                //======== panel1 ========
                {

                    //---- xDatePicker1 ----
                    xDatePicker1.addActionListener(e -> xDatePicker1(e));

                    //======== scrollPane1 ========
                    {

                        //---- table1 ----
                        table1.setModel(new DefaultTableModel(
                            new Object[][] {
                                {"", null, null, null, "", "", null, null, null, ""},
                            },
                            new String[] {
                                "8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "3PM", "4PM", "5PM", "6PM"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
                            };
                            boolean[] columnEditable = new boolean[] {
                                false, false, false, false, false, false, false, false, false, false
                            };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = table1.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(0).setMinWidth(15);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                            cm.getColumn(4).setResizable(false);
                            cm.getColumn(5).setResizable(false);
                            cm.getColumn(6).setResizable(false);
                            cm.getColumn(7).setResizable(false);
                            cm.getColumn(8).setResizable(false);
                            cm.getColumn(9).setResizable(false);
                        }
                        table1.setBackground(Color.gray);
                        table1.setRowHeight(50);
                        table1.setAutoscrolls(false);
                        table1.setAutoCreateColumnsFromModel(false);
                        table1.setUpdateSelectionOnSort(false);
                        table1.setVerifyInputWhenFocusTarget(false);
                        table1.setSelectionBackground(Color.gray);
                        scrollPane1.setViewportView(table1);
                    }

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(557, Short.MAX_VALUE)
                                .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
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

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                .addGap(139, 139, 139)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                        .addComponent(button3)
                                        .addGap(18, 18, 18)
                                        .addComponent(button2)
                                        .addGap(74, 74, 74))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(button1))
                                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(112, Short.MAX_VALUE))))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addContainerGap(320, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addGap(236, 236, 236))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1))
                                .addGap(13, 13, 13)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button1)
                                    .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
    // Generated using JFormDesigner Evaluation license - Billy
    private JPanel dialogPane;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JXDatePicker xDatePicker1;
    private JScrollPane scrollPane1;
    private JTable table1;
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
