package Logica;

import javax.swing.JOptionPane;

public final class BarcoPesquero extends Barco {
    private int PecesCapturados;
    private TipoPesquero TipodeBarco;
    
    
    public BarcoPesquero(String Nombre, TipoPesquero TipodeBarco){
        super(Nombre);
        this.TipodeBarco = TipodeBarco;
        PecesCapturados = 0;
    }

    @Override
    public double vaciarCobrar() {
        int PecesCapturadosReplica = PecesCapturados;
        if (PecesCapturados > 0){
            PecesCapturados = 0;
            return PecesCapturadosReplica * TipodeBarco.getPrice();
        } else JOptionPane.showMessageDialog(null, "No se ha capturado algun pez");
        return 0;
    }

    @Override
    public void agregarElemento() {
        PecesCapturados++;
    }

    @Override
    public double precioElemento() {
        return TipodeBarco.getPrice();
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nPeces capturados: "+PecesCapturados + "\nEspecializacion del barco: "+TipodeBarco.toString();
    }
    
}
