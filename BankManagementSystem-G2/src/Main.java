import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String accountName;
        double balance;
        int accType = 0;
        int option = 0;

        String[] menu = {"Display all account - 1", "Open account - 2", "Close account - 3", "Deposit - 4", "Withdraw money - 5", "Exit. - 6"};
        Bank bnkBank = new Bank("Bangkok-Bank", "BangMod", 111);
        Scanner scan = new Scanner(System.in);


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
                    int accNumber = generateAccNumber();
                    System.out.println("OpenAccount");
                    System.out.println("1.CurrentAccount");
                    System.out.println("2.FixedDepositAccount");
                    System.out.println("3.SavingAccount");
                    scan.nextLine();
                    System.out.print("Enter Account Types:");
                    accType = scan.nextInt();
                    System.out.print("Enter account Name :");
                    scan.nextLine();
                    accountName = scan.nextLine();
                    System.out.print("Enter balance :");
                    balance = scan.nextDouble();
                    switch (accType) {
                        case 1 -> {
                            CurrentAccount account = new CurrentAccount(accNumber, accountName, balance);
                            bnkBank.openAccount(account);
                            System.out.print("Set minimum :");
                            double minimum = scan.nextDouble();
                            account.setMinimum(minimum);
                            System.out.println("Current Account Created.");
                        }
                        case 2 -> {
                            bnkBank.openAccount(new FixedDepositAccount(accNumber, accountName, balance));
                            System.out.println("Saving account created");
                        }
                        case 3 -> {
                            bnkBank.openAccount(new SavingAccount(accNumber, accountName, balance));
                            System.out.println("Saving account created");
                        }
                    }

                    System.out.println("Account created");
                }
                case 3 -> {
                    System.out.print("Enter account Number");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Select account type");
                    System.out.println("OpenAccount");
                    System.out.println("1.CurrentAccount");
                    System.out.println("2.FixedDepositAccount");
                    System.out.println("3.SavingAccount");
                    System.out.print("Enter account type:");
                    accType = scan.nextInt();
                    scan.nextLine();
                    switch (accType) {
                        case 1 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Current Account");
                            bnkBank.closeAccount(account);
                        }
                        case 2 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Fixed Deposit Account");
                            bnkBank.closeAccount(account);
                        }
                        case 3 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Saving Account");
                            bnkBank.closeAccount(account);
                        }
                    }

                }
                case 4 -> {
                    System.out.println("Deposit menu");
                    System.out.print("Enter account Number");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Select account type");
                    System.out.println("OpenAccount");
                    System.out.println("1.CurrentAccount");
                    System.out.println("2.FixedDepositAccount");
                    System.out.println("3.SavingAccount");
                    System.out.print("Enter account type:");
                    accType = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter amount");
                    double amount = scan.nextDouble();
                    switch (accType) {
                        case 1 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Current Account");
                            bnkBank.depositMoney(account, amount);
                        }
                        case 2 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Fixed Deposit Account");
                            bnkBank.depositMoney(account, amount);
                        }
                        case 3 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Saving Account");
                            bnkBank.depositMoney(account, amount);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Withdraw menu");
                    System.out.print("Enter account Number");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Select account type");
                    System.out.println("OpenAccount");
                    System.out.println("1.CurrentAccount");
                    System.out.println("2.FixedDepositAccount");
                    System.out.println("3.SavingAccount");
                    System.out.print("Enter account type:");
                    accType = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter amount");
                    double amount = scan.nextDouble();
                    switch (accType) {
                        case 1 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Current Account");
                            bnkBank.withdrawMoney(account, amount);
                        }
                        case 2 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Fixed Deposit Account");
                            bnkBank.withdrawMoney(account, amount);
                        }
                        case 3 -> {
                            Account account = bnkBank.getAccount(accountNumber, "Saving Account");
                            bnkBank.withdrawMoney(account, amount);
                        }
                    }
                }
                case 6 -> System.out.println(":::Goodbye:::");

            }
            System.out.println();
        }

    }

    public static int generateAccNumber() {
        Random random = new Random();
        return random.nextInt(100000, 999999);
    }

}