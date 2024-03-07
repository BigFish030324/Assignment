
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
    static JTextField userDisplay, dateDisplay, descriptionDisplay;
    JLabel userText, dateText, descriptionText;
    JComboBox<String> users;

    public PageAdmin_Feedback() {
        JFrame container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000, 600);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(null);

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        leftPanel.setBounds(0, 0, 600, 600);
        JScrollPane scrollPane = new JScrollPane(leftPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        String[] users = {"Technicians", "Customers"};
        JComboBox<String> usersComboBox = new JComboBox<>(users);
        leftPanel.add(new JLabel("Users:"));
        leftPanel.add(usersComboBox);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(600, 0, 400, 600);
        container.add(rightPanel);

        userText = new JLabel("Username");//Username word
        userText.setBounds(((container.getWidth() + 10)/2)+5, 110, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        userDisplay = new JTextField();//Display username here
        userDisplay.setBounds((container.getWidth() + 10)/2, 135, 350, 30);

        dateText = new JLabel("Date");//Date word
        dateText.setBounds(((container.getWidth() + 10)/2)+5, 165, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        dateDisplay = new JTextField();//Display date here
        dateDisplay.setBounds((container.getWidth() + 10)/2, 190, 350, 30);

        descriptionText = new JLabel("Description");//Description word
        descriptionText.setBounds(((container.getWidth() + 10)/2)+5, 280, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        descriptionDisplay = new JTextField();// Display description here
        descriptionDisplay.setBounds((container.getWidth() + 10) / 2, 310, 350, 90);

        JScrollPane scrollPane2 = new JScrollPane(descriptionDisplay);
        scrollPane2.setBounds((container.getWidth() + 10) / 2, 310, 350, 90);

        container.add(scrollPane);
        usersComboBox.setVisible(true);
        container.setVisible(true);
    }
}
