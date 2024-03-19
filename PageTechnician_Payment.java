// import java.awt.Color;
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
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PageTechnician_Payment implements ActionListener{
    public void actionPerformed(ActionEvent e){
        // if (e.getSource() == userComboBox) {
        //     System.out.println(userComboBox.getSelectedItem());
        // } else if (e.getSource() == ok) {
        //     try {
        //         if (userInput.getText().isEmpty()) {
        //             throw new Exception();
        //         } else {
        //             container.setVisible(false);
        //             PageAdmin.container.setVisible(true);
        //         }
        //     } catch (Exception f) {
        //         JOptionPane.showMessageDialog(container, "Invalid Input!");
        //     }
        // }
    }

    static JFrame container;
    static JTextField dateDisplay, totalDisplay;
    static JButton createNew, ok;
    JLabel paymentText, userText, dateText, servicesText, totalText;
    JComboBox<String> users, date, month, services;

    public PageTechnician_Payment() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(560, 400);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Text Section
        // Payment Text
        paymentText = new JLabel("Payment");
        paymentText.setBounds((container.getWidth()/2) - 50, 5, 140, 50);
        paymentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(55, 50, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Date Text
        dateText = new JLabel("Date");
        dateText.setBounds(55, 120, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Services Text
        servicesText = new JLabel("Services");
        servicesText.setBounds(55, 190, 350, 30);
        servicesText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Total Text
        totalText = new JLabel("Total (RM): ");
        totalText.setBounds(55, 320, 350, 30);
        totalText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Combo Box Section
        // Username Combo Box

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

        ArrayList<String> customerList = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i)[3].equals(MainPage.userInput.getText())) {
                customerList.add(temp.get(i)[0]);
            }
        }

        String[] users = customerList.toArray(new String[0]);
        JComboBox<String> usersComboBox = new JComboBox<>(users);
        usersComboBox.setBounds(50, 80, 450, 30);
        container.add(usersComboBox);

        // Date (Number) Combo Box
        String[] date = new String[31];

        for (int i = 1; i <= 31; i++) {
            date[i-1] = Integer.toString(i);
        };

        JComboBox<String> dateComboBox = new JComboBox<>(date);
        dateComboBox.setBounds(50, 150, 220, 30);
        container.add(dateComboBox);

        // Date (Month) Combo Box
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(month);
        monthComboBox.addActionListener(this);
        monthComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int month = monthComboBox.getSelectedIndex();
                    int daysInMonth = getDaysInMonth(month);

                    String[] daysArray = new String[daysInMonth];
                    for (int i = 0; i < daysInMonth; i++) {
                        daysArray[i] = String.valueOf(i + 1);
                    }

                    dateComboBox.removeAllItems();
                    for (String day : daysArray) {
                        dateComboBox.addItem(day);
                    }
                }
            }
        });
        monthComboBox.setBounds(280, 150, 220, 30);
        container.add(monthComboBox);

        // Services Combo Box (Choose service here)
        String[] services = {"Service 1", "Service 2"};
        JComboBox<String> servicesComboBox = new JComboBox<>(services);
        servicesComboBox.setBounds(50, 220, 450, 30);
        container.add(servicesComboBox);

        servicesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) servicesComboBox.getSelectedItem();
                switch (selectedOption) {
                    case "Service 1":
                        // Handle Option 1 selection
                        totalDisplay.setText("10.50");
                        break;
                    case "Service 2":
                        // Handle Option 2 selection
                        totalDisplay.setText("9.20");
                        break;
                    default:
                        // Handle default case
                        totalDisplay.setText("Unknown option selected");
                        break;
                    }
                }
            });

        // Input Section
        // Total Display
        totalDisplay = new JTextField();
        totalDisplay.setEditable(false);
        totalDisplay.setBounds(145, 320, 90, 30);

        // Button Section
        // Create New Button
        createNew = new JButton("Create New");
        createNew.setBounds(container.getWidth() - 180, container.getHeight() - 120, 120, 30);
        createNew.addActionListener(this);

        // OK Button
        ok = new JButton("OK");
        ok.setBounds(container.getWidth() - 180, container.getHeight() - 80, 120, 30);
        ok.addActionListener(this);

        // Add Section
        // Buttons
        container.add(createNew);
        container.add(ok);

        container.add(paymentText);
        container.add(userText);
        container.add(usersComboBox);
        container.add(dateText);
        container.add(dateComboBox);
        container.add(monthComboBox);
        container.add(servicesText);
        container.add(servicesComboBox);
        container.add(totalText);
        container.add(totalDisplay);

        // Container
        container.add(icon);
        usersComboBox.setVisible(true);
        container.setVisible(true);
    }

    private int getDaysInMonth(int month) {
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
