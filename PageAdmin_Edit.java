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
    JButton check, edit, apply, dlt;
    JTextField userInput, passwordInput, newUserInput, newPasswordInput;
    JLabel editText, userText, passwordText, newEditText, newUserText, newPasswordText;
    JRadioButton userRadio, technicianRadio, managerRadio, newUserRadio, newTechnicianRadio, newManagerRadio;

    public PageAdmin_Edit(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(550,510);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

// Register, username, password and buttons

        JLabel icon = new backIcon();//Go back icon

        editText = new JLabel("Edit Profile");//register word
        editText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        editText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds((container.getWidth()/10)+5, 125, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userInput = new JTextField();//Type username here
        userInput.setBounds(container.getWidth()/10, 155, 350, 30);

        check = new JButton("Check");//Check Button
        check.setBounds(container.getWidth()-140, 155, 100, 30);
        check.addActionListener(this);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds((container.getWidth()/10)+5, 195, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds(container.getWidth()/10, 225, 350, 30);

        edit = new JButton("Edit");//Edit Button
        edit.setBounds(container.getWidth()-140, 225, 100, 30);
        edit.addActionListener(this);

        userRadio = new JRadioButton("User");//Choose button for user
        userRadio.setBounds(container.getWidth()/10, 270, 80, 30);

        technicianRadio = new JRadioButton("Technician");//Choose button for techiician
        technicianRadio.setBounds(container.getWidth()/10, 300, 90, 30);

        managerRadio = new JRadioButton("Manager");//Choose button for manager (if not needed, can delete)
        managerRadio.setBounds(container.getWidth()/10, 330, 80, 30);

        ButtonGroup registerGroup = new ButtonGroup();//To limit 1 role 1 time
        registerGroup.add(userRadio);
        registerGroup.add(technicianRadio);
        registerGroup.add(managerRadio);

        apply = new JButton("Apply");//Apply Button
        apply.setBounds(container.getWidth()-160, container.getHeight()-90, 120, 30);
        apply.addActionListener(this);

        dlt = new JButton("Delete");//Delete Button
        dlt.setBounds(container.getWidth()-160, container.getHeight()-130, 120, 30);
        dlt.addActionListener(this);

        // Part of adding apply and delete into GUI
        container.add(apply);
        container.add(dlt);

        // Part of adding to GUI:
        container.add(editText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(check);
        container.add(edit);
        container.add(userRadio);
        container.add(technicianRadio);
        container.add(icon);
        container.add(managerRadio);
    }
}
