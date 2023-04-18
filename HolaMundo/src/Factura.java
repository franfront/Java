
    import java.util.Scanner;

    public class Factura {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese el nombre de la factura: ");
            String nombreFactura = sc.nextLine();

            System.out.print("Ingrese el precio del primer producto: ");
            double precio1 = sc.nextDouble();

            System.out.print("Ingrese el precio del segundo producto: ");
            double precio2 = sc.nextDouble();

            double totalBruto = precio1 + precio2;
            double impuesto = totalBruto * 0.19;
            double totalNeto = totalBruto + impuesto;

            System.out.println("Nombre de la factura: " + nombreFactura);
            System.out.println("Monto total bruto: $" + totalBruto);
            System.out.println("Impuesto: $" + impuesto);
            System.out.println("Monto total neto: $" + totalNeto);
        }
    }

