
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;

public class PageAdmin_Feedback implements ActionListener{
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
    static JTextField userDisplay, dateDisplay;
    JTextArea descriptionDisplay;
    JLabel feedbackText, userText, dateText, descriptionText;
    JComboBox<String> users;

    public PageAdmin_Feedback() {
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000, 600);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(null);

        JLabel icon = new backIcon();// Go back icon

        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageAdmin.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Left Top Panel
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setLayout(new FlowLayout());
        leftTopPanel.setBounds(45, 5, 260, 40);
        // leftTopPanel.setBackground(Color.GREEN);

        String[] users = {"Technicians", "Customers"};
        JComboBox<String> usersComboBox = new JComboBox<>(users);
        usersComboBox.setPreferredSize(new Dimension(leftTopPanel.getWidth(), leftTopPanel.getHeight()));
        leftTopPanel.add(usersComboBox);

        // Left Below Panel
        JPanel leftBelowPanel = new JPanel();
        leftBelowPanel.setLayout(new FlowLayout());
        leftBelowPanel.setPreferredSize(new Dimension(100, 600));
        // leftBelowPanel.setBackground(Color.BLUE);

        JButton button1 = new JButton("Feedback 1");//Change this button to title sent by any feedback
        button1.setPreferredSize(new Dimension(280, 40));
        leftBelowPanel.add(button1);

        JScrollPane scrollPane = new JScrollPane(leftBelowPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 50, 300, 500);
        scrollPane.setViewportView(leftBelowPanel);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(310, 10, 660, 540);
        // rightPanel.setBackground(Color.RED);

        feedbackText = new JLabel("Feedback");//Username word
        feedbackText.setBounds((rightPanel.getWidth()/2) + 260, 50, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        userText = new JLabel("Username");//Username word
        userText.setBounds(((rightPanel.getWidth() + 10)/2)+5, 100, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userDisplay = new JTextField();//Display username here
        userDisplay.setBounds((rightPanel.getWidth() + 10)/2, 130, 600, 30);

        dateText = new JLabel("Date");//Date word
        dateText.setBounds(((rightPanel.getWidth() + 10)/2)+5, 170, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        dateDisplay = new JTextField();//Display date here
        dateDisplay.setBounds((rightPanel.getWidth() + 10)/2, 200, 600, 30);

        descriptionText = new JLabel("Description");//Description word
        descriptionText.setBounds(((rightPanel.getWidth() + 10)/2)+5, 240, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        descriptionDisplay = new JTextArea(20, 50);// Display description here
        descriptionDisplay.setSize(600, 400);

        JScrollPane scrollPane2 = new JScrollPane(descriptionDisplay);
        scrollPane2.setBounds(25, 270, 600, 250);
        // scrollPane2.setBackground(Color.BLUE);

        // Left Top Panel
        container.add(scrollPane);
        container.add(leftTopPanel);

        // Right Panel
        rightPanel.add(scrollPane2);
        container.add(feedbackText);
        container.add(userText);
        container.add(userDisplay);
        container.add(dateText);
        container.add(dateDisplay);
        container.add(descriptionText);
        container.add(rightPanel);

        container.add(icon);
        usersComboBox.setVisible(true);
        container.setVisible(true);
    }
}
