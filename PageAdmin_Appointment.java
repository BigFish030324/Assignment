import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PageAdmin_Appointment implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == userComboBox) {
            System.out.println(userComboBox.getSelectedItem());
        } else if (e.getSource() == ok) {
            try {
                if (userInput.getText().isEmpty()) {
                    throw new Exception();
                } else {
                    container.setVisible(false);
                    PageAdmin.container.setVisible(true);
                }
            } catch (Exception f) {
                JOptionPane.showMessageDialog(container, "Invalid Input!");
            }
        }
    }
    
    static JFrame container;
    JButton ok;
    static JTextField userInput, descriptionInput;
    JLabel appointmentText, userText, bookDateText, bookTimeText, descriptionText;
    JComboBox<String> userComboBox, bookDateBox_Month, bookDateBox_Year, bookTimeBox_Time, bookTimeBox_AMPM;

    public PageAdmin_Appointment(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(900,500);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel icon = new backIcon();// Go back icon

        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageAdmin.container.setVisible(true);
                container.setVisible(false);
            }
        });

        appointmentText = new JLabel("Appointment");//appointment word
        appointmentText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        appointmentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds(((container.getWidth() + 10)/2)+5, 110, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // userInput = new JTextField();//Type username here
        // userInput.setBounds((container.getWidth() + 10)/2, 135, 350, 30);

        String[] username = {"Fish", "JOJO"};
        userComboBox = new JComboBox<>(username);
        userComboBox.setBounds((container.getWidth() + 10)/2, 135, 350, 30);
        userComboBox.addActionListener(this);

        bookDateText = new JLabel("Book Date");//Book date word
        bookDateText.setBounds(((container.getWidth() + 10)/2)+5, 165, 350, 30);
        bookDateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        String[] month = {"1", "2"};
        bookDateBox_Month = new JComboBox<>(month);
        bookDateBox_Month.setBounds((container.getWidth() + 10)/2, 190, 170, 30);
        bookDateBox_Month.addActionListener(this);

        String[] year = {"1", "2"};
        bookDateBox_Year = new JComboBox<>(year);
        bookDateBox_Year.setBounds((container.getWidth()/2) + 185, 190, 170, 30);
        bookDateBox_Year.addActionListener(this);

        bookTimeText = new JLabel("Book Time");//book time word
        bookTimeText.setBounds(((container.getWidth() + 10)/2)+5, 220, 350, 30);
        bookTimeText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        String[] time = {"1", "2"};
        bookTimeBox_Time = new JComboBox<>(time);
        bookTimeBox_Time.setBounds((container.getWidth() + 10)/2, 250, 170, 30);
        bookTimeBox_Time.addActionListener(this);

        String[] dayNight = {"am", "pm"};
        bookTimeBox_AMPM = new JComboBox<>(dayNight);
        bookTimeBox_AMPM.setBounds((container.getWidth()/2) + 185, 250, 170, 30);
        bookTimeBox_AMPM.addActionListener(this);

        descriptionText = new JLabel("Description");//Description word
        descriptionText.setBounds(((container.getWidth() + 10)/2)+5, 280, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        descriptionInput = new JTextField();// Type description here
        descriptionInput.setBounds((container.getWidth() + 10) / 2, 310, 350, 90);

        JScrollPane scrollPane = new JScrollPane(descriptionInput);
        scrollPane.setBounds((container.getWidth() + 10) / 2, 310, 350, 90);

        ok = new JButton("OK");//OK Button
        ok.setBounds(container.getWidth()-150, 410, 100, 30);
        ok.addActionListener(this);




        panel.add(scrollPane);
        container.add(panel);
        container.add(ok);
        container.add(appointmentText);

        container.add(userText);
        container.add(userComboBox);

        container.add(bookDateBox_Month);
        container.add(bookDateBox_Year);
        container.add(bookDateText);

        container.add(bookTimeText);
        container.add(bookTimeBox_Time);
        container.add(bookTimeBox_AMPM);

        container.add(descriptionText);
        container.add(descriptionInput);
        panel.add(scrollPane);

        container.add(icon);
        container.setVisible(true);
    }
}
