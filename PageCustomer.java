import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageCustomer implements ActionListener {

    static PageCustomer_Appointment customerAppointment;
    static PageCustomer_Feedback customerFeedback;
    static PageCustomer_History customerPayment;

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
            } else if(e.getSource() == payment){
                container.setVisible(false);
                customerPayment = new PageCustomer_History();
                PageCustomer_History.container.setVisible(true);
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
    JButton appointment, feedback, payment;
    JLabel customerText;

    public PageCustomer(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,500); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Able to close system
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                MainPage.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Text Section
        // Customer Text
        customerText = new JLabel("Customer");
        customerText.setBounds((container.getWidth() - 170)/2, 100, 170, 50);
        customerText.setFont(new Font("Times New Roman", Font.BOLD, 36));

        // Button Section
        // Appointment Button
        appointment = new JButton("Appointment");
        appointment.setBounds((container.getWidth() - 500)/2, 170, 500, 50);
        appointment.addActionListener(this);

        // Feedback Button
        feedback = new JButton("Feedback");
        feedback.setBounds((container.getWidth() - 500)/2, 250, 500, 50);
        feedback.addActionListener(this);

        // Payment Button
        payment = new JButton("Payment");
        payment.setBounds((container.getWidth() - 500)/2, 330, 500, 50);
        payment.addActionListener(this);





        // Add Section
        container.add(appointment);
        container.add(feedback);
        container.add(payment);
        container.add(customerText);
        container.add(icon);
        container.setVisible(true);
    }
}
