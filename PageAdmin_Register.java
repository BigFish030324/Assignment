import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PageAdmin_Register implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == ok){
                int password = 1234;//Need backend to change the method for registering new user
                String input1 = userInput.getText();
                int input2 = Integer.parseInt(passwordInput.getText());
                if(input1.equals("Admin") && input2 == password){
                    container.setVisible(false);
                    RegisterSuccess.container.setVisible(true);
                    // PageAdmin.container.setVisible(true);
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
    JButton ok;
    JTextField userInput, passwordInput;
    JLabel registerText, userText, passwordText;
    JRadioButton userRadio, technicianRadio, managerRadio;

    public PageAdmin_Register(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700,400);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        registerText = new JLabel("Registration");//register word
        registerText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        registerText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds(((container.getWidth() - 350)/2)+5, 125, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userInput = new JTextField();//Type username here
        userInput.setBounds((container.getWidth() - 350)/2, 155, 350, 30);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds(((container.getWidth() - 350)/2)+5, 195, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds((container.getWidth() - 350)/2, 225, 350, 30);

        JRadioButton userRadio = new JRadioButton();

        JRadioButton technicianRadio = new JRadioButton();

        JRadioButton managerRadio = new JRadioButton();

        ok = new JButton("OK");//OK Button
        ok.setBounds(container.getWidth()-150, 300, 100, 30);
        ok.addActionListener(this);

        container.add(ok);
        container.add(registerText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.setVisible(true);
    }
}
