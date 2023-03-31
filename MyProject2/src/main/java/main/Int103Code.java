
package main;
import calculator.CalNum;
public class Int103Code {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hi Bro");
        
        testSum();
        
    }
    
    private static void testSum(){
        System.out.println(CalNum.sum(2, 5));
        System.out.println(CalNum.sum(12, 9));
    }
}
