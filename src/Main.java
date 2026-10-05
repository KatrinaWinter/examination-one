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
                int balance = scanner.nextInt();
                scanner.nextLine();
                register.createAccount(name, balance);
                System.out.println("Kontot skapat.");
            } else if (choice == 2) { //Insättning
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
            }else if (choice == 3) { //Uttag
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
                } else if (choice == 4){
                register.printAll();
            }else if (choice == 0) { //Avsluta
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
        System.out.println("1. Skapa konto |  2. Insättning | 3. Uttag | 4. Lista konton |  0. Avsluta");
        // 5. Historik | 6. Årlig ränta |
    }
}
