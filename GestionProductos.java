import java.util.ArrayList;
import java.util.Scanner;

public class GestionProductos {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    venderProducto();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Gestión de Productos ***");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Vender producto");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese el stock inicial del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        int id = productos.size() + 1;
        Producto nuevoProducto = new Producto(id, nombre, descripcion, precio, stock);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    private static void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    private static void venderProducto() {
        System.out.print("Ingrese el ID del producto a vender: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                if (producto.getStock() >= cantidad) {
                    producto.reducirStock(cantidad);
                    System.out.println("Venta realizada con éxito.");
                } else {
                    System.out.println("Stock insuficiente.");
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
}
