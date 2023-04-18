public class WrapperRelacionales {
    public static void main(String[] args) {
        Integer num1 = Integer.valueOf(1000);

        Integer num2 = 1000;
        System.out.println(num1 == num2);

        System.out.println(num1.equals(num2));

        Integer num3, num4;
        num3 = 1;

        num4 = 2;

        boolean primBool = num1>num2; // false
        Boolean objBool = primBool;
        Boolean objBool2 = Boolean.valueOf("false");

        System.out.println(objBool == objBool2); //true, compara por referencia

        System.out.println(objBool.equals(objBool2)); // true


    }
}
