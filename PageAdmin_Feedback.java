import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    JTable table;
    JTextArea descriptionDisplay;
    JLabel feedbackText, userText, dateText, descriptionText;
    JComboBox<String> users;

    public PageAdmin_Feedback() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(1000, 600);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageAdmin.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Left Top Panel
        // Create Panel
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setLayout(new FlowLayout());
        leftTopPanel.setBounds(45, 5, 260, 40);

        // User Role Combo Box
        String[] users = {"Technicians", "Customers"};
        JComboBox<String> usersComboBox = new JComboBox<>(users);
        usersComboBox.setPreferredSize(new Dimension(leftTopPanel.getWidth(), leftTopPanel.getHeight()));
        leftTopPanel.add(usersComboBox);

        // Left Below Panel
        // Create Panel
        JPanel leftBelowPanel = new JPanel();
        leftBelowPanel.setLayout(new FlowLayout());
        leftBelowPanel.setPreferredSize(new Dimension(100, 600));

        // Table Section
        // Table Dataset (Text File)
        Object[] roleNames = {"TestColumn"};  // Use final for constant values

        String[][] data = { {"TestRow1"}, {"TestRow2"}, {"TestRow3"} };

        // Table model and create table
        DefaultTableModel model = new DefaultTableModel(data, roleNames);
        table = new JTable(model);

        // Set column headers directly
        model.setColumnIdentifiers(roleNames);

        // Disable table editing
        table.setDefaultEditor(Object.class, null);

        // Table Frame
        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(280);
        table.setRowHeight(50);
        table.setAutoCreateRowSorter(true);

        // Scroll Pane for Left Below Panel
        JScrollPane scrollPane = new JScrollPane(leftBelowPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 50, 300, 500);
        scrollPane.setViewportView(leftBelowPanel);

        // Right Panel
        // Create Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(310, 10, 660, 540);

        // Text Section
        // Feedback Text
        feedbackText = new JLabel("Feedback");
        feedbackText.setBounds((rightPanel.getWidth()/2) + 260, 50, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(((rightPanel.getWidth() + 10)/2)+5, 100, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Date Text
        dateText = new JLabel("Date");
        dateText.setBounds(((rightPanel.getWidth() + 10)/2)+5, 170, 350, 30);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Description Text
        descriptionText = new JLabel("Description");
        descriptionText.setBounds(((rightPanel.getWidth() + 10)/2)+5, 240, 350, 30);
        descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Input Section
        // Username Display
        userDisplay = new JTextField();
        userDisplay.setBounds((rightPanel.getWidth() + 10)/2, 130, 600, 30);

        // Date Display
        dateDisplay = new JTextField();
        dateDisplay.setBounds((rightPanel.getWidth() + 10)/2, 200, 600, 30);

        // Description Display
        descriptionDisplay = new JTextArea(20, 50);
        descriptionDisplay.setSize(600, 400);

        // Scroll Pane for Description Display
        JScrollPane scrollPane2 = new JScrollPane(descriptionDisplay);
        scrollPane2.setBounds(25, 270, 600, 250);





        // Add Section
        // Left Top Panel
        container.add(scrollPane);
        container.add(leftTopPanel);

        // Left Below Panel
        leftBelowPanel.add(table);

        // Right Panel
        rightPanel.add(scrollPane2);
        container.add(feedbackText);
        container.add(userText);
        container.add(userDisplay);
        container.add(dateText);
        container.add(dateDisplay);
        container.add(descriptionText);
        container.add(rightPanel);

        // Container
        container.add(icon);
        usersComboBox.setVisible(true);
        container.setVisible(true);
    }
}
