public class Main {
    public static void main(String[] args){

    Account account = new Account("Katrina", 1000);

System.out.println(account.getOwner());
System.out.println(account.getBalance());

account.deposit(500);
System.out.println(account.getBalance());

account.withdraw(20.50);
System.out.println(account.getBalance());

account.withdraw(2000);
System.out.println(account.getBalance());
}
}
