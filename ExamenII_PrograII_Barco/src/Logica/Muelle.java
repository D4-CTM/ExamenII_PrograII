package Logica;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Muelle extends JFrame{
    ArrayList<Barco> Barcos;
    
    public Muelle(){
        Barcos = new ArrayList();
        setLayout(null);
        setSize(300,360);
        setMainPanel();

        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Barcos");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void setMainPanel(){
        MainPanel = new JPanel();
        
        MainPanel.setBounds(0, 0, getWidth(), getHeight());
        MainPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        MainPanel.setLayout(null);
        AddShipBTN();
        addElementBTN();
        VaciarBarcoBTN();
        BarcosdesdeBTN();
        add(MainPanel);
    }
    
    private void AddShipBTN(){
        JButton Botones = new JButton();
        
        Botones.setBounds(20, 25, getWidth() - 50, 50);
        Botones.setText("Agregar barco");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{
            Object TipodeNave = JOptionPane.showInputDialog(this, "Eliga que tipo de barco desea agregar", "Agregar barco", JOptionPane.INFORMATION_MESSAGE, null, (new String[] {"Barco Pesquero", "Barco de pasajeros"}), 0);
            try {
                if (TipodeNave.toString().equals("Barco Pesquero")){
                    String Nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del barco");
                    if (!Nombre.isBlank() && isNameValid(Nombre, 0)){
                        Object TipodeNavio = JOptionPane.showInputDialog(this, "Eliga en que se especializara este barco", "", JOptionPane.INFORMATION_MESSAGE, null, TipoPesquero.values(), 0);
                        if (!TipodeNavio.toString().isBlank()){
                            Barcos.add(new BarcoPesquero(Nombre, (TipoPesquero) TipodeNavio));
                        }
                    } else JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre valido");
                } else {
                    String Nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del barco");
                    if (!Nombre.isBlank() && isNameValid(Nombre, 0)){
                        try {
                            String CantidadMax = JOptionPane.showInputDialog(this, "Ingrese la cantidad maxima de pasajeros");
                            if (!CantidadMax.isBlank() && Integer.parseInt(CantidadMax) > 0){
                                String PrecioBoleto = JOptionPane.showInputDialog(this, "Ingrese el precio del boleto");
                                if (!PrecioBoleto.isBlank() && Double.parseDouble(PrecioBoleto) > 0){
                                    Barcos.add(new BarcoPasajero(Nombre, Integer.parseInt(CantidadMax), Double.parseDouble(PrecioBoleto)));
                                } else JOptionPane.showMessageDialog(null, "Por favor ingrese un precio mayor a 0");
                            } else JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad de personas mayores a 0");
                        } catch (Exception E){
                            JOptionPane.showMessageDialog(this, "Por favor limitese a ingresar numeros");
                        }
                    } else JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre valido");
                } 
            } catch (Exception Ex) {}
        });
        MainPanel.add(Botones);
    }
    
    private boolean isNameValid(String Name, int Pos){
        if (Pos < Barcos.size()){
            if (Barcos.get(Pos).getName().equals(Name))
                return true;
        }
        return true;
    }
    
    private void addElementBTN(){
        JButton Botones = new JButton();
        
        Botones.setBounds(20, 100, getWidth() - 50, 50);
        Botones.setText("Agregar elemento");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{
            try {
                if (!Barcos.isEmpty()){
                    String Nombre = JOptionPane.showInputDialog(this,"Ingrese el nombre del barco");
                    AgregarElemento(Nombre, 0);
                } JOptionPane.showMessageDialog(this, "Por favor ingrese un barco primero");
                
            } catch (Exception ex){}
        });
        MainPanel.add(Botones);
    }
    
    private void AgregarElemento(String Name, int Pos){
        if (Pos < Barcos.size()){
            if (Barcos.get(Pos).getName().equals(Name)){
                Barcos.get(Pos).agregarElemento();
            } else AgregarElemento(Name, Pos + 1);
        }
        JOptionPane.showMessageDialog(this, "No se ha encontrado dicho barco");
    }
    
    private void VaciarBarcoBTN(){
        JButton Botones = new JButton();
        
        Botones.setBounds(20, 175, getWidth() - 50, 50);
        Botones.setText("Vaciar barco");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{

        });
        MainPanel.add(Botones);
    }
    
    private void BarcosdesdeBTN(){
        JButton Botones = new JButton();
        
        Botones.setBounds(20, 250, getWidth() - 50, 50);
        Botones.setText("Buscar barco desde");
        Botones.setFocusable(false);
        Botones.addActionListener((ActionEvent e)->{

        });
        MainPanel.add(Botones);
    }
    
    public static void main(String[] args) {
        new Muelle().setVisible(true);
    }
    
    // -- Swing elements --
    private JPanel MainPanel;
    // -- Swing elements --
}
