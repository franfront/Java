import java.util.Map;

public class VariablesEntorno {
    public static void main(String[] args) {

        Map<String, String> varEnv = System.getenv();
        System.out.println("variable de entorno = " + varEnv);

        
        String username = System.getenv("USERNAME");
        System.out.println("username = " + username);

        String path = System.getenv("Path");
        System.out.println("javaHome = " + path);

    }
}
