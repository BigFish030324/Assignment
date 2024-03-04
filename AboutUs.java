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
        container.setSize(800,600);//GUI Size
        container.setLocationRelativeTo(null);//GUI Location
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);//Fix the GUI Size
        container.setLayout(null);

        aboutUsText = new JLabel("APU Hostel Home Appliances Service Centre (AHHASC) is strategically located at Technology Park Malaysia, Bukit Jalil, Kuala Lumpur. TPM is the ideal location for this new and contemporary hostel due to its strong positioning as Malaysia's primary hub for leading-edge and high-tech developments in a wide variety of areas such as Information and Communication Technology, Biotechnology, Microelectronics, Engineering and Broadcasting. TPM is also located in one of the most rapidly developing areas in Kuala Lumpur, and is well served and accessible through major highways, LRT and other forms of public transportation.");//aboutus sentence
        aboutUsText.setBounds(15, 0, 770, 50);
        aboutUsText.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        ok = new JButton("OK");//confirm Button
        ok.setBounds((container.getWidth()/2)-260, container.getHeight()-100, 500, 30);
        ok.addActionListener(this);

        container.add(ok);
        container.add(aboutUsText);
        container.setVisible(true);
    }
}