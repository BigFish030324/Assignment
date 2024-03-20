import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PageCustomer_Feedback implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == submit) {
            if(descriptionInput.getText().isEmpty()){
                JOptionPane.showMessageDialog(container, "Field cannot be empty!");
            } else{
                try {
                    Customer.writeFeedback();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    static JFrame container;
    static JButton submit;
    static JTextArea descriptionInput;
    JLabel feedbackText, technicianText;
    static JComboBox<String> technicianBox;

    public PageCustomer_Feedback() {

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

        // The background of a hotel use for container
        ImageIcon image = new ImageIcon("..\\Assignment\\Images\\Wooden_Background.jpg");
        Image setSize = image.getImage();
        setSize = setSize.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(setSize);
        JLabel ImageCustomer = new JLabel();
        ImageCustomer.setIcon(image);
        ImageCustomer.setBounds(0, 0, container.getWidth(), container.getHeight());

        // Feedback Text
        feedbackText = new JLabel("Feedback");
        feedbackText.setBounds((container.getWidth() - 140)/2, 30, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Technician Text
        technicianText = new JLabel("Technician: ");
        technicianText.setBounds((container.getWidth() - 600)/2, 100, 350, 30);
        technicianText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Technician Combo Box
        ArrayList<String> technician = new ArrayList<>();

        for (User user : User.userList){
            if(user.getRole() == 1){
                technician.add(user.getName());
            }
        }
        technicianBox = new JComboBox<>(technician.toArray(new String[0]));
        technicianBox.setBounds((container.getWidth() - 400)/2, 100, 500, 30);
        technicianBox.addActionListener(this);

        //Input Section
        // Description Input
        descriptionInput = new JTextArea(15, 50);
        descriptionInput.setSize(300, 200);
        descriptionInput.setLineWrap(true);

        // Scroll Pane for Description Input
        JScrollPane scrollPane = new JScrollPane(descriptionInput);
        scrollPane.setBounds((container.getWidth() - 600)/2, 140, 600, 150);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(540, 320, 110, 30);
        submit.addActionListener(this);

        // Add section
        container.add(submit);

        container.add(technicianBox);
        container.add(scrollPane);
        container.add(technicianText);
        container.add(feedbackText);
        
        container.add(icon);
        container.add(ImageCustomer);
        container.setVisible(true);
    }
}
