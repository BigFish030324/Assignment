import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void writeFeedback() throws IOException {
        try(BufferedWriter write = new BufferedWriter(new FileWriter("feedback.txt", true))){
            write.write(PageCustomer_Feedback.descriptionInput.getText());
            write.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
