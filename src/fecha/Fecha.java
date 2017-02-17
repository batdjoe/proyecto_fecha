package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Daniel Marrodán
 */
public class Fecha {

    private int mes;
    private int anio;
    private int dia;
    private static int[] diasMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] nombreMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Constructor para calcular la fecha del sistema
     */
    public Fecha() {
        Calendar fechaHoy = new GregorianCalendar();
        dia = fechaHoy.get(Calendar.DAY_OF_MONTH);
        mes = fechaHoy.get(Calendar.MONTH) + 1;
        anio = fechaHoy.get(Calendar.YEAR);
    }

    /**
     * Método para calcular si el año actual es bisiesto
     */
    public void bisiesto() {
        if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) {
            diasMes[1] = 29;
        }
    }

    /**
     * Método para calcular si el año que le pasamos es bisiesto
     * @param anio año
     */
    public void bisiesto(int anio) {
        if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    /**
     * Método para comprobar si has metido bien la fecha
     *
     * @param dia dia del mes
     * @param mes mes del año
     * @param anio año
     * @return true si es correcto o false si es incorrecto
     */
    public boolean comprobarFecha(int dia, int mes, int anio) {
        boolean resultado = false;
        if (anio > 0 && anio < 2020) {
            bisiesto(anio);
            if (mes >= 1 && mes <= 12) {
                if (dia >= 1 && dia <= diasMes[mes - 1]) {
                    resultado = true;
                    this.dia = dia;
                    this.mes = mes;
                    this.anio = anio;
                }
            }
        }
        return resultado;
    }

    /**
     * Metodo para comparar fechas
     *
     * @param f fecha con la que vas a comparar
     * @return 0 si ambas fechas son iguales, 1 si la fecha es mayor, -1 si es
     * menor
     */
    public int compararFecha(Fecha f) {
        int resultado;
        if (this.getAnio() > f.getAnio()) {
            resultado = 1;
        } else {
            if (this.getAnio() < f.getAnio()) {
                resultado = -1;
            } else {
                if (this.getMes() > f.getMes()) {
                    resultado = 1;
                } else {
                    if (this.getMes() < f.getMes()) {
                        resultado = -1;
                    } else {
                        if (this.getDia() > f.getDia()) {
                            resultado = 1;
                        } else {
                            if (this.getDia() < f.getDia()) {
                                resultado = -1;
                            } else {
                                resultado = 0;
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }

    public void mostrarFecha(String mensaje) {
        System.out.println(mensaje + dia + "/" + mes + "/" + anio);
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

}
