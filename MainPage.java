import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPage implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == enter){
                User.userLogin();
            }
        } catch(Exception f){
                JOptionPane.showMessageDialog(container, "Invalid Input!");
        }
    }

    static JFrame container;
    JButton enter;
    static JTextField userInput, passwordInput;
    JLabel userText, passwordText;
    JPanel backgroundBox, APUCircle;

    public MainPage(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,600);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        backgroundBox = new box();// The background box behind login input
        backgroundBox.setBounds((container.getWidth()-450)/2, (container.getHeight()-300)/2, 450, 300);
        backgroundBox.setBackground(new Color(255,255,255,0));

        APUCircle = new circle();
        APUCircle.setBounds(40, 25, 120, 120);
        APUCircle.setBackground(new Color(255, 255, 255, 0));

        // ImageIcon image1 = new ImageIcon("E:\\User\\Documents\\GitHub\\Assignment\\Images\\APU_LOGO.jpg");
        ImageIcon image1 = new ImageIcon("C:\\Users\\Lenovo\\Documents\\GitHub\\Assignment\\Images\\APU_LOGO.jpg");
        Image setSize1 = image1.getImage();//Code for APU Logo
        setSize1 = setSize1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(setSize1);
        JLabel ImageAPU = new JLabel();
        ImageAPU.setIcon(image1);
        ImageAPU.setBounds(60, 45, 80, 80);

        ImageIcon image2 = new ImageIcon("C:\\Users\\Lenovo\\Documents\\GitHub\\Assignment\\Images\\Hostel_LOGO.jpeg");
        Image setSize2 = image2.getImage();
        setSize2 = setSize2.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(setSize2);
        JLabel ImageHostel = new JLabel();//Code for Hostel Logo
        ImageHostel.setIcon(image2);
        ImageHostel.setBounds(0, 0, container.getWidth(), container.getHeight());

        userText = new JLabel("Username");//Username word
        userText.setBounds(((container.getWidth() - 350)/2)+5, 180, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        userInput = new JTextField();//Type username here
        userInput.setBounds((container.getWidth() - 350)/2, 210, 350, 30);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds(((container.getWidth() - 350)/2)+5, 250, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        passwordInput = new JTextField();//Type password here
        passwordInput.setBounds((container.getWidth() - 350)/2, 280, 350, 30);
        passwordInput.addActionListener(this);

        User.readData();

        enter = new JButton("Enter");//Enter Button
        enter.setBounds((container.getWidth() - 250)/2, 350, 250, 60);
        enter.addActionListener(this);

        
        container.add(enter);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(ImageAPU);
        container.add(APUCircle);
        container.add(backgroundBox);
        container.add(ImageHostel);
        container.setVisible(true);
    }
}

class box extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(247, 222, 208, 230));
        g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 50, 50);
    }
}

class circle extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillOval(0, 0, getWidth(), getHeight());
    }
}