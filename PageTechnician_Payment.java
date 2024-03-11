// import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;

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
    JLabel paymentText, userText, dateText, servicesText, totalText;
    static JButton createNew, ok;
    JComboBox<String> users, date, month, services;

    public PageTechnician_Payment() {
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700, 400);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(null);

        JLabel icon = new backIcon();// Go back icon

        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageTechnician.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Left Top Panel
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setLayout(new FlowLayout());
        leftTopPanel.setBounds(45, 5, 200, 40);
        // leftTopPanel.setBackground(Color.GREEN);

        // Left Below Panel
        JPanel leftBelowPanel = new JPanel();
        leftBelowPanel.setLayout(new FlowLayout());
        leftBelowPanel.setPreferredSize(new Dimension(100, 600));
        // leftBelowPanel.setBackground(Color.BLUE);

        JScrollPane scrollPane = new JScrollPane(leftBelowPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 50, 235, 300);
        scrollPane.setViewportView(leftBelowPanel);

        JButton button1 = new JButton("Payment 1");//Change this button to title sent by any feedback
        button1.setPreferredSize(new Dimension(200, 40));
        leftBelowPanel.add(button1);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(250, 5, 430, 345);
        // rightPanel.setBackground(Color.RED);

        paymentText = new JLabel("Payment");//Username word
        paymentText.setBounds((container.getWidth()/2) - 50, 5, 140, 50);
        paymentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds((rightPanel.getWidth()/2) + 55, 50, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        String[] users = {"Fish", "JOJO"};
        JComboBox<String> usersComboBox = new JComboBox<>(users);
        usersComboBox.setBounds((rightPanel.getWidth()/2) + 50, 80, 400, 30);
        rightPanel.add(usersComboBox);

        dateText = new JLabel("Date");//Date word
        dateText.setBounds((rightPanel.getWidth()/2) + 55, 120, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        String[] date = {"1", "2"};
        JComboBox<String> dateComboBox = new JComboBox<>(date);
        dateComboBox.setBounds((rightPanel.getWidth()/2) + 50, 150, 100, 30);
        rightPanel.add(dateComboBox);

        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(month);
        monthComboBox.setBounds((rightPanel.getWidth()/2) + 160, 150, 100, 30);
        rightPanel.add(monthComboBox);

        servicesText = new JLabel("Services");//Username word
        servicesText.setBounds((rightPanel.getWidth()/2) + 55, 190, 350, 30);
        servicesText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        String[] services = {"Service 1", "Service 2"};
        JComboBox<String> servicesComboBox = new JComboBox<>(services);
        servicesComboBox.setBounds((rightPanel.getWidth()/2) + 50, 220, 400, 30);
        rightPanel.add(servicesComboBox);

        totalText = new JLabel("Total (RM): ");//Date word
        totalText.setBounds((rightPanel.getWidth()/2) + 55, rightPanel.getHeight() - 30, 350, 30);
        totalText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        totalDisplay = new JTextField();//Display date here
        totalDisplay.setBounds((rightPanel.getWidth()/2) + 150, 315, 90, 30);

        createNew = new JButton("Create New");//Create New Button
        createNew.setBounds(rightPanel.getWidth() + 115, rightPanel.getHeight() - 70, 120, 30);
        createNew.addActionListener(this);
        // createNew.setEnabled(false); // If payment is in new page, do not let user to create new

        ok = new JButton("OK");//OK Button
        ok.setBounds(rightPanel.getWidth() + 115, rightPanel.getHeight() - 30, 120, 30);
        ok.addActionListener(this);



        /// Buttons
        container.add(icon);
        container.add(createNew);
        container.add(ok);

        // Left Top Panel
        container.add(scrollPane);
        container.add(leftTopPanel);

        // Right Panel
        container.add(paymentText);
        container.add(userText);
        container.add(usersComboBox);
        container.add(dateText);
        // container.add(dateDisplay);
        container.add(dateComboBox);
        container.add(monthComboBox);
        container.add(servicesText);
        container.add(servicesComboBox);
        container.add(totalText);
        container.add(totalDisplay);
        container.add(rightPanel);

        usersComboBox.setVisible(true);
        container.setVisible(true);
    }
}
