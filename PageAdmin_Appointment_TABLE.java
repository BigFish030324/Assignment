import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PageAdmin_Appointment_TABLE implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == add) {
            Manager.makeAppointment();
            refreshTableData();
        } else if (e.getSource() == done) {
            int[] selectedRows = table.getSelectedRows();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model.removeRow(selectedRows[i]);
            }
            writeDataToFile(model);
        }
    }

    static JFrame container;
    JTable table;
    JTextField userDisplay, dateDisplay, timeDisplay;
    JLabel appointmentText, userText, technicianText, dateText, timeText;
    JButton done, add;
    static JComboBox<String> usernameBox, technicianBox, bookDateBox_Date, bookDateBox_Month, bookDateBox_Year, bookTimeBox_Time, bookTimeBox_AMPM;

    public PageAdmin_Appointment_TABLE() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(580, 650);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);
        container.setLayout(null); 

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageAdmin.container.setVisible(true);
                container.setVisible(false);
            }
        });

        Scanner file;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            file = new Scanner(new File("appointment.txt"));
            while (file.hasNext()) {
                temp.add(file.nextLine().split(","));
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        
        String[][] custAppointment = new String[temp.size()][];
        for (int i = 0; i < custAppointment.length; i ++) {
            custAppointment[i] = temp.get(i);
        }

        // Table Section
        // Table Dataset (Text File)

        Object[] columnNames = {"Username", "Date", "Time", "Technician"};  // Use final for constant values


        String[][] data = custAppointment;

        // Table model and create table
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        // Set column headers directly
        model.setColumnIdentifiers(columnNames);

        // Disable table editing
        table.setDefaultEditor(Object.class, null);

        // Table Frame
        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        // Scroll pane
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds((container.getWidth() / 2) - 260, 50, 500, 300);

        // Combo Box Section
        // User Combo Box
        ArrayList<String> usernames = new ArrayList<>();

        for (User user : User.userList){
            if(user.getRole() == 2){
                usernames.add(user.getName());
            }
        }
        usernameBox = new JComboBox<>(usernames.toArray(new String[0]));
        usernameBox.setBounds(200, 375, 330, 30);
        usernameBox.addActionListener(this);

        // Technicain Combo Box
        ArrayList<String> technician = new ArrayList<>();

        for (User user : User.userList){
            if(user.getRole() == 1){
                technician.add(user.getName());
            }
        }
        technicianBox = new JComboBox<>(technician.toArray(new String[0]));
        technicianBox.setBounds(200, 425, 330, 30);
        technicianBox.addActionListener(this);

        // Book Date (Date) Combo Box
        String[] date = new String[31];

        for (int i = 1; i <= 31; i++) {
            date[i-1] = Integer.toString(i);
        };

        bookDateBox_Date = new JComboBox<>(date);
        bookDateBox_Date.setBounds(430, 475, 100, 30);
        bookDateBox_Date.addActionListener(this);

        // Book Date (Month) Combo Box
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        bookDateBox_Month = new JComboBox<>(month);
        bookDateBox_Month.setBounds(315, 475, 100, 30);
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
        bookDateBox_Year.setBounds(200, 475, 100, 30);
        bookDateBox_Year.addActionListener(this);

        // Book Time (Number) Combo Box
        String[] time = new String[12];

        for(int i = 1; i <= 12; ++i){
            time[i-1] = Integer.toString(i);
        };

        bookTimeBox_Time = new JComboBox<>(time);
        bookTimeBox_Time.setBounds(200, 525, 160, 30);
        bookTimeBox_Time.addActionListener(this);

        // Book Time (am/pm) Combo Box
        String[] dayNight = {"am", "pm"};
        bookTimeBox_AMPM = new JComboBox<>(dayNight);
        bookTimeBox_AMPM.setBounds(370, 525, 160, 30);
        bookTimeBox_AMPM.addActionListener(this);

        // Text Section
        // Appointment Text
        appointmentText = new JLabel("Appointment");
        appointmentText.setBounds((container.getWidth() - 160)/2, 5, 160, 50);
        appointmentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(30, 380, 100, 20);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Technician Text
        technicianText = new JLabel("Technician");
        technicianText.setBounds(30, 430, 180, 20);
        technicianText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Date Text
        dateText = new JLabel("Date (YYYY-MM-DD)");
        dateText.setBounds(30, 480, 100, 20);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Time Text
        timeText = new JLabel("Time");
        timeText.setBounds(30, 530, 100, 20);
        timeText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Button Section
        // Done Button
        done = new JButton("Done");
        done.setBounds(container.getWidth()-260, container.getHeight() - 80, 100, 30);
        done.addActionListener(this);

        // Add Button
        add = new JButton("Add");
        add.setBounds(container.getWidth()-150, container.getHeight() - 80, 100, 30);
        add.addActionListener(this);

        // Add components to the frame
        container.add(done);
        container.add(add);
        container.add(icon);
        container.add(scrollpane);
        container.add(usernameBox);
        container.add(technicianBox);
        container.add(bookDateBox_Date);
        container.add(bookDateBox_Month);
        container.add(bookDateBox_Year);
        container.add(bookTimeBox_Time);
        container.add(bookTimeBox_AMPM);
        container.add(appointmentText);
        container.add(userText);
        container.add(technicianText);
        container.add(dateText);
        container.add(timeText);
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

    private void refreshTableData() {
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File("appointment.txt"));
            while (file.hasNext()) {
                temp.add(file.nextLine().split(","));
            }
            file.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    
        String[][] custAppointment = new String[temp.size()][];
        for (int i = 0; i < custAppointment.length; i++) {
            custAppointment[i] = temp.get(i);
        }
    
        // Update the table model with the new data
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(custAppointment, new Object[]{"Username", "Date", "Time", "Technician"});
    }

    private void writeDataToFile(DefaultTableModel model) {
        try {
            PrintWriter writer = new PrintWriter(new File("appointment.txt"));
            for (int i = 0; i < model.getRowCount(); i++) {
                String username = (String) model.getValueAt(i, 0);
                String date = (String) model.getValueAt(i, 1);
                String time = (String) model.getValueAt(i, 2);
                String technician = (String) model.getValueAt(i, 3);
                writer.println(username + "," + date + "," + time + "," + technician);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}