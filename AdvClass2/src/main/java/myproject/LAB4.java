package myproject;

public class LAB4 {
    public static void main(String[] args) {
        int[] list = new int[5];
        try{
            System.out.println("statement1");
//            System.out.println(1/0);
            System.out.println("Statement3");
            System.out.println(list[5]);
        } catch (ArithmeticException ex1){

        } catch (IndexOutOfBoundsException ex2){
            System.out.println("Index out of bound");
            throw ex2;
        } finally {
            System.out.println("Statement4");
        }
        System.out.println("Statement5");

    }
}
