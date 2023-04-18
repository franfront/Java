import javax.swing.*;

public class EntradaDatos {


    public static void main(String[] args) {
        String numeroStr = JOptionPane.showInputDialog(null, "Ingrese un numero");

        int numero = Integer.parseInt(numeroStr);

        System.out.println(numero + 50);
    }




}
