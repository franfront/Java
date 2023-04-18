import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producto {
        private String nombre;
        private double precio;
        private int cantidadDisponible;

        public Producto(String nombre, double precio, int cantidadDisponible) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidadDisponible = cantidadDisponible;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidadDisponible() {
            return cantidadDisponible;
        }
    }

    public class ItemCarrito {
        private Producto producto;
        private int cantidad;

        public ItemCarrito(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public Producto getProducto() {
            return producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getPrecioTotal() {
            return producto.getPrecio() * cantidad;
        }
    }

    public class Carrito {
        private List<ItemCarrito> items;

        public Carrito() {
            items = new ArrayList<>();
        }

        public void agregarItem(Producto producto, int cantidad) {
            if (producto.getCantidadDisponible() < cantidad) {
                throw new IllegalArgumentException("No hay suficientes unidades disponibles de este producto.");
            }

            ItemCarrito item = new ItemCarrito(producto, cantidad);
            items.add(item);
        }

        public void eliminarItem(ItemCarrito item) {
            items.remove(item);
        }

        public List<ItemCarrito> getItems() {
            return items;
        }

        public double getPrecioTotal() {
            double precioTotal = 0.0;
            for (ItemCarrito item : items) {
                precioTotal += item.getPrecioTotal();
            }
            return precioTotal;
        }
    }

    public class Descuento {
        private String codigo;
        private double porcentaje;

        public Descuento(String codigo, double porcentaje) {
            this.codigo = codigo;
            this.porcentaje = porcentaje;
        }

        public String getCodigo() {
            return codigo;
        }

        public double getPorcentaje() {
            return porcentaje;
        }
    }

    public class DescuentoPorCantidad extends Descuento {
        private int cantidadMinima;

        public DescuentoPorCantidad(String codigo, double porcentaje, int cantidadMinima) {
            super(codigo, porcentaje);
            this.cantidadMinima = cantidadMinima;
        }

        public int getCantidadMinima() {
            return cantidadMinima;
        }
    }

    public class DescuentoPorMonto extends Descuento {
        private double montoMinimo;

        public DescuentoPorMonto(String codigo, double porcentaje, double montoMinimo) {
            super(codigo, porcentaje);
            this.montoMinimo = montoMinimo;
        }

        public double getMontoMinimo() {
            return montoMinimo;
        }
    }



    public class Main {

        public static void main(String[] args) {
            List<Producto> productos = new ArrayList<>();
            try {
                File archivo = new File("productos.txt");
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] partes = linea.split(",");
                    String nombre = partes[0];
                    double precio = Double.parseDouble(partes[1]);
                    int cantidadDisponible = Integer.parseInt(partes[2]);
                    Producto producto = new Producto(nombre, precio, cantidadDisponible);
                    productos.add(producto);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("No se pudo encontrar el archivo.");
            }

            Carrito carrito = new Carrito();
            carrito.agregarItem(productos.get(0), 2);
            carrito.agregarItem(productos.get(1), 1);
            carrito.agregarItem(productos.get(2), 3);

            for (ItemCarrito item : carrito.getItems()) {
                String nombre = item.getProducto().getNombre();
                double precioUnitario = item.getProducto().getPrecio();
                int cantidad = item.getCantidad();
                double precioTotal = item.getPrecioTotal();
                System.out.printf("%d x %.2f %s: %.2f\\n", cantidad, precioUnitario, nombre, precioTotal);
            }
        }
    }

