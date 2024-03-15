import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageAdmin implements ActionListener {
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == register){
                container.setVisible(false);
                PageAdmin_Register.container.setVisible(true);
            } 
            else if(e.getSource() == edit){
                container.setVisible(false);
                PageAdmin_Edit.container.setVisible(true);
            } else if(e.getSource() == appointment){
                container.setVisible(false);
                PageAdmin_Appointment.container.setVisible(true);
            } else if(e.getSource() == feedback){
                container.setVisible(false);
                PageAdmin_Feedback.container.setVisible(true);
            } else if(e.getSource() == payment){
                container.setVisible(false);
                PageAdmin_Payment.container.setVisible(true);
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
    JButton register, edit, appointment, feedback, payment;
    JLabel adminText;

    public PageAdmin(){

        // Background Section
        // Frame of this Page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,600);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
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

        // Admin Word
        adminText = new JLabel("Admin");
        adminText.setBounds((container.getWidth() - 110)/2, 100, 110, 50);
        adminText.setFont(new Font("Times New Roman", Font.BOLD, 36));

        // Buttons
        // Register Button
        register = new JButton("Register");
        register.setBounds((container.getWidth() - 500)/2, 170, 500, 50);
        register.addActionListener(this);

        // Edit Button
        edit = new JButton("Edit");
        edit.setBounds((container.getWidth() - 500)/2, 240, 500, 50);
        edit.addActionListener(this);

        // Appointment Button
        appointment = new JButton("Appointment");
        appointment.setBounds((container.getWidth() - 500)/2, 310, 500, 50);
        appointment.addActionListener(this);

        // Feedback Button
        feedback = new JButton("Feedback");
        feedback.setBounds((container.getWidth() - 500)/2, 380, 500, 50);
        feedback.addActionListener(this);

        // Payment Button
        payment = new JButton("Payment");
        payment.setBounds((container.getWidth() - 500)/2, 450, 500, 50);
        payment.addActionListener(this);





        // Add Section
        container.add(register);
        container.add(edit);
        container.add(appointment);
        container.add(feedback);
        container.add(payment);
        container.add(adminText);
        container.add(icon);
        container.setVisible(true);
    }
}
