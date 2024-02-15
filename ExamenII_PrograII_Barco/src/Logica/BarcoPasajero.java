package Logica;

import javax.swing.JOptionPane;

public final class BarcoPasajero extends Barco {
    private String[] Pasajeros;
    private double Precio;
    private int Contador;

    public BarcoPasajero(String Nombre, int CantidadMax, double PrecioBoleto) {
        super(Nombre);
        Pasajeros = new String[CantidadMax];
        Precio = PrecioBoleto;
        Contador = 0;
    }

    @Override
    public double vaciarCobrar() {
         int ContadorReplica = Contador;
         Contador = 0;
         return ContadorReplica * Precio;
    }

    @Override
    public void agregarElemento() {
        try {
            if (Contador < Pasajeros.length) {
                String NombrePasajero = JOptionPane.showInputDialog(null, "Ingrese el nombre del pasajero ");
                if (!NombrePasajero.isBlank()){
                    System.out.println("Se agrego");
                    Pasajeros[Contador] = NombrePasajero;
                    Contador++;
                } else JOptionPane.showMessageDialog(null, "Por favor no deje la casilla en blanco");
            } else JOptionPane.showMessageDialog(null, "La capacidad del barco se encuentra al maximo");
        } catch (Exception e){}
    }

    @Override
    public double precioElemento() {
        return Precio;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nCantidad de gente que ha comprado el boleto: "+Contador;
    }
    
    public String Pasajeros(String Pasajeros, int Pos){
        if (Pos < Contador){
            Pasajeros += this.Pasajeros[Pos] + "\n";
        }
        return Pasajeros;
    }

}
