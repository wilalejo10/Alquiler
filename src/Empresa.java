import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Empresa
{
    private ArrayList<Factura> facturas;

    public Empresa() {
        facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public void mostrarFacturas() {
        for (Factura factura : facturas) {
            System.out.println("Cliente: " + factura.cliente.getNombre());
            System.out.println("CC: " + factura.cliente.getId());
            System.out.println("Telefono: " + factura.cliente.getTelefono());
            System.out.println("Tipo de vehículo: " + factura.vehiculo.getTipo());
            System.out.println("Fecha Inicial: " + formatDate(factura.fechaInicial));
            System.out.println("Fecha Final: " + formatDate(factura.fechaFinal));
            System.out.println("Costo de alquiler: $" + factura.calcularCostoAlquiler());
            System.out.println("------------------------------");
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
