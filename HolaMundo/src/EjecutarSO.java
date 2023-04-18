

 public class EjecutarSO {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Process proceso;


            try {
                if(System.getProperty("os.name").toLowerCase().startsWith("windows")){
                    proceso = rt.exec("notepad");
                } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
                    proceso = rt.exec("notepad");
                } else{
                    proceso = rt.exec("gedit");
                }
                proceso.waitFor();
            } catch (Exception e) {
                System.err.println("Comando desconocido: " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Se ha cerrado");
            System.exit(0);

    }
}
