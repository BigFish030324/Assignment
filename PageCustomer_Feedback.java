
// import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.MouseEvent;

public class PageCustomer_Feedback implements ActionListener{
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
    JTextArea descriptionDisplay;
    JLabel feedbackText;
    static JButton ok;

    public PageCustomer_Feedback() {
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(700, 400);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(null);

        JLabel icon = new backIcon();// Go back icon

        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PageCustomer.container.setVisible(true);
                container.setVisible(false);
            }
        });

        feedbackText = new JLabel("Feedback");//Username word
        feedbackText.setBounds((container.getWidth() - 140)/2, 30, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        descriptionDisplay = new JTextArea(15, 50);// Display description here
        descriptionDisplay.setSize(300, 200);

        JScrollPane scrollPane2 = new JScrollPane(descriptionDisplay);
        scrollPane2.setBounds((container.getWidth() - 600)/2, (container.getHeight() - 200)/2, 600, 200);
        // scrollPane2.setBackground(Color.BLUE);

        ok = new JButton("OK");//OK Button
        ok.setBounds(540, 320, 110, 30);
        ok.addActionListener(this);


        container.add(ok);
        container.add(icon);

        container.add(scrollPane2);
        container.add(feedbackText);
        
        container.setVisible(true);
    }
}
