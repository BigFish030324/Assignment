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
            if(e.getSource() == ok){
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
    JButton ok, dlt;
    JTextField userInput, passwordInput, newUserInput, newPasswordInput;
    JLabel editText, userText, passwordText, newEditText, newUserText, newPasswordText;
    JRadioButton userRadio, technicianRadio, managerRadio, newUserRadio, newTechnicianRadio, newManagerRadio;
    drawline line;

    public PageAdmin_Edit(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(800,400);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

// This is the origin username and password which is before changing or deleting

        editText = new JLabel("Edit Profile");//register word
        editText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        editText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds(30, 125, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userInput = new JTextField();//Type username here
        userInput.setBounds(25, 155, 300, 30);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds(30, 195, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds(25, 225, 300, 30);

        userRadio = new JRadioButton("User");//Choose button for user
        userRadio.setBounds(30, 260, 80, 30);

        technicianRadio = new JRadioButton("Technician");//Choose button for techiician
        technicianRadio.setBounds(115, 260, 90, 30);

        managerRadio = new JRadioButton("Manager");//Choose button for manager (if not needed, can delete)
        managerRadio.setBounds(230, 260, 80, 30);

        ButtonGroup registerGroup = new ButtonGroup();//To limit 1 role 1 time
        registerGroup.add(userRadio);
        registerGroup.add(technicianRadio);
        registerGroup.add(managerRadio);

        ok = new JButton("OK");//OK Button
        ok.setBounds(container.getWidth()-160, container.getHeight()-90, 120, 30);
        ok.addActionListener(this);

        dlt = new JButton("Delete User");//OK Button
        dlt.setBounds(container.getWidth()-300, container.getHeight()-90, 120, 30);
        dlt.addActionListener(this);

        line = new drawline();
        line.setBounds(-20, 130, 800, 170);

// This is the part of new username and password will be type in

        newUserText = new JLabel("Username");//Username word
        newUserText.setBounds(430, 125, 350, 30);
        newUserText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        newUserInput = new JTextField();//Type username here
        newUserInput.setBounds(425, 155, 300, 30);

        newPasswordText = new JLabel("Password");//Password word
        newPasswordText.setBounds(430, 195, 350, 30);
        newPasswordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        newPasswordInput = new JTextField();//Type password here
        newPasswordInput.setBounds(425, 225, 300, 30);

        newUserRadio = new JRadioButton("User");//Choose button for user
        newUserRadio.setBounds(430, 260, 80, 30);

        newTechnicianRadio = new JRadioButton("Technician");//Choose button for techiician
        newTechnicianRadio.setBounds(515, 260, 90, 30);

        newManagerRadio = new JRadioButton("Manager");//Choose button for manager (if not needed, can delete)
        newManagerRadio.setBounds(630, 260, 80, 30);
        
        container.add(ok);
        container.add(dlt);
        container.add(line);

        // Part of origin username and password:
        container.add(editText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(userRadio);
        container.add(technicianRadio);
        container.add(managerRadio);
        
        // Part of new username and password:
        container.add(newUserText);
        container.add(newPasswordText);
        container.add(newUserInput);
        container.add(newPasswordInput);
        container.add(newUserRadio);
        container.add(newTechnicianRadio);
        container.add(newManagerRadio);
        container.setVisible(true);
    }
}
