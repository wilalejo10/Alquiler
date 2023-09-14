import java.util.Date;

public class Factura
{
    public Cliente cliente;
    public int id;
    public int telefono;
    public Vehiculo vehiculo;
    public Date fechaInicial;
    public Date fechaFinal;

    public Factura(Cliente cliente, int id, int telefono, Vehiculo vehiculo, Date fechaInicial, Date fechaFinal)
    {
        this.cliente = cliente;
        this.id = id;
        this.telefono= telefono;
        this.vehiculo = vehiculo;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public Factura(Cliente cliente, Vehiculo vehiculo, Date fechaInicial, Date fechaFinal) { }

    public double calcularCostoAlquiler()
    {
        long diferenciaDias = (fechaFinal.getTime() - fechaInicial.getTime()) / (24 * 60 * 60 * 1000);

        if (vehiculo.getTipo().equalsIgnoreCase("pasajeros"))
        {
            return vehiculo.getCostoPorDia() * diferenciaDias;
        } else if (vehiculo.getTipo().equalsIgnoreCase("carga"))
        {
            double toneladasCarga = vehiculo.getCapacidad();
            return toneladasCarga * vehiculo.getCostoPorDia() * diferenciaDias;
        } else
        {
            return 0.0;
        }
    }
}

