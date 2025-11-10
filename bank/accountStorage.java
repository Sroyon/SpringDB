package bank;
import java.util.*;

public class accountStorage {
        private ArrayList<bankAccount> accounts = new ArrayList<>();
        public bankAccount getAccount(String accNum){
                for(bankAccount acc : accounts){
                        if(acc.accNum.equals(accNum)){
                                return acc;
                        }
                }
                System.out.println("Account not found!");
                return null;
        
        }
        public void addAccount(bankAccount acc){
                accounts.add(acc);
        }
}
