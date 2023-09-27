package Modelo;
public class Vehiculo {
    private String placa;
    private String tipo;
    private Boolean estado;
    private int capacidad;
    private double costoPorDia;

    public Vehiculo(String placa, String tipo, int capacidad, double costoPorDia) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costoPorDia = costoPorDia;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public Boolean getEstado() {
        return estado;
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
}