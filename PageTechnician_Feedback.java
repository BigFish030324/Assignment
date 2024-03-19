import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PageTechnician_Feedback implements ActionListener{
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
    JLabel customerText, feedbackText, userText, dateText, descriptionText;

    public PageTechnician_Feedback() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(750, 600);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);
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



        // Description Panel
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(null);
        descriptionPanel.setBounds(65, 280, 600, 250);
        JComboBox<String> usernameBox;

        // Text Section
        // Feedback Text
        feedbackText = new JLabel("Feedback");
        feedbackText.setBounds(descriptionPanel.getWidth()/2, 50, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(70, 100, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Date text
        dateText = new JLabel("Date");
        dateText.setBounds(70, 170, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Description Text
        descriptionText = new JLabel("Description");
        descriptionText.setBounds(70, 240, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Combo Box Section
        // User Combo Box
        String[] username = {"Darien", "SS"};
        usernameBox = new JComboBox<>(username);
        usernameBox.setBounds(65, 130, 600, 30);
        usernameBox.addActionListener(this);

        // Input Section
        // Date Display
        dateDisplay = new JTextField();
        dateDisplay.setBounds(65, 200, 600, 30);

        // Description Display
        descriptionDisplay = new JTextArea(20, 50);
        descriptionDisplay.setSize(600, 400);

        // Scroll Pane for Description Display
        JScrollPane scrollPane2 = new JScrollPane(descriptionDisplay);
        scrollPane2.setBounds(0, 0, descriptionPanel.getWidth(), descriptionPanel.getHeight());





        // Add Section

        // Description Panel
        descriptionPanel.add(scrollPane2);
        container.add(feedbackText);
        container.add(userText);
        container.add(usernameBox);
        container.add(dateText);
        container.add(dateDisplay);
        container.add(descriptionText);
        container.add(descriptionPanel);

        // Container
        container.add(icon);
        container.setVisible(true);
    }
}
