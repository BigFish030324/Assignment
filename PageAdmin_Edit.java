import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PageAdmin_Edit implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == apply){
                int password = 1234;//Need backend to change the method for registering new user
                String input1 = userInput.getText();
                int input2 = Integer.parseInt(passwordInput.getText());
                if(input1.equals("Admin") && input2 == password){//Remember to add .getsource for user role and able to edit new userrname/password
                    container.setVisible(false);
                    PageAdmin_Edit.container.setVisible(true);
                    EditConfirmation.container.setVisible(true);
                } else {
                    throw new Exception();
                }
            }
        } 
        catch(Exception f){
                JOptionPane.showMessageDialog(container, "Invalid Input!");
        }
    }

    static JFrame container;
    JButton apply, check, editPassword, dlt;
    JTextField userInput, passwordInput, newUserInput, newPasswordInput;
    JLabel editText, userText, passwordText, newEditText, newUserText, newPasswordText;
    JRadioButton userRadio, technicianRadio, managerRadio, newUserRadio, newTechnicianRadio, newManagerRadio;

    public PageAdmin_Edit(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(600,500);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

// This is the origin username and password which is before changing or deleting

        editText = new JLabel("Edit Profile");//register word
        editText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        editText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds((container.getWidth()+50)/10, 125, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userInput = new JTextField();//Type username here
        userInput.setBounds(container.getWidth()/10, 155, 400, 30);

        check = new JButton("Check");//Check Button
        check.setBounds(container.getWidth()-130, 155, 95, 30);
        check.addActionListener(this);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds((container.getWidth()+50)/10, 195, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds(container.getWidth()/10, 225, 400, 30);

        editPassword = new JButton("Edit");//Edit Password Button
        editPassword.setBounds(container.getWidth()-130, 225, 95, 30);
        editPassword.addActionListener(this);

        userRadio = new JRadioButton("User");//Choose button for user
        userRadio.setBounds(container.getWidth()/10, 270, 80, 30);

        technicianRadio = new JRadioButton("Technician");//Choose button for techiician
        technicianRadio.setBounds(container.getWidth()/10, 300, 100, 30);

        managerRadio = new JRadioButton("Manager");//Choose button for manager (if not needed, can delete)
        managerRadio.setBounds(container.getWidth()/10, 330, 80, 30);

        ButtonGroup registerGroup = new ButtonGroup();//To limit 1 role 1 time
        registerGroup.add(userRadio);
        registerGroup.add(technicianRadio);
        registerGroup.add(managerRadio);

        apply = new JButton("Apply");//Apply Button
        apply.setBounds(container.getWidth()-160, container.getHeight()-90, 120, 30);
        apply.addActionListener(this);

        dlt = new JButton("Delete User");//Delete Button
        dlt.setBounds(container.getWidth()-160, container.getHeight()-140, 120, 30);
        dlt.addActionListener(this);
        
        container.add(apply);
        container.add(dlt);

        // Part of origin username and password:
        container.add(editText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(check);
        container.add(editPassword);
        container.add(userRadio);
        container.add(technicianRadio);
        container.add(managerRadio);
    }
}