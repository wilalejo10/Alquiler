import java.util.ArrayList;
import java.util.Date;

public class Empresa
{
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;

    public Empresa()
    {
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    // Método para cargar vehículos en la empresa
    public void cargarVehiculo(Vehiculo vehiculo)
    {
        vehiculos.add(vehiculo);
    }

    // Método para alquilar un vehículo a un cliente
    public void alquilarVehiculo(Cliente cliente, Vehiculo vehiculo, Date fechaInicial, Date fechaFinal)
    {
        // Verificar si el vehículo está disponible
        if (vehiculo.getEstado().equals("disponible"))
        {
            vehiculo.setEstado("ocupado");

            // Calcular el costo del alquiler
            double costoAlquiler = calcularCostoAlquiler(vehiculo, fechaInicial, fechaFinal);


            // Crear una factura para el alquiler
            Factura factura = new Factura(cliente, vehiculo, costoAlquiler, fechaInicial, fechaFinal);

            // Agregar la factura a la lista de facturas
            facturas.add(factura);
        }
        else
        {
            System.out.println("El vehículo no está disponible para alquiler.");
        }
    }

    // Método para mostrar la lista de vehículos de la empresa
    public void mostrarVehiculos()
    {
        for (Vehiculo vehiculo : vehiculos)
        {
            System.out.println(vehiculo);
        }
    }

    // Método para consultar el estado de un vehículo (libre u ocupado)
    public String consultarEstadoVehiculo(Vehiculo vehiculo)
    {
        return vehiculo.getEstado();
    }

    // Método para calcular el costo de alquiler
    private double calcularCostoAlquiler(Vehiculo vehiculo, Date fechaInicial, Date fechaFinal)
    {
        // Implementar para calcular el costo de alquiler según el tipo de vehículo, fechas, capacidad.
        // Acceder a los atributos del vehículo para calcular el costo.
         //un placeholder.
        return 0.0;
    }
}
