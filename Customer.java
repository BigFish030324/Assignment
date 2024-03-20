import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JOptionPane;

public class Customer extends User {
    public Customer(String name, String password){
        super(2, name, password);
    }

    public static void makeAppointment(){
        String username = PageCustomer_Appointment.userShow.getText();
        String date = PageCustomer_Appointment.bookDateBox_Year.getSelectedItem().toString() + " " + PageCustomer_Appointment.bookDateBox_Month.getSelectedItem().toString() + " " + PageCustomer_Appointment.bookDateBox_Date.getSelectedItem().toString();
        String time = PageCustomer_Appointment.bookTimeBox_Time.getSelectedItem().toString() + ":00 " + PageCustomer_Appointment.bookTimeBox_AMPM.getSelectedItem().toString();
        String technician = PageCustomer_Appointment.technicianBox.getSelectedItem().toString();

        BufferedWriter write;
        try {
            write = new BufferedWriter(new FileWriter("appointment.txt", true));
            write.write(username+","+date+","+time+","+technician);
            write.newLine();

            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String feedbackFile = "feedback.txt";

    public static void writeFeedback() throws IOException {

        String customer = MainPage.userInput.getText();
        String technician = PageCustomer_Feedback.technicianBox.getSelectedItem().toString();
        String feedback = PageCustomer_Feedback.descriptionInput.getText();

        // Check if the customer has already given feedback to the technician
        boolean alreadyGivenFeedback = checkFeedbackExists(customer, technician);

        if (!alreadyGivenFeedback) {
            try (BufferedWriter write = new BufferedWriter(new FileWriter(feedbackFile, true))) {
                write.write(customer + "," + technician + "," + feedback);
                write.newLine();
                JOptionPane.showMessageDialog(PageCustomer_Feedback.container, "Feedback saved successfully.");
                PageCustomer_Feedback.container.dispose();
                PageCustomer.container.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(PageCustomer_Feedback.container, "You have already given feedback to this technician.");
        }
    }

    private static boolean checkFeedbackExists(String customer, String technician) throws IOException {
        if (!Files.exists(Paths.get(feedbackFile))) {
            return false; // Feedback file doesn't exist, so no feedback exists
        }

        List<String> lines = Files.readAllLines(Paths.get(feedbackFile));
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[0].equals(customer) && parts[1].equals(technician)) {
                return true; // Feedback already exists
            }
        }
        return false; // Feedback does not exist
    }
}
