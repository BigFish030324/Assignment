import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageAdmin_Edit implements ActionListener{
    public void actionPerformed(ActionEvent e){
        String username = userInput.getText();
    
        if (e.getSource() == check) {
            try {
                int index = -1;

                // Set Buttons to enable when username exists
                for (int i = 0; i < User.userList.size(); i++) {
                    if (User.userList.get(i).getName().equals(username)) {
                        index = i;
                        passwordInput.setText(User.userList.get(i).getPass());
                        edit.setEnabled(true);
                        userRadio.setEnabled(true);
                        technicianRadio.setEnabled(true);
                        managerRadio.setEnabled(true);
                        dlt.setEnabled(true);
                        apply.setEnabled(true);
                        break;
                    }
                }

                if(index != -1){
                    if (User.userList.get(index).getRole() == 0){
                        managerRadio.setSelected(true);
                    }
                    else if (User.userList.get(index).getRole() == 1){
                        technicianRadio.setSelected(true);
                    }
                    else if (User.userList.get(index).getRole() == 2){
                        userRadio.setSelected(true);
                    }
                }
                else if (index == -1) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(container, "Invalid Input!");
            }
        } else if (e.getSource() == apply) { //Click Apply to make changes
            try {
                int index = -1;
                int role = 0;

                for (int i = 0; i < User.userList.size(); i++) {
                    if (User.userList.get(i).getName().equals(username)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {

                    // Choose radio button to change roles
                    if(managerRadio.isSelected()){
                        role = 0;
                    }else if(technicianRadio.isSelected()){
                        role = 1;
                    }else if(userRadio.isSelected()){
                        role = 2;
                    }

                    User.setPass(index, passwordInput.getText());
                    User.setRole(index, role);
                    Manager.writeData();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(container, "Invalid Input!");
                }
        } else if (e.getSource() == dlt){
            Manager.deleteUser();
        }
        

        // Click on Edit to enable edit password
        if(e.getSource() == edit){
            passwordInput.setEditable(true);
        }
    }

    private void resetComponents() {
        userInput.setText("");
        passwordInput.setText("");

        userRadio.setSelected(false);
        technicianRadio.setSelected(false);
        managerRadio.setSelected(false);

        edit.setEnabled(false);
        userRadio.setEnabled(false);
        technicianRadio.setEnabled(false);
        managerRadio.setEnabled(false);

        passwordInput.setEditable(false);
        
        apply.setEnabled(false);
        dlt.setEnabled(false);
    }



    static JFrame container;
    static JButton check, edit, apply, dlt;
    static JTextField userInput, passwordInput;
    static JRadioButton userRadio, technicianRadio, managerRadio;
    JLabel editText, userText, passwordText;

    public PageAdmin_Edit(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(550,510); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Back Icon
        JLabel icon = new backIcon();
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                resetComponents();
                PageAdmin.container.setVisible(true);
                container.setVisible(false);
            }
        });

        // Text Section
        // Edit Profile text
        editText = new JLabel("Edit Profile");
        editText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        editText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Username text
        userText = new JLabel("Username");
        userText.setBounds((container.getWidth()/10)+5, 125, 350, 30);
        userText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Password text
        passwordText = new JLabel("Password");
        passwordText.setBounds((container.getWidth()/10)+5, 195, 350, 30);
        passwordText.setFont(new Font("Times New Roman", Font.BOLD, 16));

        // Input Section
        // Username Input
        userInput = new JTextField();
        userInput.setBounds(container.getWidth()/10, 155, 350, 30);

        // Password Input
        passwordInput = new JTextField();
        passwordInput.setBounds(container.getWidth()/10, 225, 350, 30);
        passwordInput.setEditable(false);

        // Buttons
        // Check Button
        check = new JButton("Check");
        check.setBounds(container.getWidth()-140, 155, 100, 30);
        check.addActionListener(this);

        // Edit Button
        edit = new JButton("Edit");
        edit.setBounds(container.getWidth()-140, 225, 100, 30);
        edit.addActionListener(this);
        edit.setEnabled(false);

        // Apply Button
        apply = new JButton("Apply");
        apply.setBounds(container.getWidth()-160, container.getHeight()-90, 120, 30);
        apply.addActionListener(this);
        apply.setEnabled(false);

        // Delete Button
        dlt = new JButton("Delete");
        dlt.setBounds(container.getWidth()-160, container.getHeight()-130, 120, 30);
        dlt.addActionListener(this);
        dlt.setEnabled(false);

        // Radio Buttons
        // User Radiobutton
        userRadio = new JRadioButton("User");
        userRadio.setBounds(container.getWidth()/10, 270, 80, 30);
        userRadio.setEnabled(false);

        // Technician Radiobutton
        technicianRadio = new JRadioButton("Technician");
        technicianRadio.setBounds(container.getWidth()/10, 300, 90, 30);
        technicianRadio.setEnabled(false);

        // Manager Radiobutton
        managerRadio = new JRadioButton("Manager");
        managerRadio.setBounds(container.getWidth()/10, 330, 80, 30);
        managerRadio.setEnabled(false);

        // Radiobutton Group (To limit 1 role per time)
        ButtonGroup registerGroup = new ButtonGroup();
        registerGroup.add(userRadio);
        registerGroup.add(technicianRadio);
        registerGroup.add(managerRadio);

        // Part of adding apply and delete into GUI
        container.add(apply);
        container.add(dlt);

        // Part of adding to GUI:
        container.add(editText);
        container.add(userText);
        container.add(passwordText);
        container.add(userInput);
        container.add(passwordInput);
        container.add(check);
        container.add(edit);
        container.add(userRadio);
        container.add(technicianRadio);
        container.add(icon);
        container.add(managerRadio);
    }
}
