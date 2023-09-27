package Modelo;
import java.util.Date;
public class Factura {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Boolean estado;
    private Date fechaInicial;
    private Date fechaFinal;
    private double costo;

    public Factura(Cliente cliente, Vehiculo vehiculo, Date fechaInicial, Date fechaFinal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.estado = estado;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.costo = calcularCosto();
    }

    private double calcularCosto() {
        // Verificar que fechaFinal sea mayor o igual que fechaInicial
        if (fechaFinal.getTime() >= fechaInicial.getTime()) {
            long diferenciaDias = ((fechaFinal.getTime() - fechaInicial.getTime()) / (24 * 60 * 60 * 1000)) + 1; // Resta de las fechas en milisegundos, segundos, minutos, horas, y el +1 para no cobrar 0 en caso de tener la misma fecha
            if (vehiculo.getTipo().equalsIgnoreCase("pasajeros")) {
                return vehiculo.getCostoPorDia() * diferenciaDias;
            } else if (vehiculo.getTipo().equalsIgnoreCase("carga")) {
                double toneladasCarga = vehiculo.getCapacidad();
                return toneladasCarga * vehiculo.getCostoPorDia() * diferenciaDias;
            } else {
                return 0.0;
            }
        } else {
            throw new IllegalArgumentException("La fecha final debe ser mayor o igual que la fecha inicial.");
        }
    }


    public String toString() {
        return cliente.getId() + "," + vehiculo.getPlaca() + "," + fechaInicial + "," + fechaFinal + "," + costo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public double getCosto() {
        return costo;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
        // Recalcular el costo cuando se establece la fecha inicial
        this.costo = calcularCosto();
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
        // Recalcular el costo cuando se establece la fecha final
        this.costo = calcularCosto();
    }
}