package Logica;

import java.util.Calendar;
import java.util.Date;

public abstract class Barco {
    protected Date Circulacion;
    protected String Nombre;
    
    public Barco(String Nombre){
        this.Nombre = Nombre;
        Circulacion = Calendar.getInstance().getTime();
    }
    
    public final String getName(){
        return Nombre;
    }
    
    public final Date getFecha(){
        return Circulacion;
    }
    
    @Override
    public String toString(){
        return "Nombre del barco: "+Nombre;
    }
    
    public abstract double vaciarCobrar();
    public abstract void agregarElemento();
    public abstract double precioElemento();
    
}
