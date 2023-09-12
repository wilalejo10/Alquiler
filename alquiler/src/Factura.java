import java.util.Date;
public class Factura
{
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double costoAlquiler;
    private double total;
    private Date fechaInicial;
    private Date fechaFinal;

    public Factura(Cliente cliente, Vehiculo vehiculo, double costoAlquiler, Date fechaInicial, Date fechaFinal) {
    }

    // Getters y setters para acceder a los atributos
    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo()
    {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo)
    {
        this.vehiculo = vehiculo;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public Date getFechaInicial()
    {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", total=" + total +
                ", fechaInicial=" + fechaInicial +
                ", fechaFinal=" + fechaFinal +
                '}';
    }
}
