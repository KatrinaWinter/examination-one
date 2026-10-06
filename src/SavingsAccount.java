public class SavingsAccount extends Account{

    private  double interestRate;

    public SavingsAccount(String owner, double balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    /*public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
    }*/

    @Override
    public void showHistory(){
        super.showHistory();
        System.out.println("Årlig ränta: " + interestRate + "kr");
    }
}

/*

    extends Account
├── interestRate
└── applyInterest()*/