package bank;

class currentAccount extends bankAccount{
    private float overdraftLimit;
    currentAccount(String accNum, float accBalance, float overdraftLimit){
        super(accNum, accBalance);
        this.overdraftLimit = overdraftLimit;
    }
    void depositImpl(float amount){
        //if (!checkIfPositive(amount))
            //return;
        accBalance += amount;
        userInfo.saveUsers();
        //System.out.println("Deposited Rs. " + amount + " to Current Account " + accNum); 
    }
    boolean checkBalance(float amount){
        //if (!checkIfPositive(amount))
            //return;
            return amount+overdraftLimit>= accBalance;
            //userInfo.saveUsers();
            //System.out.println("Withdrew Rs. " + amount + " from Current Account " + accNum); 
    }
}