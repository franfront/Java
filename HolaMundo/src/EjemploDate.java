import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploDate {
    public static void main(String[] args) {
        Date fecha = new Date();
        System.out.println(fecha);
        SimpleDateFormat df = new SimpleDateFormat("E dd 'de' dd MMMM, yyyy");

        String fechaStr = df.format(fecha);

        System.out.println(fechaStr);

        Calendar calendario = Calendar.getInstance();
        calendario.set(2021, 0, 20, 21, 22);

        Date fecha2 = calendario.getTime();
        System.out.println(fecha2);
    }
}
