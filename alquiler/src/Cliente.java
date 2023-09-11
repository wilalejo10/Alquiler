public class Cliente
{
    private String numeroIdentidad;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(String numeroIdentidad, String nombre, String direccion, String telefono)
    {
        this.numeroIdentidad = numeroIdentidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters para acceder a los atributos
    public String getNumeroIdentidad()
    {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad)
    {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    public String toString()
    {
        return "Cliente{" +
                "numeroIdentidad='" + numeroIdentidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}