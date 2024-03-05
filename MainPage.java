import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
    static JTextField userInput;
    static JPasswordField passwordInput;
    JLabel userText, passwordText, aboutUs1Text, aboutUs2Text;
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

        ImageIcon image1 = new ImageIcon("..\\Assignment\\Images\\APU_LOGO.jpg");
        Image setSize1 = image1.getImage();//Code for APU Logo
        setSize1 = setSize1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(setSize1);
        JLabel ImageAPU = new JLabel();
        ImageAPU.setIcon(image1);
        ImageAPU.setBounds(60, 45, 80, 80);

        ImageIcon image2 = new ImageIcon("..\\Assignment\\Images\\Hostel_LOGO.jpeg");
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
        userInput.setBounds((container.getWidth() - 350)/2, 210, 350, 40);

        passwordText = new JLabel("Password");//Password word
        passwordText.setBounds(((container.getWidth() - 350)/2)+5, 260, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        passwordInput = new JPasswordField();//Type password here
        passwordInput.setBounds((container.getWidth() - 350)/2, 290, 350, 40);
        passwordInput.addActionListener(this);

        // Code for Show Checkbox
        ImageIcon image3 = new ImageIcon("..\\Assignment\\Images\\Show.png");
        Image setSize3 = image3.getImage();
        setSize3 = setSize3.getScaledInstance(40, 25, Image.SCALE_SMOOTH);
        image3 = new ImageIcon(setSize3);
        JLabel ImageShow = new JLabel();
        ImageShow.setIcon(image3);
        // ImageShow.setBounds(60, 45, 30, 30);

        // Code for Don't Show Checkbox
        ImageIcon image4 = new ImageIcon("..\\Assignment\\Images\\Dont_Show.png");
        Image setSize4 = image4.getImage();
        setSize4 = setSize4.getScaledInstance(40, 25, Image.SCALE_SMOOTH);
        image4 = new ImageIcon(setSize4);
        JLabel ImageDontShow = new JLabel();
        ImageDontShow.setIcon(image4); // Fixed the variable name here
        // ImageDontShow.setBounds(60, 45, 30, 30);

        JCheckBox showPassword = new JCheckBox(); // Added text to the checkbox
        showPassword.setFocusCycleRoot(false);
        showPassword.setOpaque(false);
        showPassword.setBounds(((container.getWidth() - 350)/2)+300, 300, 40, 25);
        showPassword.setIcon(image4);
        showPassword.setSelectedIcon(image3);

        User.readData();

        enter = new JButton("Enter");//Enter Button
        enter.setBounds((container.getWidth() - 350)/2, 350, 350, 50);
        enter.addActionListener(this);

        aboutUs1Text = new JLabel("Click here for more detail in ");
        aboutUs1Text.setBounds(container.getWidth()/2-110, 405, 250, 30);
        aboutUs1Text.setFont(new Font("Times New Roman", Font.BOLD, 12));

        aboutUs2Text = new JLabel("<html><u><font color='blue'>About Us!</font></u></html>");
        aboutUs2Text.setBounds(((container.getWidth() - 350)/2)+222, 408, 80, 20);
        aboutUs2Text.setFont(new Font("Times New Roman", Font.BOLD, 14));

        aboutUs2Text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        aboutUs2Text.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                AboutUs.container.setVisible(true);
                container.setVisible(false);
            }

            public void mouseEntered(MouseEvent e) {
                container.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        
            public void mouseExited(MouseEvent e) {
                container.setCursor(Cursor.getDefaultCursor());
            }
        });

        container.add(enter);
        container.add(showPassword);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(aboutUs1Text);
        container.add(aboutUs2Text);
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