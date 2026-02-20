import java.util.Scanner;
import archivos.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Portafolio portafolio;

        try {
            portafolio = Portafolio.cargar();
            System.out.println("se ha cargado el portafolio");
        } catch (Exception e) {
            System.out.println("no hay ningun portafolio cargado");
            portafolio = new Portafolio(12,12);
        }

        boolean salir = false;

        while (!salir) {

            System.out.println("\n BRAZZERS PORTAFOLIO");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Registrar producto");
            System.out.println("4. Listar proveedores");
            System.out.println("5. Listar clientes");
            System.out.println("6. Listar productos");
            System.out.println("7. Aumentar stock");
            System.out.println("8. Vender producto");
            System.out.println("9. Guardar");
            System.out.println("10. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1:
                        System.out.print("Id proveedor: ");
                        int idProv = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombreProv = sc.nextLine();

                        System.out.print("Teléfono: ");
                        String telefono = sc.nextLine();

                        portafolio.agregarProveedor(
                                new Proveedor(idProv, nombreProv, telefono)
                        );
                        System.out.println("Proveedor registrado.");
                        break;

                    case 2:
                        System.out.print("ID cliente: ");
                        int idCliente = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombreCliente = sc.nextLine();

                        portafolio.agregarCliente(
                                new Cliente(idCliente, nombreCliente)
                        );
                        System.out.println("Cliente registrado");
                        break;

                    case 3:
                        System.out.print("Código producto: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombreProd = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        System.out.print("Stock: ");
                        int stock = sc.nextInt();

                        System.out.print("ID proveedor: ");
                        int idProveedor = sc.nextInt();

                        portafolio.agregarProducto(
                                new Producto(codigo, nombreProd, precio, stock, idProveedor)
                        );
                        System.out.println("Producto registrado.");
                        break;

                    case 4:
                        portafolio.listarProveedores();
                        break;

                    case 5:
                        portafolio.listarClientes();
                        break;

                    case 6:
                        portafolio.listarProductos();
                        break;

                    case 7:
                        System.out.print("Código producto: ");
                        int codStock = sc.nextInt();

                        System.out.print("Cantidad a aumentar: ");
                        int cantAum = sc.nextInt();

                        portafolio.aumentarStockProducto(codStock, cantAum);
                        System.out.println("Stock actualizado.");
                        break;

                    case 8:
                        System.out.print("Código producto: ");
                        int codVenta = sc.nextInt();

                        System.out.print("Cantidad a vender: ");
                        int cantVenta = sc.nextInt();

                        portafolio.venderProducto(codVenta, cantVenta);
                        System.out.println("Venta realizada.");
                        break;

                    case 9:
                        portafolio.guardar();
                        System.out.println("Datos guardados.");
                        break;

                    case 10:
                        portafolio.guardar();
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}