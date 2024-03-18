import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageAdmin_Register implements ActionListener{

    static RegisterSuccess registerSuccess;
    @SuppressWarnings("deprecation")
    
    public void actionPerformed(ActionEvent e){
        try{
            if((userInput.getText().isEmpty() || passwordInput.getText().isEmpty() || registerGroup.getSelection() == null) && e.getSource() == ok){
                throw new Exception();
            }
            else{
                
                Manager.registerUser();
                container.setVisible(false);
                registerSuccess = new RegisterSuccess();
                PageAdmin.container.setVisible(true);
                RegisterSuccess.container.setVisible(true);
            }
        } 
        catch(Exception f){
            JOptionPane.showMessageDialog(container, "Invalid Input!");
        }
    }



    static JFrame container;
    static JTextField userInput;
    static JPasswordField passwordInput;
    static JRadioButton customerRadio, technicianRadio, managerRadio;
    JLabel registerText, userText, passwordText;
    JButton ok;
    ButtonGroup registerGroup = new ButtonGroup();

    public PageAdmin_Register(){

        // Background Section
        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700,400); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set to able exit system
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageAdmin.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Text Section
        // Registration text
        registerText = new JLabel("Registration");
        registerText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        registerText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username text
        userText = new JLabel("Username");
        userText.setBounds(((container.getWidth() - 350)/2)+5, 125, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Password text
        passwordText = new JLabel("Password");
        passwordText.setBounds(((container.getWidth() - 350)/2)+5, 195, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Input Section
        // User Input
        userInput = new JTextField();
        userInput.setBounds((container.getWidth() - 350)/2, 155, 350, 30);

        // Password Input
        passwordInput = new JPasswordField();
        passwordInput.setBounds((container.getWidth() - 350)/2, 225, 350, 30);

        // Buttons
        // Radio Buttons
        // Manager Radiobutton
        managerRadio = new JRadioButton("Manager");
        managerRadio.setBounds((container.getWidth()/2)+90, 260, 90, 30);

        // Technician Radiobutton
        technicianRadio = new JRadioButton("Technician");
        technicianRadio.setBounds((container.getWidth()/2)-50, 260, 90, 30);

        // Customer Radiobutton
        customerRadio = new JRadioButton("Customer");
        customerRadio.setBounds((container.getWidth()/2)-170, 260, 90, 30);

        // Radiobutton Group
        registerGroup.add(customerRadio);
        registerGroup.add(technicianRadio);
        registerGroup.add(managerRadio);

        // OK Button
        ok = new JButton("OK");
        ok.setBounds(container.getWidth()-150, 300, 100, 30);
        ok.addActionListener(this);





        // Add Section
        container.add(ok);
        container.add(registerText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(customerRadio);
        container.add(technicianRadio);
        container.add(managerRadio);
        container.add(icon);
        container.setVisible(true);
    }
}
