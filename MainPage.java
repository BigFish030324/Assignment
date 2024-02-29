import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainPage implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == enter){
                int password = 1234;
                String input1 = userInput.getText();
                int input2 = Integer.parseInt(passwordInput.getText());
                if(input1.equals("Admin") && input2 == password){
                    container.setVisible(false);
                    PageAdmin.container.setVisible(true);
                } else {
                    throw new Exception();
                }
            }
        } catch(Exception f){
                JOptionPane.showMessageDialog(container, "Invalid Input!");
        }
    }

    JFrame container;
    JButton enter;
    JTextField userInput, passwordInput;
    JLabel userText, passwordText;

    public MainPage(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,600);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        ImageIcon logo = new ImageIcon("APU_LOGO.jpg");//Image of APU Logo
        container.setIconImage(logo.getImage());

        ImageIcon image1 = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\APU\\Sem 5\\JP\\VS Code\\Assignment\\Images\\APU_LOGO.jpg");
        JLabel imagePlaceholder = new JLabel();
        imagePlaceholder.setIcon(image1);
        imagePlaceholder.setBounds((container.getWidth() - 250)/2, 50, 250, 235);

        

        userText = new JLabel("Username");//Username word
        userText.setBounds(((container.getWidth() - 350)/2)+5, 295, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        userInput = new JTextField();//Type username here
        userInput.setBounds((container.getWidth() - 350)/2, 320, 350, 30);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds(((container.getWidth() - 350)/2)+5, 355, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds((container.getWidth() - 350)/2, 380, 350, 30);

        enter = new JButton("Enter");//Enter Button
        enter.setBounds((container.getWidth() - 250)/2, 430, 250, 60);
        enter.addActionListener(this);

        container.add(enter);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(imagePlaceholder);
        container.setVisible(true);
    }
}
