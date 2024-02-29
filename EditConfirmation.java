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
        container.setSize(350,160);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        questionText = new JLabel("Are you sure that you want to continue the action?");//register word
        questionText.setBounds((container.getWidth()/2)-90, 20, 200, 50);
        questionText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        confirm = new JButton("Confirm");//confirm Button
        confirm.setBounds((container.getWidth()/2)+45, 80, 100, 30);
        confirm.addActionListener(this);

        cancel = new JButton("Cancel");//cancel Button
        cancel.setBounds((container.getWidth()/2)+10, 80, 100, 30);
        cancel.addActionListener(this);

        container.add(confirm);
        container.add(cancel);
        container.add(questionText);
        container.setVisible(true);
    }
}
