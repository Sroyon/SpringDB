package bank;
import java.time.LocalDateTime;
import java.util.UUID;

public class transaction implements java.io.Serializable{
    private String transId;
    private String transTime;
    private bankAccount fromAcc;
    private float amount;
    private bankAccount toAcc;
    public transaction(bankAccount fromAcc, bankAccount toAcc, float amount) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.transId = "";
        this.transTime = "";
    }

    void sendMoney(float amountTrans){
        if (toAcc == null || fromAcc == null) {
            System.out.println("Transaction failed: missing account.");
            return;
        }
        /*if(amountTrans <= 0){
            System.out.println("Invalid amount to transfer from Account ");
            return;
        }*/
        if (fromAcc.accBalance < amountTrans) {
            System.out.println("Insufficient balance in source account.");
            return;
        }
        fromAcc.withdraw(amountTrans);
        toAcc.deposit(amountTrans);
        System.out.println("Sent Rs. " + amountTrans + " from Account " + fromAcc.accNum + " to Account " + toAcc.accNum);
        this.amount = amountTrans;
        this.transId = UUID.randomUUID().toString();
        this.transTime = LocalDateTime.now().toString();
        viewTransDetails.addTransaction(this);
        
    }
    public String getTransId(){
         return transId; 
    }
    public String getTransTime() { 
        return transTime;
    }
    public bankAccount getFromAcc(){
        return fromAcc; }
    public bankAccount getToAcc(){
        return toAcc;
    }
    public float getAmount(){ 
        return amount; 
    }

}
