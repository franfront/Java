public class WrapperInteger {
    public static void main(String[] args) {
        Integer intObject = Integer.valueOf(32768);
        Integer intObject2 = 32768; // forma implicita

        System.out.println(intObject);


        int num = intObject; // forma implicita

        int num2 = intObject.intValue();

        String valorTv = "67000";

        Integer valor = Integer.valueOf(valorTv);
        System.out.println(valorTv);

        Short shortObj = intObject2.shortValue();
        System.out.println(shortObj); // cuando se excede el limite se pierden datos

        Byte byteObj = intObject.byteValue();
        System.out.println(byteObj);

        Long longObj = intObject.longValue();

        System.out.println(longObj);

    }
}
