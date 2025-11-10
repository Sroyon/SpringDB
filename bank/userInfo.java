package bank;
import java.io.*;
import java.util.*;

public class userInfo {
        private static class User implements Serializable{
            String username;
            String password;
            bankAccount account;
            User(String username, String password, bankAccount account){
                this.username = username;
                this.password = password;
                this.account = account;
            }
        }
        private static ArrayList<User> users = new ArrayList<>();
        private static final String FILE_NAME = "users.dat";
        @SuppressWarnings("unchecked")
        public static void loadUsers(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (ArrayList<User>) ois.readObject();
            }
            catch (FileNotFoundException e) {
            System.out.println("No previous user data found.");
            }
            catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
            }
    }
    public static void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

        public static void registerUser(String username, String password, bankAccount account){
            for(User user : users){
                if(user.username.equals(username)){
                    System.out.println("Username already exists. Please choose a different username.");
                    return;
                }
            }
            users.add(new User(username, password, account));
            saveUsers();
            System.out.println("User registered successfully.");
        }

        public static bankAccount login(String username, String password)
        {
            for(User u : users){
                if(u.username.equals(username) && u.password.equals(password)){
                    System.out.println("Login successful.");
                    return u.account;
                }
            }
            System.out.println("Invalid username or password.");
            return null;
        }

        public static bankAccount getAccountbyNum(String accNum){
            for(User u : users){
                if(u.account.accNum.equals(accNum)){
                    return u.account;
                }
            }
            System.out.println("Account not found.");
            return null;
        }
}
