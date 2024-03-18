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
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(350,160);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        successText = new JLabel("Successfully Added!");//success word
        successText.setBounds((container.getWidth()/2)-90, 20, 200, 50);
        successText.setFont(new Font("Times New Roman", Font.BOLD, 18));

        ok = new JButton("OK");//OK Button
        ok.setBounds((container.getWidth()/2)+45, 80, 100, 30);
        ok.addActionListener(this);

        container.add(ok);
        container.add(successText);
        container.setVisible(true);
    }
}
