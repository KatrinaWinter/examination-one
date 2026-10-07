import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AccountRegister register = new AccountRegister();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        showWelcome();

        while (choice != 0){

            showMenu();
            System.out.println("Dit val:");

            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ange en siffra från menyn.");
                continue;
            }

            if (choice == 1){
                System.out.println("Namn: ");
                String name = scanner.nextLine();

                double balance = getBalance(scanner);

                register.createAccount(name, balance);
                Account found = register.findAccount(name);

                System.out.println("Kontot skapat: " + name
                        + " Startsaldo: " + found.getBalance() + " kr ");
                System.out.println();
            }  else if (choice == 2){
                System.out.println("Namn: ");
                String name = scanner.nextLine();

                double balance = getBalance(scanner);

                SavingsAccount savings = register.createSavingsAccount(name, balance);
                Account found = register.findAccount(name);

                System.out.println("Sparkontot skapat. " + name
                        + " Startsaldo: " + found.getBalance() + " kr "
                        + "Ränta: " + savings.getInterestRate() + "%");
                System.out.println();
            } else if (choice == 3) {
                System.out.println("Namn: ");
                String name = scanner.nextLine();

                Account found = register.findAccount(name);

                if (found != null) {
                    double amount = getAmount(scanner);
                    found.deposit(amount);
                    System.out.println("Nytt saldo: " + found.getBalance() + "kr");
            } else {
                    System.out.println("Konto saknas: " + name);
                }
            }else if (choice == 4) {
                System.out.println("Namn: ");
                String name = scanner.nextLine();

                Account found = register.findAccount(name);

                if (found != null) {
                    double amount = getAmount(scanner);
                    found.withdraw(amount);
                    System.out.println("Nytt saldo: " + found.getBalance() + "kr");
                } else {
                    System.out.println("Konto saknas: " + name);
                }
                } else if (choice == 5){
                register.printAll();
            } else if (choice == 6){
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null) {
                    if (found instanceof SavingsAccount) {
                        SavingsAccount savings = (SavingsAccount) found;
                        System.out.println("Din ränta är: " + savings.calculateInterest()
                                + " kr. Ditt saldo är: " + found.getBalance() + " kr");
                    }else {
                        System.out.println("Detta konto är inte ett Sparkonto: " + name);
                    }
                }else {
                    System.out.println("Konto saknas: " + name);
                    }
            } else if (choice == 7){
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null) {
                    if (found instanceof SavingsAccount) {
                        SavingsAccount savings = (SavingsAccount) found;
                        System.out.println("Din ränta är: " + savings.calculateInterest());
                        savings.applyInterest();
                        System.out.println("Nytt saldo: " + found.getBalance() + "kr");
                    }else {
                        System.out.println("Detta konto är inte ett Sparkonto: " + name);
                    }
                }else {
                    System.out.println("Konto saknas: " + name);
                }
            } else if (choice == 8) {
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null){
                found.showHistory();
                    System.out.println("Ditt saldo är: " + found.getBalance() + "kr");
                } else {
                    System.out.println("Konto saknas: " + name);
                }
            }  else if (choice == 0) {
                System.out.println("Hejdå!");
            } else {
                System.out.println("Försök igen! Ange en siffra från menyn.");
            }
            }

}
    public static void showWelcome() {
        System.out.println();
        System.out.println("--- VÄLKOMMEN TILL BANKOMATEN ---");
        System.out.println();
    }

    public static void showMenu() {
        System.out.println("1. Skapa konto  | 2. Skapa Sparkonto |3. Insättning     | 4. Uttag  ");
        System.out.println("5. Lista Konton | 6. Visa Ränta      |7. Läg till Ränta | 8. Historik ");
        System.out.println("0. Avsluta");
    }

    public static double getBalance(Scanner scanner) {
        while (true) {
            System.out.println("Startsaldo: ");
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ange ett giltigt belopp.");
            }
        }
    }

    public static double getAmount(Scanner scanner) {
        while (true) {
            System.out.println("Belopp:");
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ange ett giltigt belopp.");
            }
        }
    }

}
