package Logica;

public enum TipoPesquero {
    PEZ(100), CAMARON(50), LANGOSTA(150);
    double Price;
    
    TipoPesquero(double Price){
        this.Price = Price;
    }
    
    public double getPrice(){
        return Price;
    }
    
}
