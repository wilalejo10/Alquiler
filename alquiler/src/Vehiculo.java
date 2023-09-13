import javax.swing.*;

public class Vehiculo {
    private String Placa;
    private int Tipo; //carga o pasajero
    private String Capacidad;
    private String Estado;
    public int precio;

    public String getPlaca()
    {
        return Placa;
    }
    public void setPlaca(String placa)
    {
        Placa = placa;
    }
    public int getTipo()
    {
        return Tipo;
    }
    public void setTipo(int tipo)
    {
        Tipo = tipo;
    }
    public String getCapacidad()
    {
        return Capacidad;
    }
    public void setCapacidad(String capacidad)
    {
        Capacidad = capacidad;
    }
    public String getEstado()
    {
        return Estado;
    }

    public void setEstado(String estado)
    {
        Estado = estado;
    }

    public int calculoVehiculo()
    {

        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese " + "1" + " si el vehiculo es de carga o " + "2" + " si el vehiculo es de pasajeros"));
        setTipo(tipo);
        if (getTipo() == 1) {
            String capacidad = JOptionPane.showInputDialog("De que capacidad desea el vehiculo de carga?\n" + "-Pequeña(hasta 3.0 toneladas)\n" + "-Mediana(4.0 a 5.0 toneladas=\n" + "-Pesada(6.0 a 10 toneladas) :");
            setCapacidad(capacidad);
            switch (getCapacidad()){
                case "Pequeña": precio = 200000;break;
                case "Mediana": precio = 450000;break;
                case "Pesada": precio = 800000;break;
                default: JOptionPane.showMessageDialog(null,"El nombre del vehiculo ingresado es erroneo");
            }
        } else if (getTipo()==2) {
            String capacidad = JOptionPane.showInputDialog("Que vehiculo desea alquilar?\n: "+"-Pequeño(10 personas maximo)\n"+"-Mediano(20 personas maximo)\n"+"-Grande(30 personas maximo)");
            setCapacidad(capacidad);
            switch (getCapacidad()){
                case "Pequeño": precio = 80000;break;
                case "Mediano": precio = 130000;break;
                case "Grande": precio = 170000;break;
                default:JOptionPane.showMessageDialog(null,"El nombre del vehiculo ingresado es erroneo");
            }
        }
        return precio;
    }
}
