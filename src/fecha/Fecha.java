package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Daniel Marrodán
 */
public class Fecha {

    int dia, mes, anio;

    public Fecha(int dias, int mes, int anio) {
        this.dia = dias;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha() {
        Calendar fechaHoy = new GregorianCalendar();
        dia = fechaHoy.get(Calendar.DAY_OF_MONTH);
        mes = fechaHoy.get(Calendar.MONTH) + 1;
        anio = fechaHoy.get(Calendar.YEAR);
        
    }
}
