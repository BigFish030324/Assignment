import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;

public class backIcon extends JLabel {

    public backIcon() {
        ImageIcon image1 = new ImageIcon("..\\Assignment\\Images\\Back_Icon2.jpg");
        Image setSize1 = image1.getImage();
        setSize1 = setSize1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(setSize1);
        setIcon(image1);  // Set the icon on the current JLabel instance
        setBounds(10, 10, 30, 30);  // Set the bounds on the current JLabel instance
    }
}
