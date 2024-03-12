import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;

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
    
    static JTextField userDisplay, dateDisplay, timeDisplay;
    JLabel userText, dateText, timeText;

    public PageAdmin_Appointment_TABLE() {
        JTable table = new JTable();
        Object[] columns = {"Username", "Date", "Time"};
        DefaultTableColumnModel model = new DefaultTableColumnModel();

        JFrame container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.getContentPane().setBackground(Color.BLACK);
        container.getContentPane().setBackground(Color.WHITE);
        container.setSize(630,550);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.RED);
        table.setGridColor(Color.RED);
        table.setSelectionForeground(Color.WHITE);
        table.setFont(new Font("Times New Romen", Font.BOLD, 16));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setForeground(Color.RED);
        scrollpane.setBackground(Color.WHITE);
        scrollpane.setBounds(10, 10, 600, 350);

        userDisplay = new JTextField();//Display username here
        userDisplay.setBounds(120, 375, 185, 35);
        userDisplay.setColumns(10);

        dateDisplay = new JTextField();//Display username here
        dateDisplay.setBounds(120, 420, 185, 35);
        dateDisplay.setColumns(10);

        timeDisplay = new JTextField();//Display username here
        timeDisplay.setBounds(430, 420, 185, 35);
        timeDisplay.setColumns(10);

        userText = new JLabel("Username");
        userText.setBounds(10, 385, 100, 20);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        dateText = new JLabel("Date");
        dateText.setBounds(10, 385, 100, 20);
        dateText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        timeText = new JLabel("Time");
        timeText.setBounds(10, 385, 100, 20);
        timeText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        Object[] row = new Object[3];


        container.getContentPane().add(userDisplay);
        container.getContentPane().add(dateDisplay);
        container.getContentPane().add(timeDisplay);

        container.getContentPane().add(scrollpane);
        container.setVisible(true);
    }
}
