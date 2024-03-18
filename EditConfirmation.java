import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EditConfirmation implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirm){
            container.setVisible(false);
        }
    }

    static JFrame container;
    JButton cancel, confirm;
    JLabel questionText;

    public EditConfirmation(){

        // Frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(360,150); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Set unable to close this system
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Confirmation Text
        questionText = new JLabel("<html>Are you sure that you want to continue the <br>action?</html>");
        questionText.setBounds(15, 0, 330, 50);
        questionText.setFont(new Font("Times New Roman", Font.PLAIN, 17));

        // Buttons
        // Confirm Button
        confirm = new JButton("Confirm");
        confirm.setBounds((container.getWidth()/2)+45, 70, 100, 30);
        confirm.addActionListener(this);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(115, 70, 100, 30);
        cancel.addActionListener(this);

        // Add Section
        container.add(confirm);
        container.add(cancel);
        container.add(questionText);
        container.setVisible(true);
    }
}
