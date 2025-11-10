package bank;
abstract class bankAccount implements java.io.Serializable{
    protected String accNum;
    protected float accBalance;

        bankAccount(String accNum, float accBalance){
        this.accNum = accNum;
        this.accBalance = accBalance;
    }
    
    //abstract void withdrawImpl(float amount);
    abstract void depositImpl(float amount);
    abstract boolean checkBalance(float amount);
    /*void checkBalance(float amount)
    {
         if(accBalance < amount){
            System.out.println("Insufficient Balance in Account " + accNum);
            return;
         }

    }*/
    /*void checkBalance(float amount, float overdraftLimit)
    {
         if(accBalance + overdraftLimit < amount){
            System.out.println("Insufficient Balance in Account " + accNum);
            return;
         }

    }*/

    boolean checkIfPositive(float amount){
        System.out.println("Amount must be positive.");
        return amount > 0;
        
    }
    void withdraw(float amount)
    {
        if(checkIfPositive(amount))
        {                                   
            if(checkBalance(amount)){
                accBalance -= amount;
                userInfo.saveUsers();
            }
            else{
                System.out.println("Insufficient Balance in Account " + accNum);
            }
        }
        else
        {
            return;
        }
    }

    void deposit(float amount)
    {
        if(checkIfPositive(amount))
        {                               
            depositImpl(amount);        
        }
        else
        {
            return;
        }
    }
    String displayBalance(){
        return accBalance+"";
    }
}
