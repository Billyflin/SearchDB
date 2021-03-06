package service;

import data.ConexionAPP;
import data.ConexionEspecialist;
import model.Agenda;
import model.Hora;
import view.EspecialistaView;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DateTimeService  {

    /**
     * @param id 
     * @return ArrayList<Hora>
     */
    public ArrayList<Hora> getHour(String id){
        try {
            var conexion = new ConexionEspecialist();
            var result = conexion.leerTablahoras(id);
            return readResults(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param date 
     * @param idEspecialista
     * @return true si está disponible
     */
   public boolean disponible(LocalDateTime date, String idEspecialista){
        try {
            var conexion = new ConexionAPP();
            LocalDate newdate = LocalDate.from(date);
            return !conexion.consultarAgendas(  java.sql.Date.valueOf(newdate),idEspecialista);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @param rs 
     * @return ArrayList<Hora>
     */
    public ArrayList<Hora> readResults(ResultSet rs){
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return crearHora(rs);
           }
        return null;
    }

    /**
     * @param id 
     * @return ArrayList<Agenda>
     */
    public ArrayList<Agenda> getAgendas(String id){
        try {
            var conexion= new ConexionAPP();
            var rs=conexion.consultarHorarios(id);
            return horariosTomados(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param rs 
     * @return ArrayList<Agenda>
     */
    public ArrayList<Agenda> horariosTomados(ResultSet rs){
        ArrayList<Agenda> array=new ArrayList<>();
        while(true){
            try {
                if (!rs.next()){
                    break;
                }
                array.add(crearAgenda(rs));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    /**
     * @param rs 
     * @return Agenda
     * @throws SQLException
     */
    private Agenda crearAgenda(ResultSet rs) throws SQLException {
            var idpaciente = rs.getString("idpaciente");
            var idespecialista = rs.getString("idespecialista");
            var date = rs.getDate("fecha").toLocalDate();
            var time = rs.getTime("fecha").toLocalTime();
          return new Agenda(idpaciente,idespecialista,date,time);

    }

    /**
     * @return ArrayList<Time>
     */
    public ArrayList<Time> horasPosibles(){
        ArrayList<Time> array = new ArrayList<>();
        array.add(Time.valueOf("08:00:00"));
        array.add(Time.valueOf("09:00:00"));
        array.add(Time.valueOf("10:00:00"));
        array.add(Time.valueOf("11:00:00"));
        array.add(Time.valueOf("12:00:00"));
        array.add(Time.valueOf("13:00:00"));
        array.add(Time.valueOf("15:00:00"));
        array.add(Time.valueOf("16:00:00"));
        array.add(Time.valueOf("17:00:00"));
        array.add(Time.valueOf("18:00:00"));
        return array;
    }

    /**
     * @param result
     * @return array de horas
     */
    private ArrayList<Hora> crearHora(ResultSet result){
        ArrayList<Hora> array = new ArrayList<>();
        Time hora1 = null;
        Time hora2 = null;
        Time hora3 = null;
        Time hora4 = null;
        Time hora5 = null;
        Time hora6 = null;
        Time hora7 = null;
        Time hora8 = null;
        Time hora9 = null;
        Time hora10 = null;
        try {
            hora1 = result.getTime(1);
            hora2 = result.getTime(2);
            hora3 = result.getTime(3);
            hora4 = result.getTime(4);
            hora5 = result.getTime(5);
            hora6 = result.getTime(6);
            hora7 = result.getTime(7);
            hora8 = result.getTime(8);
            hora9 = result.getTime(9);
            hora10 = result.getTime(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        array.add(new Hora(hora1));
        array.add(new Hora(hora2));
        array.add(new Hora(hora3));
        array.add(new Hora(hora4));
        array.add(new Hora(hora5));
        array.add(new Hora(hora6));
        array.add(new Hora(hora7));
        array.add(new Hora(hora8));
        array.add(new Hora(hora9));
        array.add(new Hora(hora10));

        return array;
    }

    /**
     * @param horas 
     */
    public void guardarHoras(ArrayList<Hora> horas){
        try {
            var conexion = new ConexionEspecialist();
            conexion.guardarNuevasHoras(EspecialistaView.getId(),horas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param horaApedir Hora A agendar
     * @param idpaciente id Paciente
     * @param idEspecialista id Especialita
     */
    public void agendarHora(LocalDateTime horaApedir, String idpaciente, String idEspecialista) {

        try {
            var conexion = new ConexionAPP();

            conexion.registerCorrect(horaApedir.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),idpaciente,idEspecialista);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
