import java.util.List;
import java.util.ArrayList;

public class AccountRegister {
    private List<Account> accounts = new ArrayList<>();

     public void createAccount(String owner, double startBalance){
         Account account = new Account(owner, startBalance);
         accounts.add(account);
    }

    public SavingsAccount createSavingsAccount(String owner, double startBalance) {
        SavingsAccount account = new SavingsAccount(owner, startBalance);
        accounts.add(account);
        return account;
    }

    public void printAll(){
         for (int i = 0; i < accounts.size(); i++){
           Account a = accounts.get(i);
             if (a instanceof SavingsAccount) {
                 SavingsAccount savings = (SavingsAccount) a;
                 System.out.println("Sparkonto - " + a.getOwner() + ": " + a.getBalance() + "kr, Ränta: "
                         + savings.getInterestRate() + "%");
             } else {
                 System.out.println("Vanligt konto - " + a.getOwner() + ": " + a.getBalance() + "kr");
             }
         }
    }

    public Account findAccount(String owner){
        for (int i =0; i < accounts.size(); i++){
            Account a = accounts.get(i);
            if (a.getOwner().equalsIgnoreCase(owner)){
                return a;
            }
        }
        return null;
    }


}