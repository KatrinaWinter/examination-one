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

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){ //Skapa konto
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                System.out.println("Startsaldo: ");
                double balance = scanner.nextInt();
                scanner.nextLine();
                register.createAccount(name, balance);
                System.out.println("Kontot skapat.");
            } else if (choice == 2){ //Skapa Sparkonto
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                System.out.println("Startsaldo: ");
                double balance = scanner.nextInt();
                System.out.println("Ränta: ");
                double interestRate = scanner.nextInt();
                scanner.nextLine();
                register.createSavingsAccount(name, balance);
                System.out.println("Sparkontot skapat.");
            } else if (choice == 3) { //Insättning
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null) {
                    System.out.println("Belop:");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    found.deposit(amount);
                    System.out.println("Nytt saldo: " + found.getBalance());
            } else {
                    System.out.println("Konto saknas: " + name);
                }
            }else if (choice == 4) { //Uttag
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null) {
                    System.out.println("Belop:");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    found.withdraw(amount);
                    System.out.println("Nytt saldo: " + found.getBalance());
                } else {
                    System.out.println("Konto saknas: " + name);
                }
                } else if (choice == 5){ // Lista
                register.printAll();
            } else if (choice == 6) { //Hisorik
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null){
                found.showHistory();
                } else {
                    System.out.println("Konto saknas: " + name);
                }
            }  else if (choice == 0) { //Avsluta
                System.out.println("Hejdå!");
            } else {
                System.out.println("Försök igen.");
            }
            }

}
    public static void showWelcome() {
        System.out.println("--- VÄLKOMMEN TILL BANKOMATEN ---");
    }

    public static void showMenu() {
        System.out.println("1. Skapa konto |  2. Skapa sparkonto | 3. Insättning | 4. Uttag |  5. Lista konton | 6. Historik |  0. Avsluta");
        //  0. Årlig ränta |
    }
}
