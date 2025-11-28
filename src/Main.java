import encapsulation.RescueSystem;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        RescueSystem system = new RescueSystem();

        while (true) {
            String[] options = {
                    "Register Rescue",
                    "Add Medical Record",
                    "View Animals",
                    "Schedule Task",
                    "View Tasks",
                    "Exit"
            };

            int choice = JOptionPane.showOptionDialog(null,
                    "Animal Rescue Management System",
                    "Main Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == -1 || choice == 5)
                break;

            switch (choice) {
                case 0:
                    system.registerRescue();
                    break;
                case 1:
                    system.addMedicalRecord();
                    break;
                case 2:
                    system.viewAnimals();
                    break;
                case 3:
                    system.scheduleTask();
                    break;
                case 4:
                    system.viewTasks();
                    break;
            }
        }
    }
}
