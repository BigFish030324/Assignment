import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PageAdmin_Register implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            if((userInput.getText().isEmpty() || passwordInput.getText().isEmpty() || registerGroup.getSelection() == null) && e.getSource() == ok){
                throw new Exception();
            }
            else{
                
                Admin.registerUser();
                container.setVisible(false);
                PageAdmin.container.setVisible(true);
                RegisterSuccess.container.setVisible(true);
            }
        } 
        catch(Exception f){
            JOptionPane.showMessageDialog(container, "Invalid Input!");
        }
    }
    
    static JFrame container;
    JButton ok;
    static JTextField userInput;
    static JTextField passwordInput;
    JLabel registerText, userText, passwordText;
    static JRadioButton customerRadio, technicianRadio, adminRadio;
    ButtonGroup registerGroup = new ButtonGroup();//To limit 1 role 1 time

    public PageAdmin_Register(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700,400);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        // ImageIcon image2 = new ImageIcon("..\\Assignment\\Images\\Back_Icon.png");
        // Image setSize2 = image2.getImage();
        // setSize2 = setSize2.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        // image2 = new ImageIcon(setSize2);
        // JLabel ImageHostel = new JLabel();//Code for Back Icon
        // ImageHostel.setIcon(image2);
        // ImageHostel.setBounds(0, 0, container.getWidth(), container.getHeight());

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

        adminRadio = new JRadioButton("Admin");//Choose button for manager (if not needed, can delete)
        adminRadio.setBounds((container.getWidth()/2)+90, 260, 90, 30);

        technicianRadio = new JRadioButton("Technician");//Choose button for technician
        technicianRadio.setBounds((container.getWidth()/2)-50, 260, 90, 30);

        customerRadio = new JRadioButton("Customer");//Choose button for user
        customerRadio.setBounds((container.getWidth()/2)-170, 260, 90, 30);

        ok = new JButton("OK");//OK Button
        ok.setBounds(container.getWidth()-150, 300, 100, 30);
        ok.addActionListener(this);

        registerGroup.add(customerRadio);
        registerGroup.add(technicianRadio);
        registerGroup.add(adminRadio);

        container.add(ok);
        container.add(registerText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(customerRadio);
        container.add(technicianRadio);
        container.add(adminRadio);
        container.setVisible(true);
    }
}
