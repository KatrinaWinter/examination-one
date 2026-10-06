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
            }  else if (choice == 2){ //Skapa Sparkonto
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                System.out.println("Startsaldo: ");
                double balance = scanner.nextInt();
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
            } else if (choice == 6){ // Visa Ränta
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null) {
                    if (found instanceof SavingsAccount) {
                        SavingsAccount savings = (SavingsAccount) found;
                        System.out.println("Din ränta är: " + savings.calculateInterest());
                    }else {
                        System.out.println("Detta konto är inte ett Sparkonto: " + name);
                    }
                }else {
                    System.out.println("Konto saknas: " + name);
                    }
            } else if (choice == 7){ // Lägg till Ränta
                System.out.println("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null) {
                    if (found instanceof SavingsAccount) {
                        SavingsAccount savings = (SavingsAccount) found;
                        System.out.println("Din ränta är: " + savings.calculateInterest());
                        savings.applyInterest();
                        System.out.println("Nytt saldo: " + found.getBalance());
                    }else {
                        System.out.println("Detta konto är inte ett Sparkonto: " + name);
                    }
                }else {
                    System.out.println("Konto saknas: " + name);
                }
            } else if (choice == 8) { //Hisorik
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
        System.out.println("");
        System.out.println("--- VÄLKOMMEN TILL BANKOMATEN ---");
        System.out.println("");
    }

    public static void showMenu() {
        System.out.println("1. Skapa konto  | 2. Skapa Sparkonto |3. Insättning     | 4. Uttag  ");
        System.out.println("5. Lista Konton | 6. Visa Ränta      |7. Läg till Ränta | 8. Historik ");
        System.out.println("0. Avsluta");
        //
    }
}
