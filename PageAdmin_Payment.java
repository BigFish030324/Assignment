// import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;

public class PageAdmin_Payment implements ActionListener{
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

    public PageAdmin_Payment() {
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700, 400);
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

        userDisplay = new JTextField();//Display date here
        userDisplay.setBounds((rightPanel.getWidth()/2) + 50, 80, 400, 30);

        dateText = new JLabel("Date");//Date word
        dateText.setBounds((rightPanel.getWidth()/2) + 55, 120, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        dateDisplay = new JTextField();//Display date here
        dateDisplay.setBounds((rightPanel.getWidth()/2) + 50, 150, 400, 30);

        serviceText = new JLabel("Services");//Username word
        serviceText.setBounds((rightPanel.getWidth()/2) + 55, 190, 350, 30);
        serviceText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        serviceDisplay = new JTextField();//Display date here
        serviceDisplay.setBounds((rightPanel.getWidth()/2) + 50, 220, 400, 30);

        totalText = new JLabel("Total: ");//Date word
        totalText.setBounds(rightPanel.getWidth() + 100, rightPanel.getHeight() - 30, 350, 30);
        totalText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        totalDisplay = new JTextField();//Display date here
        totalDisplay.setBounds((rightPanel.getWidth()) + 150, 315, 90, 30);

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

        container.add(icon);
        container.setVisible(true);
    }
}
