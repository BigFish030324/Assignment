
// import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PageCustomer_Feedback implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ok) {
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
    static JButton ok;
    static JTextArea descriptionInput;
    JLabel feedbackText;

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

        // Feedback Text
        feedbackText = new JLabel("Feedback");
        feedbackText.setBounds((container.getWidth() - 140)/2, 30, 140, 50);
        feedbackText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Description Input
        descriptionInput = new JTextArea(15, 50);
        descriptionInput.setSize(300, 200);

        // Scroll Pane for Description Input
        JScrollPane scrollPane = new JScrollPane(descriptionInput);
        scrollPane.setBounds((container.getWidth() - 600)/2, (container.getHeight() - 200)/2, 600, 200);

        // OK Button
        ok = new JButton("OK");
        ok.setBounds(540, 320, 110, 30);
        ok.addActionListener(this);

        // Add section
        container.add(ok);
        container.add(icon);

        container.add(scrollPane);
        container.add(feedbackText);
        
        container.setVisible(true);
    }
}
