import java.util.Iterator;

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
    public static class ClienteIterator implements Iterator<Cliente> {
        private Iterator<Cliente> iterator;

        public ClienteIterator(Iterator<Cliente> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Cliente next() {
            return iterator.next();
        }
    }
}
