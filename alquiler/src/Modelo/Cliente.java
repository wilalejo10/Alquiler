package Modelo;
import java.util.List;
public class Cliente {
    private String id;
    private String nombre;
    private String telefono;

    public Cliente(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String toString() {
        return id + "," + nombre + "," + telefono;
    }
}
