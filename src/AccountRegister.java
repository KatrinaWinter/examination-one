import java.util.List;
import java.util.ArrayList;

public class AccountRegister {
    private List<Account> accounts = new ArrayList<>();

     public void createAccount(String owner, double startBalance){
         Account account = new Account(owner, startBalance);
         accounts.add(account);
    }

    public void printAll(){
         for (int i = 0; i < accounts.size(); i++){
           Account a = accounts.get(i);
             System.out.println(a.getOwner() + ": " + a.getBalance());
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
