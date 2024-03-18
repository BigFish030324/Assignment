// import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PageCustomer_History implements ActionListener{
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
    static JTextField userDisplay, dateDisplay, serviceDisplay, totalDisplay;
    JLabel paymentText, userText, dateText, serviceText, totalText;

    public PageCustomer_History() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700, 400);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Left Top Panel
        // Create Panel
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setLayout(new FlowLayout());
        leftTopPanel.setBounds(45, 5, 200, 40);

        // Left Below Panel
        // Create Panel
        JPanel leftBelowPanel = new JPanel();
        leftBelowPanel.setLayout(new FlowLayout());
        leftBelowPanel.setPreferredSize(new Dimension(100, 600));

        // Payment Button (Addable button when receive new payment)
        JButton button1 = new JButton("Payment 1");
        button1.setPreferredSize(new Dimension(200, 40));
        leftBelowPanel.add(button1);

        // Scroll Pane for Left Below Panel
        JScrollPane scrollPane = new JScrollPane(leftBelowPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 50, 235, 300);
        scrollPane.setViewportView(leftBelowPanel);

        // Right Panel
        // Create panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(250, 5, 430, 345);

        // Text Section
        // Payment Text
        paymentText = new JLabel("Payment");
        paymentText.setBounds((container.getWidth()/2) - 50, 5, 140, 50);
        paymentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds((rightPanel.getWidth()/2) + 55, 50, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Date Text
        dateText = new JLabel("Date");
        dateText.setBounds((rightPanel.getWidth()/2) + 55, 120, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Services Text
        serviceText = new JLabel("Services");
        serviceText.setBounds((rightPanel.getWidth()/2) + 55, 190, 350, 30);
        serviceText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Total Text
        totalText = new JLabel("Total: ");
        totalText.setBounds(rightPanel.getWidth() + 100, rightPanel.getHeight() - 30, 350, 30);
        totalText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Input Section
        // Username Display
        userDisplay = new JTextField();
        userDisplay.setBounds((rightPanel.getWidth()/2) + 50, 80, 400, 30);

        // Date Display
        dateDisplay = new JTextField();
        dateDisplay.setBounds((rightPanel.getWidth()/2) + 50, 150, 400, 30);

        // Services Display
        serviceDisplay = new JTextField();
        serviceDisplay.setBounds((rightPanel.getWidth()/2) + 50, 220, 400, 30);

        // Total Display
        totalDisplay = new JTextField();
        totalDisplay.setBounds((rightPanel.getWidth()) + 150, 315, 90, 30);





        // Add Section
        // Left Top Panel
        container.add(scrollPane);
        container.add(leftTopPanel);

        // Right Panel
        container.add(paymentText);
        container.add(userText);
        container.add(userDisplay);
        container.add(dateText);
        container.add(dateDisplay);
        container.add(serviceText);
        container.add(serviceDisplay);
        container.add(totalText);
        container.add(totalDisplay);
        container.add(rightPanel);

        // Container
        container.add(icon);
        container.setVisible(true);
    }
}
