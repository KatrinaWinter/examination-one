public class Main {
    public static void main(String[] args){


        AccountRegister register = new AccountRegister();

        register.createAccount("Katrina", 1000);
        register.createAccount("Anna", 500);
        register.createAccount("Lisa", 2000);

        register.printAll();

        Account account = register.findAccount("Anna");


        System.out.println("Hittade: " + account.getOwner());
        System.out.println("Saldo: " + account.getBalance());

        account = register.findAccount("Peter");
        System.out.println("Hittade: " + account.getOwner());

}
}
