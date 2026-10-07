public class SavingsAccount extends Account{

    private  double interestRate;

    public SavingsAccount(String owner, double balance) {
        super(owner, balance);
        this.interestRate = 5;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
    }

    @Override
    public void showHistory(){
        super.showHistory();
        System.out.println("Årlig ränta: " + interestRate + "%");
    }
}