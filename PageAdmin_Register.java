import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PageAdmin_Register implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            // backend part
        } catch(Exception f){
                JOptionPane.showMessageDialog(container, "Invalid Input!");
        }
    }
    
    static JFrame container;
    JButton ok;
    JTextField userInput, passwordInput;
    JLabel registerText, userText, passwordText;

    public PageAdmin_Register(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700,400);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        registerText = new JLabel("Registration");//register word
        registerText.setBounds((container.getWidth() - 140)/2, 60, 140, 50);
        registerText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds(((container.getWidth() - 350)/2)+5, 135, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userInput = new JTextField();//Type username here
        userInput.setBounds((container.getWidth() - 350)/2, 165, 350, 30);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds(((container.getWidth() - 350)/2)+5, 205, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds((container.getWidth() - 350)/2, 235, 350, 30);

        // ImageIcon image1 = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\APU\\Sem 5\\JP\\VS Code\\Assignment\\Images\\APU_LOGO.jpg");//Location of the image, remember to change location if not the same
        // JLabel imagePlaceholder = new JLabel();
        // imagePlaceholder.setIcon(image1);
        // imagePlaceholder.setBounds((container.getWidth() - 250)/2, 50, 250, 235);

        ok = new JButton("OK");//OK Button
        ok.setBounds(container.getWidth()-150, 300, 100, 30);
        ok.addActionListener(this);

        container.add(ok);
        container.add(registerText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        // container.add(imagePlaceholder);
        container.setVisible(true);
    }
}
