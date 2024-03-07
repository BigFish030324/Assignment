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
            // } else if(e.getSource() == payment){
            //     container.setVisible(false);
            //     PageAdmin_Payment adminPayment = new PageAdmin_Payment();
            //     PageAdmin_Payment.container.setVisible(true);
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
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,600);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        JLabel icon = new backIcon();// Go back icon

        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                MainPage.container.setVisible(true);
                container.setVisible(false);
            }
        });

        register = new JButton("Register");//Username word
        register.setBounds((container.getWidth() - 500)/2, 170, 500, 50);
        register.addActionListener(this);

        edit = new JButton("Edit");//Password word
        edit.setBounds((container.getWidth() - 500)/2, 240, 500, 50);
        edit.addActionListener(this);

        appointment = new JButton("Appointment");//Enter Button
        appointment.setBounds((container.getWidth() - 500)/2, 310, 500, 50);
        appointment.addActionListener(this);

        feedback = new JButton("Feedback");//Enter Button
        feedback.setBounds((container.getWidth() - 500)/2, 380, 500, 50);
        feedback.addActionListener(this);

        payment = new JButton("Payment");//Enter Button
        payment.setBounds((container.getWidth() - 500)/2, 450, 500, 50);
        payment.addActionListener(this);

        adminText = new JLabel("Admin");//Admin text 
        adminText.setBounds((container.getWidth() - 110)/2, 100, 110, 50);
        adminText.setFont(new Font("Times New Roman", Font.BOLD, 36));
        
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
