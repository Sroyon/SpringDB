package bank;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        userInfo.loadUsers();

        System.out.println("Welcome to the Bank Management System!");
        System.out.println("Please login to continue.");
        boolean loggedIn = false;
        String username, password;
        bankAccount Account = null;
        while(!loggedIn){
        System.out.println("Enter choice\n1.Login\n2.Create New Account");
        int ch = sc.nextInt();
        sc.nextLine();
                if(ch==1){
                    System.out.print("Username: ");
                    username = sc.nextLine();
                    System.out.print("Password: ");
                    password = sc.nextLine();
                    bankAccount userAccount = userInfo.login(username, password);
                    if(userAccount == null)
                    {
                        System.out.println("Account not found, please create one");
                    }
                    else
                    {
                        loggedIn = true;
                        System.out.println("Login successful! Welcome " + username);
                        Account = userAccount; 
                    }
                }
            if(ch==2){
                System.out.println("Enter desired username: ");
                username = sc.nextLine();
                System.out.println("Enter desired password: ");
                password = sc.nextLine();
                System.out.println("Enter account type : 1.Savings 2.Current");
                int type = sc.nextInt();
                sc.nextLine();
                bankAccount newAccount;
                System.out.println("Enter account number: ");
                String accNum = sc.nextLine();
                System.out.println("Enter initial deposit amount: ");
                float initialDeposit = sc.nextFloat();
                if(type == 1){
                    System.out.println("Enter interest rate: ");
                    newAccount = new savingsAccount(accNum, initialDeposit, sc.nextFloat());
                } else {
                    System.out.println("Enter overdraft limit: ");
                    newAccount = new currentAccount(accNum, initialDeposit, sc.nextFloat());
                }
                userInfo.registerUser(username, password, newAccount);
                Account = newAccount;
                System.out.println("Account created successfully! Please login to continue.");
            }
        }
        userMenu(Account);
    }
    public static void userMenu(bankAccount account)
    {   
        System.out.println("Welcome to your account menu!");
        System.out.println("Menu : 1.Deposit 2.Withdraw 3.Send Money 4.View Balance 5.View Transactions 6.Exit");
        int choice=0;
        while(choice!=6)
        {
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    float depAmount = sc.nextFloat();
                    account.deposit(depAmount);
                    System.out.println("Balance added successfully.");
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    float withAmount = sc.nextFloat();
                    account.withdraw(withAmount);
                    System.out.println("Withdrawal processed successfully for amount " + withAmount);
                    break;
                case 3:
                    System.out.println("Enter recipient account number: ");
                    String toAccNum = sc.nextLine();
                    System.out.println("Enter amount to send: ");
                    float sendAmount = sc.nextFloat();
                    transaction trans = new transaction(account, userInfo.getAccountbyNum(toAccNum),sendAmount);
                    trans.sendMoney(sendAmount);  
                    //System.out.println("Money sent successfully.");
                    break;
                case 4:
                    System.out.println("Current balance: Rs. " + account.displayBalance());
                    break;
                case 5:
                    viewTransDetails.viewTransactions(account); 
                    break;
                case 6:
                    System.out.println("Exiting account menu. Thank you for using our services!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }
}
