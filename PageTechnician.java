import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageTechnician implements ActionListener {
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == appointment){
                container.setVisible(false);
                PageTechnician_Appointment.container.setVisible(true);
            } else if(e.getSource() == feedback){
                container.setVisible(false);
                PageTechnician_Feedback.container.setVisible(true);
            } else if(e.getSource() == payment){
                container.setVisible(false);
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
    JButton appointment, feedback, payment;
    JLabel technicianText;
    public PageTechnician(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,500);//GUI Size
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

        appointment = new JButton("Appointment");//Enter Button
        appointment.setBounds((container.getWidth() - 500)/2, 170, 500, 50);
        appointment.addActionListener(this);

        feedback = new JButton("Feedback");//Enter Button
        feedback.setBounds((container.getWidth() - 500)/2, 250, 500, 50);
        feedback.addActionListener(this);

        payment = new JButton("Payment");//Enter Button
        payment.setBounds((container.getWidth() - 500)/2, 330, 500, 50);
        payment.addActionListener(this);

        technicianText = new JLabel("Technician");//Technician text 
        technicianText.setBounds((container.getWidth() - 170)/2, 100, 170, 50);
        technicianText.setFont(new Font("Times New Roman", Font.BOLD, 36));



        container.add(appointment);
        container.add(feedback);
        container.add(payment);
        container.add(technicianText);
        container.add(icon);
        container.setVisible(true);
    }
}
