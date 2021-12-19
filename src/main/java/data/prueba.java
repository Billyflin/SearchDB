package data;

import interfaz.ConectionData;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class prueba {
   Date date;
   LocalDate date2;

    public static void main(String[] args) {
        new prueba();
    }
   prueba(){
       date2= LocalDate.now();
       date= Date.valueOf(date2);
       System.out.println(date);
//       LocalDate date3=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//       System.out.println(date3);
       Date input = date;
       LocalDate date4 =LocalDate.ofInstant(input.toInstant(), ZoneId.systemDefault());
       System.out.println(date4);
   }
}
