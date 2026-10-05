public class Account {
    private String owner;
    private double balance;

    //constructor
    public Account(String owner, double initialBalance){
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0){
            System.out.println("Ogiltigt uttag.");
            return false;
        }
        if (amount > this.balance){
            System.out.println("Uttag stoppats! för lite pengar.");
            return false;
        }
        this.balance = this.balance - amount;
        return true;
    }

}
