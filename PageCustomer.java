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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PageCustomer implements ActionListener {

    static PageCustomer_Appointment customerAppointment;
    static PageCustomer_Feedback customerFeedback;

    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == appointment){
                container.setVisible(false);
                customerAppointment = new PageCustomer_Appointment();
                PageCustomer_Appointment.container.setVisible(true);
            } else if(e.getSource() == feedback){
                container.setVisible(false);
                customerFeedback = new PageCustomer_Feedback();
                PageCustomer_Feedback.container.setVisible(true);
            } else{
                throw new Exception();
            }
        }
        catch(Exception f){
            // JOptionPane.showMessageDialog(enter, "Invalid Input! ");
        }
    }



    static JFrame container;
    JButton appointment, feedback, history;
    JLabel customerText;
    JPanel backgroundBox;

    public PageCustomer(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(750,400); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Able to close system
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                MainPage.userInput.setText("");
                MainPage.passwordInput.setText("");
                MainPage.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // The background box behind login input
        backgroundBox = new box();
        backgroundBox.setBounds((container.getWidth()-450)/2, (container.getHeight()-340)/2, 450, 300);
        backgroundBox.setBackground(new Color(255,255,255,0));

        // The background of a hotel use for container
        ImageIcon image = new ImageIcon("..\\Assignment\\Images\\Wooden_Background.jpg");
        Image setSize = image.getImage();
        setSize = setSize.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(setSize);
        JLabel ImageCustomer = new JLabel();
        ImageCustomer.setIcon(image);
        ImageCustomer.setBounds(0, 0, container.getWidth(), container.getHeight());

        // Text Section
        // Customer Text
        customerText = new JLabel("Welcome, " + MainPage.userInput.getText() + "!");
        customerText.setBounds((container.getWidth() - 260)/2, 75, 260, 50);
        customerText.setFont(new Font("Times New Roman", Font.BOLD, 26));

        // Button Section
        // Appointment Button
        appointment = new JButton("Appointment");
        appointment.setBounds((container.getWidth() - 400)/2, 160, 400, 60);
        appointment.addActionListener(this);

        // Feedback Button
        feedback = new JButton("Feedback");
        feedback.setBounds((container.getWidth() - 400)/2, 240, 400, 60);
        feedback.addActionListener(this);

        // Add Section
        container.add(appointment);
        container.add(feedback);
        container.add(customerText);
        container.add(icon);
        container.add(backgroundBox);
        container.add(ImageCustomer);
        container.setVisible(true);
    }
}

// Code for the Box 2D Graphic
class box extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(247, 222, 208, 230));
        g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 50, 40);
    }
}