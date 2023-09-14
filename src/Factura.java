import java.util.Date;

public class Factura
{
    public Cliente cliente;
    public Vehiculo vehiculo;
    public Date fechaInicial;
    public Date fechaFinal;

    public Factura(Cliente cliente, Vehiculo vehiculo, Date fechaInicial, Date fechaFinal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public double calcularCostoAlquiler() {
        long diferenciaDias = ((fechaFinal.getTime() - fechaInicial.getTime()) / (24 * 60 * 60 * 1000)) +1; //reta de las fechas sobre los valores de mili, seg, min, hor, y el +1 para no cobrar 0 en caso de tener la misma fecha
        if (vehiculo.getTipo().equalsIgnoreCase("pasajeros")) {
            return vehiculo.getCostoPorDia() * diferenciaDias;
        } else if (vehiculo.getTipo().equalsIgnoreCase("carga")) {
            double toneladasCarga = vehiculo.getCapacidad();
            return toneladasCarga * vehiculo.getCostoPorDia() * diferenciaDias;
        } else {
            return 0.0;
        }
    }
}
