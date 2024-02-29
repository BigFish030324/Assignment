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
        container.setSize(300,200);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        successText = new JLabel("Successful!");//register word
        successText.setBounds((container.getWidth() - 140)/2, 50, 140, 50);
        successText.setFont(new Font("Times New Roman", Font.BOLD, 24));

        ok = new JButton("OK");//OK Button
        ok.setBounds(container.getWidth()-100, 80, 100, 30);
        ok.addActionListener(this);

        container.add(ok);
        container.add(successText);
        container.setVisible(true);
    }
}
