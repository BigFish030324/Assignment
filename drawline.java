import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class drawline extends JPanel{

    drawline(){
        setPreferredSize(new Dimension(10, 10));
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawLine(400, 400, 400, 0);
    }
}
