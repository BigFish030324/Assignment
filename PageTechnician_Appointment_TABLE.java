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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PageTechnician_Appointment_TABLE implements ActionListener{
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
    JLabel appointmentText;
    JTable table;

    public PageTechnician_Appointment_TABLE() {

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
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
        // Appointment Text
        appointmentText = new JLabel("Appointment");
        appointmentText.setBounds((container.getWidth() - 160)/2, 5, 160, 50);
        appointmentText.setFont(new Font("Times New Roman", Font.BOLD, 24));

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
        
        ArrayList<String[]> custAppointment = new ArrayList<>();
        for (int i = 0; i < temp.size(); i ++) {
            if(temp.get(i)[3].equals(MainPage.userInput.getText())){
                String[] tempList = new String[3];
                tempList[0] = temp.get(i)[0];
                tempList[1] = temp.get(i)[1];
                tempList[2] = temp.get(i)[2];
                custAppointment.add(tempList);
            }
        }

        String[][] finalString = new String[custAppointment.size()][];
        for (int i = 0; i < finalString.length; i ++) {
            finalString[i] = custAppointment.get(i);
        }

        // Table Section
        // Table Dataset (Text File)
        Object[] columnNames = {"Username", "Date", "Time"};  // Use final for constant values

        String[][] data = finalString;

        // Table model and create table
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        // Set column headers directly
        model.setColumnIdentifiers(columnNames);

        // Disable table editing
        table.setDefaultEditor(Object.class, null);

        // Table Frame
        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        // Scroll pane
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds((container.getWidth() / 2) - 260, 50, 500, 480);

        // Add components to the frame
        container.add(appointmentText);
        container.add(scrollpane);
        container.add(icon);
        container.add(ImageTechnician);
        container.setVisible(true);
    }
}