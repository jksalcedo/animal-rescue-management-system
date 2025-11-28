import encapsulation.RescueSystem;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        RescueSystem system = new RescueSystem();

        while (true) {
            String[] options = {
                    "Register Rescue",
                    "Assign Placement",
                    "Add Medical Record",
                    "Manage Adoptions",
                    "Manage Volunteers",
                    "Schedule Task",
                    "View Animals",
                    "View Tasks",
                    "View Stats",
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

            if (choice == -1 || choice == 9)
                break;

            switch (choice) {
                case 0:
                    system.registerRescue();
                    break;
                case 1:
                    system.assignPlacement();
                    break;
                case 2:
                    system.addMedicalRecord();
                    break;
                case 3:
                    system.manageAdoptions();
                    break;
                case 4:
                    system.manageVolunteers();
                    break;
                case 5:
                    system.scheduleTask();
                    break;
                case 6:
                    system.viewAnimals();
                    break;
                case 7:
                    system.viewTasks();
                    break;
                case 8:
                    system.generateStats();
                    break;
            }
        }
    }
}
