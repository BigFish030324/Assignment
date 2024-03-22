import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Technician extends User {
    public Technician(String name, String password){
        super(1, name, password);
    }

    public static Map<String, Map<String, String>> feedbackMap = new HashMap<>();

    public static void readFeedback() {
        try (BufferedReader br = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String customer = parts[0];
                    String technician = parts[1];
                    String feedback = parts[2];

                    Map<String, String> technicianFeedback = feedbackMap.getOrDefault(customer, new HashMap<>());
                    technicianFeedback.put(technician, feedback);
                    feedbackMap.put(customer, technicianFeedback);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}