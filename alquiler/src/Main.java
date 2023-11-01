import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Vehiculo;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Vehiculo> vehiculos = new LinkedList<>();
    static List<Cliente> clientes = new LinkedList<>();
    static List<Factura> facturas = new LinkedList<>();

    public static void main(String[] args) {

        cargarVehiculosDesdeCSV();
        cargarClientesDesdeCSV();
        cargarFacturasDesdeCSV();

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Gestionar Vehículos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Facturas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    gestionarVehiculos();
                    break;
                case 2:
                    gestionarClientes();
                    break;
                case 3:
                    gestionarFacturas();
                    break;
                case 4:
                    guardarDatosEnCSV();
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void gestionarVehiculos() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú Vehículos:");
            System.out.println("1. Crear Vehículo");
            System.out.println("2. Leer Vehículos");
            System.out.println("3. Eliminar Vehículo");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    crearVehiculo();
                    break;
                case 2:
                    leerVehiculos();
                    break;
                case 3:
                    eliminarVehiculo();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void crearVehiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del vehículo:");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = scanner.nextInt();
        System.out.print("Valor de Alquiler: ");
        double valorAlquiler = scanner.nextDouble();
        scanner.nextLine(); // Consumir la línea en blanco

        // Validar si el vehículo ya existe
        for (Vehiculo vehiculoExistente : vehiculos) {
            if (vehiculoExistente.getPlaca().equals(placa)) {
                System.out.println("El vehículo con la placa " + placa + " ya existe.");
                return;
            }
        }

        // Crear el nuevo vehículo y agregarlo a la lista
        Vehiculo nuevoVehiculo = new Vehiculo(placa, tipo, capacidad, valorAlquiler);
        vehiculos.add(nuevoVehiculo);
        System.out.println("Vehículo creado exitosamente.");

    }

    private static void leerVehiculos() {
        System.out.println("Lista de Vehículos:");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Tipo: " + vehiculo.getTipo());
            System.out.println("Capacidad: " + vehiculo.getCapacidad());
            System.out.println("Valor de Alquiler: " + vehiculo.getCostoPorDia());
            System.out.println();
        }
    }

    private static void eliminarVehiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = scanner.nextLine();

        // Validar si el vehículo tiene facturas asociadas
        for (Factura factura : facturas) {
            if (factura.getVehiculo().getPlaca().equals(placa)) {
                System.out.println("No se puede eliminar el vehículo porque tiene facturas asociadas.");
                return;
            }
        }

        // Buscar y eliminar el vehículo
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculos.remove(vehiculo);
                System.out.println("Vehículo eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un vehículo con la placa especificada.");
    }

    private static void gestionarClientes() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú Clientes:");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Leer Clientes");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    leerClientes();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void crearCliente() {
        boolean e=true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del cliente:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        // Validar si el cliente ya existe
        for (Cliente clienteExistente : clientes) {
            if (clienteExistente.getId().equals(id)) {
                System.out.println("El cliente con el ID " + id + " ya existe.");
                e=false;
            }
        }
        if(e){
            // Crear el nuevo cliente y agregarlo a la lista
            Cliente nuevoCliente = new Cliente(id, nombre, telefono);
            clientes.add(nuevoCliente);
            System.out.println("Cliente creado exitosamente.");
        }
    }
    private static void leerClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println();
        }
    }

    private static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = scanner.nextLine();

        // Validar si el cliente tiene facturas asociadas
        for (Factura factura : facturas) {
            if (factura.getCliente().getId().equals(id)) {
                System.out.println("No se puede eliminar el cliente porque tiene facturas asociadas.");
                return;
            }
        }

        // Buscar y eliminar el cliente
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                clientes.remove(cliente);
                System.out.println("Cliente eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un cliente con el ID especificado.");
    }

    private static void gestionarFacturas() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú Facturas:");
            System.out.println("1. Crear Factura");
            System.out.println("2. Leer Facturas");
            System.out.println("3. Actualizar Factura");
            System.out.println("4. Eliminar Factura");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    crearFactura();
                    break;
                case 2:
                    leerFacturas();
                    break;
                case 3:
                    actualizarFactura();
                    break;
                case 4:
                    eliminarFactura();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void crearFactura() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos de la factura:");
        System.out.print("ID del Cliente: ");
        String clienteId = scanner.nextLine();

        // Validar si el cliente existe
        Cliente clienteExistente = buscarClientePorId(clienteId);
        if (clienteExistente == null) {
            System.out.println("El cliente con el ID " + clienteId + " no existe. Por favor, cree el cliente primero.");
            return;
        }

        System.out.print("Placa del Vehículo: ");
        String placaVehiculo = scanner.nextLine();

        // Validar si el vehículo existe
        Vehiculo vehiculoExistente = buscarVehiculoPorPlaca(placaVehiculo);
        if (vehiculoExistente == null) {
            System.out.println("El vehículo con la placa " + placaVehiculo + " no existe. Por favor, cree el vehículo primero.");
            return;
        }

        // Validar si el vehículo ya tiene una factura asignada
        if (vehiculoYaTieneFactura(placaVehiculo)) {
            System.out.println("El vehículo con la placa " + placaVehiculo + " ya tiene una factura asignada. No se puede asignar otra factura.");
            return;
        }

        System.out.println("Ingresa la fecha con el siguiente formato: (dd/MM/yyyy)");
        System.out.print("Fecha Inicial: ");
        String fechaInicialString = scanner.nextLine();
        System.out.print("Fecha Final: ");
        String fechaFinalString = scanner.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicial;
        try {
            fechaInicial = formatter.parse(fechaInicialString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date fechaFinal;
        try {
            fechaFinal = formatter.parse(fechaFinalString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Crear la nueva factura y agregarla a la lista
        Factura nuevaFactura = new Factura(clienteExistente, vehiculoExistente, fechaInicial, fechaFinal);
        facturas.add(nuevaFactura);
        System.out.println("Factura creada exitosamente.");
    }

    private static boolean vehiculoYaTieneFactura(String placaVehiculo) {
        for (Factura factura : facturas) {
            if (factura.getVehiculo().getPlaca().equals(placaVehiculo)) {
                return true;
            }
        }
        return false;
    }



    private static Cliente buscarClientePorId( String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    private static Vehiculo buscarVehiculoPorPlaca( String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    private static void leerFacturas() {
        System.out.println("Lista de Facturas:");
        for (Factura factura : facturas) {
            System.out.println("Cliente: " + factura.getCliente().getId());
            System.out.println("Vehículo: " + factura.getVehiculo().getPlaca());
            System.out.println("Fecha Inicial: " + factura.getFechaInicial());
            System.out.println("Fecha Final: " + factura.getFechaFinal());
            System.out.println("Costo: " + factura.getCosto());
            System.out.println();
        }
    }

    private static void actualizarFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente de la factura a actualizar: ");
        String clienteId = scanner.nextLine();
        System.out.print("Ingrese la placa del vehículo de la factura a actualizar: ");
        String placaVehiculo = scanner.nextLine();

        // Buscar la factura
        Factura facturaExistente = buscarFactura(clienteId, placaVehiculo);

        if (facturaExistente == null) {
            System.out.println("No se encontró una factura con los datos especificados.");
            return;
        }

        System.out.print("Nueva Fecha Inicial: ");
        String nuevaFechaInicialString = scanner.nextLine();
        System.out.print("Nueva Fecha Final: ");
        String nuevaFechaFinalString = scanner.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date nuevafechaInicial = null;
        try {
            nuevafechaInicial = formatter.parse(nuevaFechaInicialString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date nuevafechaFinal = null;
        try {
            nuevafechaFinal = formatter.parse(nuevaFechaFinalString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // Actualizar las fechas en la factura
        facturaExistente.setFechaInicial(nuevafechaInicial);
        facturaExistente.setFechaFinal(nuevafechaFinal);

        System.out.println("Factura actualizada exitosamente.");
    }
    private static Factura buscarFactura( String clienteId, String placaVehiculo) {
        for (Factura factura : facturas) {
            if (factura.getCliente().getId().equals(clienteId) && factura.getVehiculo().getPlaca().equals(placaVehiculo)) {
                return factura;
            }
        }
        return null;
    }

    private static void eliminarFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente de la factura a eliminar: ");
        String clienteId = scanner.nextLine();
        System.out.print("Ingrese la placa del vehículo de la factura a eliminar: ");
        String placaVehiculo = scanner.nextLine();

        // Buscar y eliminar la factura
        Factura facturaExistente = buscarFactura( clienteId, placaVehiculo);

        if (facturaExistente == null) {
            System.out.println("No se encontró una factura con los datos especificados.");
            return;
        }

        facturas.remove(facturaExistente);
        System.out.println("Factura eliminada exitosamente.");
    }


    private static void guardarDatosEnCSV() {
        try (PrintWriter vehiculosWriter = new PrintWriter(new FileWriter("vehiculos.csv"));
             PrintWriter clientesWriter = new PrintWriter(new FileWriter("clientes.csv"));
             PrintWriter facturasWriter = new PrintWriter(new FileWriter("facturas.csv"))) {

            for (Vehiculo vehiculo : vehiculos) {
                vehiculosWriter.println(vehiculo.toString());
            }

            for (Cliente cliente : clientes) {
                clientesWriter.println(cliente.toString());
            }

            for (Factura factura : facturas) {
                facturasWriter.println(factura.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void cargarVehiculosDesdeCSV() {
        try (Scanner scanner = new Scanner(new File("vehiculos.csv"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 4) {
                    String placa = datos[0];
                    String tipo = datos[1];
                    int capacidad = Integer.parseInt(datos[2]);
                    double valorAlquiler = Double.parseDouble(datos[3]);
                    vehiculos.add(new Vehiculo(placa, tipo, capacidad, valorAlquiler));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo vehiculos.csv no se encontró.");
        }
    }

    // Función para leer clientes desde un archivo CSV y cargarlos en la lista de clientes
    private static void cargarClientesDesdeCSV() {
        try (Scanner scanner = new Scanner(new File("clientes.csv"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 3) {
                    String id = datos[0];
                    String nombre = datos[1];
                    String telefono = datos[2];
                    clientes.add(new Cliente(id, nombre, telefono));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo clientes.csv no se encontró.");
        }
    }

    // Función para leer facturas desde un archivo CSV y cargarlos en la lista de facturas
    private static void cargarFacturasDesdeCSV() {
        try (Scanner scanner = new Scanner(new File("facturas.csv"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 5) {
                    String clienteId = datos[0];
                    String vehiculoPlaca = datos[1];
                    String fechaInicialString = datos[2];
                    String fechaFinalString = datos[3];
                    double costo = Double.parseDouble(datos[4]);
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaInicial = formatter.parse(fechaInicialString);
                    Date fechaFinal = formatter.parse(fechaFinalString);

                    // Buscar el cliente y el vehículo correspondientes en las listas
                    Cliente cliente = null;
                    for (Cliente c : clientes) {
                        if (c.getId().equals(clienteId)) {
                            cliente = c;
                            break;
                        }
                    }
                    Vehiculo vehiculo = null;
                    for (Vehiculo v : vehiculos) {
                        if (v.getPlaca().equals(vehiculoPlaca)) {
                            vehiculo = v;
                            break;
                        }
                    }

                    // Crear la factura y agregarla a la lista
                    if (cliente != null && vehiculo != null) {
                        facturas.add(new Factura(cliente, vehiculo, fechaInicial, fechaFinal));

                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo facturas.csv no se encontró.");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    // Métodos para obtener iteradores de las listas
    static Iterator<Vehiculo> getVehiculoIterator() {
        return new Vehiculo.VehiculoIterator(vehiculos.iterator());
    }

    static Iterator<Cliente> getClienteIterator() {
        return new Cliente.ClienteIterator(clientes.iterator());
    }

    static Iterator<Factura> getFacturaIterator() {
        return new Factura.FacturaIterator(facturas.iterator());
    }
}
