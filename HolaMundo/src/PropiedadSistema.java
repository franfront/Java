import java.util.Properties;

public class PropiedadSistema {

    public static void main(String[] args) {
        String username = System.getProperty("user.name");
        System.out.println(username);

        String workspace = System.getProperty("user.dir");
        System.out.println(workspace);

        String lineSeparator = System.getProperty("line.separator");
        String lineSeparator2 = System.lineSeparator();

        System.out.println("lineSeparator:"+ lineSeparator + "una linea nueva...");

        Properties p = System.getProperties();
        p.list(System.out);
    }
}
