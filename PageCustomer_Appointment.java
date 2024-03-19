import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PageCustomer_Appointment implements ActionListener{

    public void actionPerformed(ActionEvent e){
        Scanner file;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            file = new Scanner(new File("appointment.txt"));
            while (file.hasNext()) {
                temp.add(file.nextLine().split(","));
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        };

        if (e.getSource() == book) {
            boolean paymentCompleted = false;
            for(int i = 0; i < temp.size(); i++){
                if(temp.get(i)[0].equals(userShow.getText())){
                    JOptionPane.showMessageDialog(container, "Please complete last payment first!");
                    paymentCompleted = true;
                    break;
                }
            }
            if(!paymentCompleted){
                Customer.makeAppointment();
                JOptionPane.showMessageDialog(container, "Appoinment made Successfully!");
                container.setVisible(false);
                PageCustomer.container.setVisible(true);
            }
        }
    }

    static JFrame container;
    static JTextField userInput, userShow;
    JButton book;
    JLabel appointmentText, userText, technicianText, bookDateText, bookTimeText;
    static JComboBox<String> technicianBox, bookDateBox_Date, bookDateBox_Month, bookDateBox_Year, bookTimeBox_Time, bookTimeBox_AMPM;

    public PageCustomer_Appointment(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(800,470); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Able to exit system
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageCustomer.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Image of Appointment
        ImageIcon image1 = new ImageIcon("..\\Assignment\\Images\\Appointment.png");
        Image setSize1 = image1.getImage();
        setSize1 = setSize1.getScaledInstance(280, 180, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(setSize1);
        JLabel ImageAppointment = new JLabel();
        ImageAppointment.setIcon(image1);
        ImageAppointment.setBounds(60, 120, 290, 190);

        // Text Section
        // Appointment Text
        appointmentText = new JLabel("Appointment");
        appointmentText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        appointmentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(((container.getWidth() + 10)/2) + 10, 110, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Technician Text
        technicianText = new JLabel("Technician");
        technicianText.setBounds(((container.getWidth() + 10)/2) + 10, 175, 350, 30);
        technicianText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Book Date Text
        bookDateText = new JLabel("Book Date");
        bookDateText.setBounds(((container.getWidth() + 10)/2) + 10, 240, 350, 30);
        bookDateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Book Time Text
        bookTimeText = new JLabel("Book Time");
        bookTimeText.setBounds(((container.getWidth() + 10)/2) + 10, 305, 350, 30);
        bookTimeText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Combo Box Section
        // Username Combo Box
        userShow = new JTextField();
        userShow.setEditable(false);
        userShow.setText(MainPage.userInput.getText());
        userShow.setBounds(((container.getWidth() + 10)/2) + 5, 135, 350, 30);

        // Technician Combo Box
        ArrayList<String> technician = new ArrayList<>();

        for (User user : User.userList){
            if(user.getRole() == 1){
                technician.add(user.getName());
            }
        }
        technicianBox = new JComboBox<>(technician.toArray(new String[0]));
        technicianBox.setBounds(((container.getWidth() + 10)/2) + 5, 200, 350, 30);
        technicianBox.addActionListener(this);

        // Book Date (Date) Combo Box
        String[] date = new String[31];

        for (int i = 1; i <= 31; i++) {
            date[i-1] = Integer.toString(i);
        };

        bookDateBox_Date = new JComboBox<>(date);
        bookDateBox_Date.setBounds((container.getWidth()/2) + 250, 265, 110, 30);
        bookDateBox_Date.addActionListener(this);

        // Book Date (Month) Combo Box
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        bookDateBox_Month = new JComboBox<>(month);
        bookDateBox_Month.setBounds((container.getWidth()/2) + 130, 265, 110, 30);
        bookDateBox_Month.addActionListener(this);
        bookDateBox_Month.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int month = bookDateBox_Month.getSelectedIndex();
                    int year = Integer.parseInt((String) bookDateBox_Year.getSelectedItem());
                    int daysInMonth = getDaysInMonth(month, year);

                    String[] daysArray = new String[daysInMonth];
                    for (int i = 0; i < daysInMonth; i++) {
                        daysArray[i] = String.valueOf(i + 1);
                    }

                    bookDateBox_Date.removeAllItems();
                    for (String day : daysArray) {
                        bookDateBox_Date.addItem(day);
                    }
                }
            }
        });

        // Book Date (Year) Combo Box
        String[] year = {"2024", "2025"};
        bookDateBox_Year = new JComboBox<>(year);
        bookDateBox_Year.setBounds(((container.getWidth() + 10)/2) + 5, 265, 110, 30);
        bookDateBox_Year.addActionListener(this);

        // Book Time (Number) Combo Box
        String[] time = new String[12];

        for(int i = 1; i <= 12; ++i){
            time[i-1] = Integer.toString(i);
        };

        bookTimeBox_Time = new JComboBox<>(time);
        bookTimeBox_Time.setBounds(((container.getWidth() + 10)/2) + 5, 330, 170, 30);
        bookTimeBox_Time.addActionListener(this);

        // Book Time (am/pm) Combo Box
        String[] dayNight = {"am", "pm"};
        bookTimeBox_AMPM = new JComboBox<>(dayNight);
        bookTimeBox_AMPM.setBounds((container.getWidth()/2) + 190, 330, 170, 30);
        bookTimeBox_AMPM.addActionListener(this);

        // Book Button
        book = new JButton("Book");
        book.setBounds(container.getWidth() - 140, 390, 100, 30);
        book.addActionListener(this);

        // Add Section
        container.add(book);
        container.add(appointmentText);

        container.add(userText);
        container.add(technicianText);
        container.add(userShow);

        container.add(technicianBox);
        container.add(bookDateBox_Date);
        container.add(bookDateBox_Month);
        container.add(bookDateBox_Year);
        container.add(bookDateText);

        container.add(bookTimeText);
        container.add(bookTimeBox_Time);
        container.add(bookTimeBox_AMPM);

        container.add(ImageAppointment);
        container.add(icon);
        container.setVisible(true);
    }

    private int getDaysInMonth(int month, int year) {
        // Months are 0-based, so we add 1
        month++;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                // Assuming non-leap year for simplicity
                return 28;
            default:
                return 0;
        }
    }
}