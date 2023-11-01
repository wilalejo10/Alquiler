import java.util.Iterator;

public class Vehiculo {
    private String placa;
    private String tipo;
    private int capacidad;
    private double costoPorDia;
    public Vehiculo(String placa, String tipo, int capacidad, double costoPorDia) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costoPorDia = costoPorDia;
    }
    public String getPlaca() {
        return placa;
    }
    public String getTipo() {
        return tipo;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public double getCostoPorDia() {
        return costoPorDia;
    }
    public String toString() {
        return placa + "," + tipo + "," + capacidad + "," + costoPorDia;
    }
    public static class VehiculoIterator implements Iterator<Vehiculo> {
        private Iterator<Vehiculo> iterator;

        public VehiculoIterator(Iterator<Vehiculo> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Vehiculo next() {
            return iterator.next();
        }
    }
}
