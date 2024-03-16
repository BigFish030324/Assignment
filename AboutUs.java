import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutUs implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            container.dispose();
        }
    }



    static JFrame container;
    JTextArea descriptionText;
    JButton okButton;

    public AboutUs() {
        initializeGUI();
    }

    public void initializeGUI() {

        // The frame of this page
        container = new JFrame("APU Hostel Home Appliances Service Centre (AHHASC)");
        container.setSize(600, 400);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        container.setResizable(false);

        // Panel for the introduction of AHHASC
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Heading of AboutUs
        JLabel aboutUs = new JLabel("About APU Hostel Home Appliances Service Centre (AHHASC)");
        aboutUs.setBounds(20, 10, 770, 30);
        aboutUs.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Description of AboutUs
        descriptionText = new JTextArea();
        descriptionText.setEditable(false);
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setText("Welcome to your new home\n" + 
        "\nAPU is the right place for you to kick off your university life. Whether you're looking for APU On-Campus Residence, APU Off-Campus Residence or Satellite Campus Residence within Technology Park Malaysia (TPM), we offer a different range of accommodations in various styles, sizes, and budgets.\n" + 
        "\n\n\nLive, Learn, and Have Fun at APU Accommodation\n" + 
        "\nLiving away from home is a big step and the start of a new chapter. Our contemporary accommodation options are designed with you in mind, to provide a secure and welcoming home for you to create memories that will last a lifetime.\n" + 
        "\nOur APU On-Campus Residence and Satellite Campus Residence @ TPM at APU provide students the university life beyond classrooms. We provide everything that you need from common pantry to residence’s lounge areas. As a resident of APU, you'll be living in an environment designed not only to house students but also to foster community and intellectual growth.");
        descriptionText.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        // Scrollpanel of introduction to AHHASC
        JScrollPane scrollPane = new JScrollPane(descriptionText);
        scrollPane.setBounds(25, 50, 535, 250);

        // OK button which allows user to back to MainPage
        okButton = new JButton("OK");
        okButton.setBounds((container.getWidth()/2)-150, container.getHeight()-90, 300, 30);
        okButton.addActionListener(this);





        // Button
        panel.add(okButton);

        // Container
        panel.add(aboutUs);
        panel.add(scrollPane);
        container.add(panel);
        container.setVisible(true);
    }
}
