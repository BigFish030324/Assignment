import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        container.setSize(560, 310);
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

        // The background of a hotel use for container
        ImageIcon image = new ImageIcon("..\\Assignment\\Images\\Wooden_Background.jpg");
        Image setSize = image.getImage();
        setSize = setSize.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(setSize);
        JLabel ImageTechnician = new JLabel();
        ImageTechnician.setIcon(image);
        ImageTechnician.setBounds(0, 0, container.getWidth(), container.getHeight());

        // Text Section
        // Payment Text
        paymentText = new JLabel("Payment");
        paymentText.setBounds((container.getWidth()/2) - 50, 5, 140, 50);
        paymentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(55, 50, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Services Text
        servicesText = new JLabel("Services");
        servicesText.setBounds(55, 120, 350, 30);
        servicesText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Total Text
        totalText = new JLabel("Total (RM): ");
        totalText.setBounds(55, 220, 350, 30);
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

        // Services Combo Box (Choose service here)
        String[] services = {"Service 1", "Service 2"};
        JComboBox<String> servicesComboBox = new JComboBox<>(services);
        servicesComboBox.setBounds(50, 150, 450, 30);
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

        // Button Section
        // Create New Button
        createNew = new JButton("Create New");
        createNew.setBounds(container.getWidth() - 180, 220, 120, 30);

        createNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUser = (String) usersComboBox.getSelectedItem();
                String totalValue = totalDisplay.getText();

                List<String> appointments = User.readAppointmentFile("appointment.txt");
                List<String> payments = User.readPaymentFile("payment.txt");

                boolean userExists = false;
                for (String payment : payments) {
                    String[] parts = payment.split(",");
                    String name = parts[0];
        
                    if (name.equals(selectedUser)) {
                        userExists = true;
                        break;
                    }
                }

                if (!userExists) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("payment.txt", true))) {
                        for (String appointment : appointments) {
                            String[] parts = appointment.split(",");
                            String name = parts[0];

                            if (name.equals(selectedUser)) {
                                writer.write(appointment + "," + totalValue);
                                writer.newLine();
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else{
                    JOptionPane.showMessageDialog(container, "User already has a payment record.");
                }
            }
        });

        // Input Section
        // Total Display
        totalDisplay = new JTextField();
        totalDisplay.setEditable(false);
        totalDisplay.setBounds(145, 220, 90, 30);

        // Add Section
        // Buttons
        container.add(createNew);

        // Container
        container.add(paymentText);
        container.add(userText);
        container.add(usersComboBox);
        container.add(servicesText);
        container.add(servicesComboBox);
        container.add(totalText);
        container.add(totalDisplay);

        container.add(icon);
        container.add(ImageTechnician);
        usersComboBox.setVisible(true);
        container.setVisible(true);
    }
}