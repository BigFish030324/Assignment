import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    static JTextField userDisplay;
    static JTextArea descriptionDisplay;
    static JComboBox<String> usernameBox;
    JLabel customerText, feedbackText, userText, descriptionText;

    public PageTechnician_Feedback() {

        Technician.readFeedback();

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(750, 520);
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

        // The background of a hotel use for container
        ImageIcon image = new ImageIcon("..\\Assignment\\Images\\Wooden_Background.jpg");
        Image setSize = image.getImage();
        setSize = setSize.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(setSize);
        JLabel ImageTechnician = new JLabel();
        ImageTechnician.setIcon(image);
        ImageTechnician.setBounds(0, 0, container.getWidth(), container.getHeight());

        // Description Panel
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(null);
        descriptionPanel.setBounds(65, 200, 600, 250);

        // Text Section
        // Feedback Text
        feedbackText = new JLabel("Feedback");
        feedbackText.setBounds(descriptionPanel.getWidth()/2, 50, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(70, 100, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Description Text
        descriptionText = new JLabel("Description");
        descriptionText.setBounds(70, 170, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Combo Box Section
        // User Combo Box
        ArrayList<String> customer = new ArrayList<>();

        for (User user : User.userList){
            if(user.getRole() == 2){
                customer.add(user.getName());
            }
        }
        usernameBox = new JComboBox<>(customer.toArray(new String[0]));
        usernameBox.setBounds(65, 130, 600, 30);
        usernameBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCustomer = (String) e.getItem();
                    String loggedInTechnician = MainPage.userInput.getText();
                    if (Technician.feedbackMap.containsKey(selectedCustomer)) {
                        Map<String, String> technicianFeedback = Technician.feedbackMap.get(selectedCustomer);
                        String feedback = technicianFeedback.get(loggedInTechnician);
                        if (feedback != null) {
                            descriptionDisplay.setText(feedback);
                        } else {
                            descriptionDisplay.setText("No feedback found for the selected customer.");
                        }
                    } else {
                        descriptionDisplay.setText("No feedback found for the selected customer.");
                    }
                }
            }
        });

        // Description Display
        descriptionDisplay = new JTextArea(20, 50);
        descriptionDisplay.setSize(600, 400);
        descriptionDisplay.setEditable(false);

        // Scroll Pane for Description Display
        JScrollPane scrollPane2 = new JScrollPane(descriptionDisplay);
        scrollPane2.setBounds(0, 0, descriptionPanel.getWidth(), descriptionPanel.getHeight());

        // Add Section
        // Description Panel
        descriptionPanel.add(scrollPane2);
        container.add(feedbackText);
        container.add(userText);
        container.add(usernameBox);
        container.add(descriptionText);
        container.add(descriptionPanel);

        // Container
        container.add(icon);
        container.add(ImageTechnician);
        container.setVisible(true);
    }
}
