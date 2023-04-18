public class PasarValor {
    public static void main(String[] args) {
        /* por valor
        int i = 10;

        test(i);
        System.out.println("Finaliza el main con i = " + i);
         */

        /* Por Referencia
        int edad[] = {10,11,12};

        for (int i = 0; i < edad.length; i++){
            System.out.println("edad[i] = " + edad[i] );
        }
        System.out.println("Antes del metodo");
        test(edad);

        System.out.println("Despues del metodo");
        for (int i = 0; i < edad.length; i++){
            System.out.println("edad[i] = " + edad[i] );
        }

        System.out.println("Finaliza con los datos modificados");
         */


    }

    public static void test(int[] edadArr){
        /* Por valor
        System.out.println("Inicia el metodo con i = " + n);
        n = 25;
        System.out.println("Finaliza el metodo con i = " + n);
        */

        /* Por referencia
        System.out.println("Inicia el metodo");
        for (int i = 0; i < edadArr.length; i++){
            edadArr[i] = edadArr[i] + 20;
        }
                 */
    }
}
