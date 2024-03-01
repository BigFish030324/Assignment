import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

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

    public String getPassword(){
        return password;
    }

    public void setRole(int role){
        this.role = role;
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

    public static void userLogin() throws Exception{
        String username = MainPage.userInput.getText();
        int index = -1;
        for (int i = 0; i < User.userList.size(); i ++) {
            if (User.userList.get(i).getName().equals(username)) {
                index = i;
                break;
            }
        }
        String password = MainPage.passwordInput.getText();
        if(password.equals(User.userList.get(index).getPassword())){
            MainPage.container.setVisible(false);
            PageAdmin.container.setVisible(true);
        } else {
            throw new Exception();
        }
    }
}

class Admin extends User {
    public Admin(String name, String password){
        super(0, name, password);
    }

    private static final String FILE_PATH = "user.txt";
    public static void registerUser(){
        try{
            int role;
            String name, password;

            // Assign role based on Radio Button
            if(PageAdmin_Register.adminRadio.isSelected()){
                role = 0;
            } else if(PageAdmin_Register.technicianRadio.isSelected()){
                role = 1;
            } else if(PageAdmin_Register.customerRadio.isSelected()){
                role = 2;
            } else{
                throw new Exception();
            }

            // Read Username from Register Page
            name = PageAdmin_Register.userInput.getText();

            // Read password from Register Page
            password = PageAdmin_Register.passwordInput.getText();
            
            BufferedWriter write = new BufferedWriter(new FileWriter(FILE_PATH, true));

            write.write(role+","+name+","+password);
            write.newLine();

            write.close();
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }
}

class Technician extends User {
    public Technician(String name, String password){
        super(1, name, password);
    }
}

class Customer extends User {
    public Customer(String name, String password){
        super(2, name, password);
    }
}