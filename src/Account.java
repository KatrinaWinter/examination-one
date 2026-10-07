import java.util.List;
import java.util.ArrayList;

public class Account {
    private String owner;
    private double balance;
    private List<String> history = new ArrayList<>();


    public Account(String owner, double initialBalance){
        this.owner = owner;
        this.balance = initialBalance;
        if (initialBalance < 0){
            balance = 0;
        }
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ogiltig insättning.");
            return;
        }
        balance = balance + amount;
        history.add("Insättning: " + amount + " kr");
    }

    public boolean withdraw(double amount) {
        if (amount <= 0){
            System.out.println("Ogiltigt uttag.");
            return false;
        }
        if (amount > balance){
            System.out.println("Uttag stoppats! för lite pengar.");
            return false;
        }
        balance = balance - amount;
        history.add("Uttag: " + amount + " kr");
        return true;
    }

    public void showHistory() {

                if (history.isEmpty()) {
                    System.out.println("Inga transaktioner än.");
                    return;
                }

        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
                }
            }
        }



