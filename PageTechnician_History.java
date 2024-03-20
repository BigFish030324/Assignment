import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PageTechnician_History implements ActionListener{
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
    JLabel historyText;
    JTable table;
    JButton paid;

    public PageTechnician_History() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700, 600);
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

        // Text Section
        // History Text
        historyText = new JLabel("History");
        historyText.setBounds((container.getWidth()/2) - 50, 10, 140, 50);
        historyText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        Scanner file;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            file = new Scanner(new File("appointment.txt"));
            while (file.hasNext()) {
                temp.add(file.nextLine().split(","));
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        
        String[][] custAppointment = new String[temp.size()][];
        for (int i = 0; i < custAppointment.length; i ++) {
            custAppointment[i] = temp.get(i);
        }

        // Table Section
        // Table Dataset (Text File)
        Object[] columnNames = {"Username", "Date", "Time", "Technician", "Total"};  // Use final for constant values

        String[][] data = custAppointment;

        // Table model and create table
        DefaultTableModel model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only the "Total" column is editable
                return column == columnNames.length - 1;
            }
        };
        table = new JTable(model);

        // Set column headers directly
        model.setColumnIdentifiers(columnNames);

        // Make the "Total" column editable
        int totalColumnIndex = -1;
        for (int i = 0; i < columnNames.length; i++) {
            if (columnNames[i].equals("Total")) {
                totalColumnIndex = i;
                break;
            }
        }

        DefaultCellEditor totalEditor = new DefaultCellEditor(new JTextField());
        if (totalColumnIndex != -1) {
            TableColumn totalColumn = table.getColumnModel().getColumn(totalColumnIndex);
            totalColumn.setCellEditor(totalEditor);
        }

        // Disable editing for other columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != totalColumnIndex) {
                TableColumn column = table.getColumnModel().getColumn(i);
                column.setCellEditor(null);
            }
        }

        // Table Frame
        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        // Scroll pane
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds((container.getWidth()/2) - 305, 70, 600, 440);

        // Paid Button
        paid = new JButton("Paid");
        paid.setBounds(container.getWidth() - 175, container.getHeight() - 80, 120, 30);
        paid.addActionListener(this);

        // Add components to the frame
        container.add(paid);
        container.add(scrollpane);
        container.add(historyText);
        container.add(icon);
        container.add(ImageTechnician);
        container.setVisible(true);
    }
}
