import java.util.ArrayList;
import java.util.Scanner;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    public void setRole(int role){
        this.role = role;
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
            PageAdmin.container.setVisible(true);
        } else {
            throw new Exception();
        }
    }
}

class Manager extends User {
    public Manager(String name, String password){
        super(0, name, password);
    }

    public static void writeData() throws IOException {
        try(BufferedWriter write = new BufferedWriter(new FileWriter(FILE_PATH, false))){
            for (int i = 0; i < User.userList.size(); i ++) {
            write.write(User.userList.get(i).getRole()+","+User.userList.get(i).getName()+","+User.userList.get(i).getPass());
            write.newLine();
        }
            write.flush();
            write.close();
        }
    }

    private static final String FILE_PATH = "user.txt";
    public static void registerUser(){
        try{
            int role;
            String name;
            char[] password;

            // Assign role based on Radio Button
            if(PageAdmin_Register.managerRadio.isSelected()){
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
            password = PageAdmin_Register.passwordInput.getPassword();
            String enteredPassword = new String(password);
            
            BufferedWriter write = new BufferedWriter(new FileWriter(FILE_PATH, true));

            write.write(role+","+name+","+enteredPassword);
            write.newLine();

            write.close();
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    public static void modifyUser(ActionEvent e) throws IOException {
        String username = PageAdmin_Edit.userInput.getText();
        int index = -1;
        if(e.getSource()==PageAdmin_Edit.apply){
            for(int i=0; i < User.userList.size(); i++){
                if(User.userList.get(i).getName().equals(username)){
                    index = i;
                }
            }
            setPass(index, PageAdmin_Edit.passwordInput.getText());
            writeData();
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