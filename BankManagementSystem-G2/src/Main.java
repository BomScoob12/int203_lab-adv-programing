import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] menu = {"Display all account - 1", "Open account - 2", "Close account - 3", "Deposit - 4", "Withdraw money - 5", "Exit. - 6"};
        Bank bnkBank = new Bank("Bangkok-Bank","BangMod",111);
        Scanner scan = new Scanner(System.in);
        int option = 0;


        while (option != 6) {
            for (String s : menu) {
                System.out.println(s);
            }
            System.out.print("Enter option : ");
            option = scan.nextInt();
            if (option > 6) System.out.println("Error");

            switch (option) {
                case 1 -> {
                    bnkBank.listAccount();
                }
                case 2 -> {
                    System.out.print("Enter account Name");
                    String accountName = scan.nextLine();
                    scan.nextLine();
                    System.out.print("Enter balance :");
                    double balance = scan.nextInt();
                    bnkBank.openAccount(generateAccNumber(), accountName, balance);
                }
                case 3 -> {
                    System.out.print("Enter account Number");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    bnkBank.closeAccount(accountNumber);
                }
                case 4 -> {
                    System.out.print("Enter account Number");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter amount");
                    double amount = scan.nextDouble();
                    bnkBank.depositMoney(accountNumber,amount);
                }
                case 5 -> {
                    System.out.print("Enter account Number");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter amount");
                    double amount = scan.nextDouble();
                    bnkBank.withdrawMoney(accountNumber,amount);
                }
            }
        }
        System.out.println("Goodbye:::");

    }

    public static int generateAccNumber(){
        Random random = new Random();
        return random.nextInt(100000,999999);
    }
}