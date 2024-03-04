import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements ChangeListener{

    static JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    Slider(){
        frame = new JFrame("Slider Demo");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0, 100, 0);

        slider.setPreferredSize(new Dimension(400, 200));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(this);

        label = new JLabel("0");
        label.setBounds(100, 100, 20, 20); 

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(420, 420);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText(slider.getValue() + "");
    }
}
