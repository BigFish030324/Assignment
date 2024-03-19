import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageTechnician implements ActionListener {

    static PageTechnician_Appointment_TABLE technicianAppointment;
    static PageTechnician_Feedback technicianFeedback;
    static PageTechnician_History technicianHistory;
    static PageTechnician_Payment technicianPayment;

    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == appointment){
                container.setVisible(false);
                technicianAppointment = new PageTechnician_Appointment_TABLE();
                PageTechnician_Appointment_TABLE.container.setVisible(true);
            } else if(e.getSource() == feedback){
                container.setVisible(false);
                technicianFeedback = new PageTechnician_Feedback();
                PageTechnician_Feedback.container.setVisible(true);
            } else if(e.getSource() == history){
                container.setVisible(false);
                technicianHistory = new PageTechnician_History();
                PageTechnician_History.container.setVisible(true);
            } else if(e.getSource() == payment){
                container.setVisible(false);
                technicianPayment = new PageTechnician_Payment();
                PageTechnician_Payment.container.setVisible(true);
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception f){
            // JOptionPane.showMessageDialog(enter, "Invalid Input! ");
        }
    }



    static JFrame container;
    JButton appointment, feedback, history, payment;
    JLabel technicianText;
    public PageTechnician(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,550); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Able to exit system
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

        // The background of a hotel use for container
        ImageIcon image = new ImageIcon("..\\Assignment\\Images\\Wooden_Background.jpg");
        Image setSize = image.getImage();
        setSize = setSize.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(setSize);
        JLabel ImageTechnician = new JLabel();
        ImageTechnician.setIcon(image);
        ImageTechnician.setBounds(0, 0, container.getWidth(), container.getHeight());

        // Text Section
        // Technician Text
        technicianText = new JLabel("Technician");
        technicianText.setBounds((container.getWidth() - 170)/2, 100, 170, 50);
        technicianText.setFont(new Font("Times New Roman", Font.BOLD, 36));

        // Button Section
        // Appointment Button
        appointment = new JButton("Appointment");
        appointment.setBounds((container.getWidth() - 500)/2, 170, 500, 50);
        appointment.addActionListener(this);

        // Feedback Section
        feedback = new JButton("Feedback");
        feedback.setBounds((container.getWidth() - 500)/2, 250, 500, 50);
        feedback.addActionListener(this);

        // History Section
        history = new JButton("History");
        history.setBounds((container.getWidth() - 500)/2, 330, 500, 50);
        history.addActionListener(this);

        // Payment Section
        payment = new JButton("Payment");
        payment.setBounds((container.getWidth() - 500)/2, 410, 500, 50);
        payment.addActionListener(this);





        // Add Section
        container.add(appointment);
        container.add(feedback);
        container.add(history);
        container.add(payment);
        container.add(technicianText);
        container.add(icon);
        container.add(ImageTechnician);
        container.setVisible(true);
    }
}
