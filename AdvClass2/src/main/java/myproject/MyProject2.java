package myproject;

public class MyProject2 {
    public static void main(String[] args) {
        try {
            int[] list = new int[10];
            System.out.println("List[10] is " + list[10]);
        }
        catch (ArithmeticException ex){
            System.out.println("ArithmeticException");
        }
        catch (RuntimeException ex) {
            System.out.println("RuntimeException");
        }
        catch (Exception ex) {
            System.out.println("Exception");
        }
        finally {

        }
    }
}
