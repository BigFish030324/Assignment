import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutUs implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            container.setVisible(false);
        }
    }

    static JFrame container;
    JButton ok;
    JLabel aboutUsText;

    public AboutUs(){
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(360,150);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        aboutUsText = new JLabel("<html>Are you sure that you want to continue the <br>action?</html>");//asking sentence
        aboutUsText.setBounds(15, 0, 330, 50);
        aboutUsText.setFont(new Font("Times New Roman", Font.PLAIN, 17));

        ok = new JButton("OK");//confirm Button
        ok.setBounds((container.getWidth()/2)+45, 70, 100, 30);
        ok.addActionListener(this);

        container.add(ok);
        container.add(aboutUsText);
        container.setVisible(true);
    }

    public class Slider {
        a
    }
}
