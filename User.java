import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class User {
    private int role;
    private String name;
    private String password;

    public User(int role, String name, String password){
        this.role = role;
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getPass(){
        return password;
    }

    public static void setPass(int index, String password){
        User.userList.get(index).password = password;
    }

    public static void setRole(int index, int role){
        User.userList.get(index).role = role;
    }

    public int getRole(){
        return role;
    }

    @Override
    public String toString(){
        return role+","+name +","+password;
    }

    static ArrayList<User> userList = new ArrayList<User>();

    public static void readData(){
        try {
            Scanner read = new Scanner(new File("user.txt")).useDelimiter(",|\\s");

            while(read.hasNext()){
                if(read.hasNextInt()){
                    int role = Integer.parseInt(read.next());
                    String name = read.next();
                    String password = read.next();
                    userList.add(new User(role, name, password));
                }else{
                    read.next();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    static PageAdmin pageAdmin;
    static PageTechnician pageTechnician;
    static PageCustomer pageCustomer; 

    public static void userLogin() throws Exception{
        String username = MainPage.userInput.getText();
        int index = -1;
        for (int i = 0; i < User.userList.size(); i ++) {
            if (User.userList.get(i).getName().equals(username)) {
                index = i;
                break;
            }
        }
        char[] password = MainPage.passwordInput.getPassword(); // Hide Password
        String enteredPassword = new String(password); // Get Password as String

        // Validate Password and Manager role
        if(enteredPassword.equals(User.userList.get(index).getPass()) && User.userList.get(index).getRole() == 0){
            MainPage.container.setVisible(false);
            MainPage.container.dispose();
            pageAdmin = new PageAdmin();
            PageAdmin.container.setVisible(true);
        }else if(enteredPassword.equals(User.userList.get(index).getPass()) && User.userList.get(index).getRole() == 1){
            MainPage.container.setVisible(false);
            MainPage.container.dispose();
            pageTechnician = new PageTechnician();
            PageTechnician.container.setVisible(true);
        } else if(enteredPassword.equals(User.userList.get(index).getPass()) && User.userList.get(index).getRole() == 2){
            MainPage.container.setVisible(false);
            MainPage.container.dispose();
            pageCustomer = new PageCustomer();
            PageCustomer.container.setVisible(true);
        }
        else {
            throw new Exception();
        }
    }

    public static List<String> readAppointmentFile(String fileName) {
        List<String> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appointments.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static List<String> readPaymentFile(String fileName) {
        List<String> payments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                payments.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payments;
    }
}