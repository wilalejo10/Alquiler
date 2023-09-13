import javax.swing.*;

public class Cliente
{
    private String nombre;
    private int id;
    private int telefono;

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return nombre;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getTelefono()
    {
        return telefono;
    }

    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }

    public void lecturaDatos()
    {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona que desea alquilar el vehiculo: ");
        setNombre(nombre);
        int idn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente: "));
        setId(idn);
        int tel =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: "));
        setTelefono(tel);
    }
}
