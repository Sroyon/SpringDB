package bank;
import java.io.*;
import java.util.*;

 class viewTransDetails{
    private static ArrayList<transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.dat";

    static {
        loadTransactions();
    }
    
    public static void addTransaction(transaction t){
        transactions.add(t);
        saveTransactions();
    }
    public static void viewTransactions(bankAccount user){
        System.out.println("Transaction Details for Account: " + user.accNum);
        System.out.println("-------------------------------");
        boolean f = false;
        for(transaction t : transactions){
            if(t.getFromAcc().accNum.equals(user.accNum)|| t.getToAcc().accNum.equals(user.accNum))
            {
                f = true;
                System.out.println("ID: " + t.getTransId() + " | From: " + t.getFromAcc().accNum+ " | To: " 
                                    + t.getToAcc().accNum
                                    + " | Amount: Rs." + t.getAmount()
                                    + " | Time: " + t.getTransTime());
            }
        }
        if(!f){
                System.out.println("No transactions found for this account.");
        }
    }
    private static void saveTransactions() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(transactions);
        } catch (Exception e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")    
    private static void loadTransactions() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            transactions = (ArrayList<transaction>) ois.readObject();
            //System.out.println("Loaded " + transactions.size() + " transactions from storage.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous transactions found.");
        } catch (Exception e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
    }
 }