import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

        // The background of technician pages
        ImageIcon image = new ImageIcon("..\\Assignment\\Images\\Wooden_Background.jpg");
        Image setSize = image.getImage();
        setSize = setSize.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(setSize);
        JLabel ImageTechnician = new JLabel();
        ImageTechnician.setIcon(image);
        ImageTechnician.setBounds(0, 0, container.getWidth(), container.getHeight());

        // Text Section
        // History Text
        historyText = new JLabel("Unpaid");
        historyText.setBounds((container.getWidth()/2) - 50, 10, 140, 50);
        historyText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        Scanner file;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            file = new Scanner(new File("payment.txt"));
            while (file.hasNext()) {
                temp.add(file.nextLine().split(","));
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        // Create a map to store filteredRows for each technician
        Map<String, ArrayList<String[]>> technicianRows = new HashMap<>();

        for (String[] row : temp) {
            if (row.length >= 4 && !isEmptyRow(row)) {
                String technician = row[3];
                if (!technicianRows.containsKey(technician)) {
                    technicianRows.put(technician, new ArrayList<>());
                }
                technicianRows.get(technician).add(row);
            }
        }

        // Get the filteredRows for the logged-in user
        ArrayList<String[]> filteredRows = technicianRows.get(MainPage.userInput.getText());
        if (filteredRows == null) {
            filteredRows = new ArrayList<>();
        }

        String[][] data = filteredRows.toArray(new String[filteredRows.size()][]);

        // Table Section
        // Table Dataset (Text File)
        Object[] columnNames = {"Username", "Date", "Time", "Technician", "Total"};  // Use final for constant values

        // Table model and create table
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        // Set column headers directly
        model.setColumnIdentifiers(columnNames);

        table.setDefaultEditor(Object.class, null);

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
        paid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePaidButtonClick();
            }
        });

        // Add components to the frame
        container.add(paid);
        container.add(scrollpane);
        container.add(historyText);
        container.add(icon);
        container.add(ImageTechnician);
        container.setVisible(true);
    }

    private void handlePaidButtonClick() {
        // Get the selected rows from the table
        int[] selectedRows = table.getSelectedRows();

        // Remove the selected rows from the table model
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<String[]> updatedRows = new ArrayList<>();

        String currentTechnician = MainPage.userInput.getText();

        for (int i = 0; i < model.getRowCount(); i++) {
            String[] rowData = new String[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                rowData[j] = (String) model.getValueAt(i, j);
            }

            if (!isRowSelected(i, selectedRows) && rowData[3].equals(currentTechnician)) {
                updatedRows.add(rowData);
            }
        }

        // Update the table model with the remaining rows
        model.setRowCount(0);
        for (String[] rowData : updatedRows) {
            model.addRow(rowData);
        }

        // Update the payment.txt file
        updatePaymentFile(updatedRows);
    }

    private boolean isRowSelected(int rowIndex, int[] selectedRows) {
        for (int selectedRow : selectedRows) {
            if (selectedRow == rowIndex) {
                return true;
            }
        }
        return false;
    }

    private void updatePaymentFile(ArrayList<String[]> updatedRows) {
        try {
            File file = new File("payment.txt");
            ArrayList<String[]> allRows = new ArrayList<>();

            // Read all rows from the file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(",");
                allRows.add(row);
            }
            scanner.close();

            // Remove the rows that belong to the logged-in technician and are not in updatedRows
            String currentTechnician = MainPage.userInput.getText();
            allRows.removeIf(row -> row.length >= 4 && row[3].equals(currentTechnician) && !updatedRows.contains(row));
            allRows.addAll(updatedRows);

            PrintWriter writer = new PrintWriter(file);

            for (String[] row : allRows) {
                writer.println(String.join(",", row));
            }
    
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isEmptyRow(String[] row) {
        if (row.length < 4){
            return true;
        }
        for (String element : row) {
            if (!element.isEmpty()) {
                return false; // Non-empty element found, row is not empty
            }
        }
        return true; // All elements are empty, row is empty
    }
}
