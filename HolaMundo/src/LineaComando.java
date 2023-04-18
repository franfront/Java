public class LineaComando {
    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("debe ingresar argumentos o parAmetros");
            System.exit(-1);
        }


        for(int i = 0; i < args.length; i++){
            System.out.println("Argumentos nUmero " + i + ": " + args[i]);
        }
    }
}
