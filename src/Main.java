import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa();
        Cliente cliente;

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Factura");
            System.out.println("2. Mostrar Facturas");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombreCliente = scanner.nextLine();
                    cliente = new Cliente(nombreCliente);

                    System.out.println("Ingrese el CC del cliente: ");
                    String idCliente = scanner.nextLine();
                    Cliente id = new Cliente(idCliente);

                    System.out.println("Ingrese el telefono del cliente");
                    String telCliente = scanner.nextLine();
                    Cliente telefono = new Cliente(telCliente);

                    System.out.println("Ingrese el tipo de vehículo (pasajeros/carga):");
                    String tipoVehiculo = scanner.nextLine();

                    System.out.println("Ingrese la capacidad (personas o toneladas):");
                    double capacidad = scanner.nextDouble();

                    System.out.println("Ingrese el costo por día:");
                    double costoPorDia = scanner.nextDouble();

                    System.out.println("Ingrese la fecha inicial del alquiler (dd/MM/yyyy):");
                    scanner.nextLine(); // Consumir la nueva línea
                    String fechaInicialStr = scanner.nextLine();

                    System.out.println("Ingrese la fecha final del alquiler (dd/MM/yyyy):");
                    String fechaFinalStr = scanner.nextLine();

                    try
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaInicial = sdf.parse(fechaInicialStr);
                        Date fechaFinal = sdf.parse(fechaFinalStr);

                        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, capacidad, costoPorDia);
                        Factura factura = new Factura(cliente, vehiculo, fechaInicial, fechaFinal);
                        empresa.agregarFactura(factura);
                        System.out.println("Guardando la factura" + factura);
                        System.out.println("Factura agregada con éxito.");
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error al procesar las fechas. Asegúrese de ingresar el formato correcto.");
                    }
                    break;
                case 2:
                    System.out.println("Listado de Facturas:");
                    empresa.mostrarFacturas();
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}