import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;

public class PageAdmin_Appointment_TABLE implements ActionListener{
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



    JTable table;
    JTextField userDisplay, dateDisplay, timeDisplay;
    JLabel userText, dateText, timeText;
    static JFrame container;

    public PageAdmin_Appointment_TABLE() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.getContentPane().setBackground(Color.WHITE);
        container.setSize(580, 600);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);
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

        // Table Section
        // Table Dataset (Text File)
        Object[] columnNames = {"Username", "Date", "Time"};  // Use final for constant values

        String[][] data = {
                {"Fish", "2023-10-26", "10:00"},
                {"JOJO", "2023-11-15", "12:30"}
        };

        // Table model and create table
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        // Table Frame
        table.setBackground(Color.RED);
        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
        table.setBounds((container.getWidth()/2) - 260, 50, 500, 300);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        // Scroll pane
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setForeground(Color.RED);
        scrollpane.setBackground(Color.WHITE);

        // Text Input Section
        // User Display
        userDisplay = new JTextField();
        userDisplay.setBounds(120, 375, 410, 35);
        userDisplay.setColumns(10);

        // Date Display
        dateDisplay = new JTextField();
        dateDisplay.setBounds(120, 425, 410, 35);
        dateDisplay.setColumns(10);

        // Time Display
        timeDisplay = new JTextField();
        timeDisplay.setBounds(120, 475, 410, 35);
        timeDisplay.setColumns(10);

        // Text Section
        // Username Text
        userText = new JLabel("Username");
        userText.setBounds(30, 380, 100, 20);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Date Text
        dateText = new JLabel("Date");
        dateText.setBounds(30, 430, 100, 20);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Time Text
        timeText = new JLabel("Time");
        timeText.setBounds(30, 480, 100, 20);
        timeText.setFont(new Font("Times New Roman", Font.BOLD, 16));





        // Add components to the frame
        container.add(icon);
        container.add(scrollpane);
        container.add(table);
        container.add(userDisplay);
        container.add(dateDisplay);
        container.add(timeDisplay);
        container.add(userText);
        container.add(dateText);
        container.add(timeText);
        container.setVisible(true);
    }
}
