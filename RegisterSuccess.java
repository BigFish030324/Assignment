import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RegisterSuccess implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            container.setVisible(false);
        }
    }



    static JFrame container;
    JButton ok;
    JLabel successText;

    public RegisterSuccess(){

        // Frame for this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(350,160); // GUI Size
        container.setLocationRelativeTo(null); // GUI Location
        container.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Set unable to exit this program
        container.setResizable(false); // Fix the GUI Size
        container.setLayout(null);

        // Success Text
        successText = new JLabel("Successfully Added!");
        successText.setBounds((container.getWidth()/2)-90, 20, 200, 50);
        successText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // OK Button
        ok = new JButton("OK");
        ok.setBounds((container.getWidth()/2)+45, 80, 100, 30);
        ok.addActionListener(this);





        // Add Section
        container.add(ok);
        container.add(successText);
        container.setVisible(true);
    }
}
