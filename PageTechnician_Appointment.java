import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PageTechnician_Appointment implements ActionListener{
    public void actionPerformed(ActionEvent e){
        // if (e.getSource() == userComboBox) {
        //     System.out.println(userComboBox.getSelectedItem());
        // } else if (e.getSource() == ok) {
        //     try {
        //         if (userInput.getText().isEmpty()) {
        //             throw new Exception();
        //         } else {
        //             container.setVisible(false);
        //             //PageAdmin.container.setVisible(true);
        //         }
        //     } catch (Exception f) {
        //         JOptionPane.showMessageDialog(container, "Invalid Input!");
        //     }
        // }
    }



    static JFrame container;
    static JTextField userInput;
    static JTextArea descriptionInput;
    JLabel appointmentText, userText, bookDateText, bookTimeText, descriptionText;
    JButton denyAll, deny, apply;
    JComboBox<String> userComboBox, bookDateBox_Date, bookDateBox_Month, bookDateBox_Year, bookTimeBox_Time, bookTimeBox_AMPM;

    public PageTechnician_Appointment(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(900,500); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Able to exit the system
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageTechnician.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Image of Appointment
        ImageIcon image1 = new ImageIcon("..\\Assignment\\Images\\Appointment.png");
        Image setSize1 = image1.getImage();
        setSize1 = setSize1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(setSize1);
        JLabel ImageAppointment = new JLabel();
        ImageAppointment.setIcon(image1);
        ImageAppointment.setBounds(100, 160, 300, 200);

        // Text Section
        // Appointment Text
        appointmentText = new JLabel("Appointment");
        appointmentText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        appointmentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(((container.getWidth() + 10)/2) + 10, 110, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Book Date Text
        bookDateText = new JLabel("Book Date");
        bookDateText.setBounds(((container.getWidth() + 10)/2) + 10, 165, 350, 30);
        bookDateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Book Time Text
        bookTimeText = new JLabel("Book Time");
        bookTimeText.setBounds(((container.getWidth() + 10)/2) + 10, 220, 350, 30);
        bookTimeText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        descriptionText = new JLabel("Description");//Description word
        descriptionText.setBounds(((container.getWidth() + 10)/2)+10, 280, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Combo Box
        // Username Combo Box
        String[] username = {"Fish", "JOJO"};
        userComboBox = new JComboBox<>(username);
        userComboBox.setBounds(((container.getWidth() + 10)/2) + 5, 135, 350, 30);
        userComboBox.addActionListener(this);

        // Book Date (Date) Combo Box
        String[] date = {"1", "2"};
        bookDateBox_Date = new JComboBox<>(date);
        bookDateBox_Date.setBounds(((container.getWidth() + 10)/2) + 5, 190, 110, 30);
        bookDateBox_Date.addActionListener(this);

        // Book Date (Month) Combo Box
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        bookDateBox_Month = new JComboBox<>(month);
        bookDateBox_Month.setBounds((container.getWidth()/2) + 130, 190, 110, 30);
        bookDateBox_Month.addActionListener(this);

        // Book Date (Year) Combo Box
        String[] year = {"2024", "2025"};
        bookDateBox_Year = new JComboBox<>(year);
        bookDateBox_Year.setBounds((container.getWidth()/2) + 250, 190, 110, 30);
        bookDateBox_Year.addActionListener(this);

        // Book Time (Number)
        String[] time = {"1", "2"};
        bookTimeBox_Time = new JComboBox<>(time);
        bookTimeBox_Time.setBounds(((container.getWidth() + 10)/2) + 5, 250, 170, 30);
        bookTimeBox_Time.addActionListener(this);

        // Book Time (AM / PM)
        String[] dayNight = {"am", "pm"};
        bookTimeBox_AMPM = new JComboBox<>(dayNight);
        bookTimeBox_AMPM.setBounds((container.getWidth()/2) + 190, 250, 170, 30);
        bookTimeBox_AMPM.addActionListener(this);

        // Text Input Section
        // Panel for Description Input
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(((container.getWidth() + 10)/2)+5, 310, 350, 90);

        // Descriptions inside Description Input
        descriptionInput = new JTextArea(20, 20);
        descriptionInput.setText("This is the default text. Please enter any text that you like here. Just add it, don't worry.");// Type description here

        // Scroll Pane inside Description Input
        JScrollPane scrollPane = new JScrollPane(descriptionInput);
        scrollPane.setBounds(0, 0, panel.getWidth(), panel.getHeight());

        // Button Section
        // Deny All Button
        denyAll = new JButton("Deny All");
        denyAll.setBounds(container.getWidth() - 440, 410, 110, 30);
        denyAll.addActionListener(this);

        // Deny Button
        deny = new JButton("Deny");
        deny.setBounds(container.getWidth() - 320, 410, 110, 30);
        deny.addActionListener(this);

        // Apply Button
        apply = new JButton("Apply");
        apply.setBounds(container.getWidth() - 200, 410, 110, 30);
        apply.addActionListener(this);




        // Add Section
        container.add(denyAll);
        container.add(deny);
        container.add(apply);

        panel.add(scrollPane);
        container.add(panel);
        container.add(appointmentText);

        container.add(userText);
        container.add(userComboBox);

        container.add(bookDateBox_Date);
        container.add(bookDateBox_Month);
        container.add(bookDateBox_Year);
        container.add(bookDateText);

        container.add(bookTimeText);
        container.add(bookTimeBox_Time);
        container.add(bookTimeBox_AMPM);

        container.add(descriptionText);

        container.add(ImageAppointment);
        container.add(icon);
        container.setVisible(true);
    }
}
