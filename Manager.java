import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Manager extends User{
    public Manager(String name, String password){
        super(0, name, password);
    }

    public static void writeData() throws IOException {
        try(BufferedWriter write = new BufferedWriter(new FileWriter(FILE_PATH, false))){
            for (User user : User.userList) {
            write.write(user.getRole() + "," + user.getName() + "," + user.getPass());
            write.newLine();
            } 
        } catch (IOException e){
            e.printStackTrace();
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
    public static void deleteUser(){
        String username = PageAdmin_Edit.userInput.getText();
        for (int i = 0; i < User.userList.size(); i ++) {
            if (User.userList.get(i).getName().equals(username)) {
                User.userList.remove(i);
                try {
                    writeData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
