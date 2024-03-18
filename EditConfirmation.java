import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
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
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(360,150);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        // Confirmation Text
        questionText = new JLabel("<html>Are you sure that you want to continue this <br>action?</html>");
        questionText.setBounds(15, 0, 330, 50);
        questionText.setFont(new Font("Times New Roman", Font.PLAIN, 17));

        confirm = new JButton("Confirm");//confirm Button
        confirm.setBounds((container.getWidth()/2)+45, 70, 100, 30);
        confirm.addActionListener(this);

        cancel = new JButton("Cancel");//cancel Button
        cancel.setBounds(115, 70, 100, 30);
        cancel.addActionListener(this);

        container.add(confirm);
        container.add(cancel);
        container.add(questionText);
        container.setVisible(true);
    }
}
