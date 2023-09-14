public class Cliente
{
    private String nombre;
    private int id;
    private int telefono;

    public Cliente(String nombre,  int id, int telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }

    public String getNombre()
    {
        return nombre;
    }
    public int getId()
    {
        return id;
    }

    public int getTelefono()
    {
        return telefono;
    }
}
