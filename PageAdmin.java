import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageAdmin implements ActionListener {

    static PageAdmin_Register adminRegister;
    static PageAdmin_Edit adminEdit;
    static PageAdmin_Appointment_TABLE adminAppointment;
    static PageAdmin_PaymentHistory adminHistory;

    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == register){
                container.setVisible(false);
                adminRegister = new PageAdmin_Register();
                PageAdmin_Register.container.setVisible(true);
            } 
            else if(e.getSource() == edit){
                container.setVisible(false);
                adminEdit = new PageAdmin_Edit();
                PageAdmin_Edit.container.setVisible(true);
            } else if(e.getSource() == appointment){
                container.setVisible(false);
                adminAppointment = new PageAdmin_Appointment_TABLE();
                PageAdmin_Appointment_TABLE.container.setVisible(true);
            } else if(e.getSource() == history){
                container.setVisible(false);
                adminHistory = new PageAdmin_PaymentHistory();
                PageAdmin_PaymentHistory.container.setVisible(true);
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
    JButton register, edit, appointment, history;
    JLabel adminText;

    public PageAdmin(){

        // Background Section
        // Frame of this Page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000,550);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
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
                User.readData();
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
        edit.setBounds((container.getWidth() - 500)/2, 250, 500, 50);
        edit.addActionListener(this);

        // Appointment Button
        appointment = new JButton("Appointment");
        appointment.setBounds((container.getWidth() - 500)/2, 330, 500, 50);
        appointment.addActionListener(this);

        // History Button
        history = new JButton("History");
        history.setBounds((container.getWidth() - 500)/2, 410, 500, 50);
        history.addActionListener(this);





        // Add Section
        container.add(register);
        container.add(edit);
        container.add(appointment);
        container.add(history);
        container.add(adminText);
        container.add(icon);
        container.setVisible(true);
    }
}
