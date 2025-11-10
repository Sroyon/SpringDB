package bank;

class savingsAccount extends bankAccount{
    private float intRate;
    savingsAccount(String accNum, float accBalance, float intRate){
        super(accNum, accBalance);
        this.intRate = intRate;
    }
    void depositImpl(float amount){
        if (!checkIfPositive(amount)) {
            return;
        }
        accBalance += amount;
        userInfo.saveUsers();
        //System.out.println("Deposited Rs. " + amount + " to Savings Account " + accNum); 
    }
    boolean checkBalance(float amount){
        //if (!checkIfPositive(amount)) {
            //System.out.println("Withdrawal amount must be positive.");
            //return;
        //}
            return amount<= accBalance;
            //userInfo.saveUsers();
            //System.out.println("Withdrew Rs. " + amount + " from Savings Account " + accNum); 
        }
    
    void addInterest(){
        float interest = (accBalance * intRate) / 100;
        accBalance += interest;
        System.out.println("Added interest Rs. " + interest + " to Savings Account " + accNum); 
    }
    
}