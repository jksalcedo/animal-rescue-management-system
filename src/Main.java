import encapsulation.RescueSystem;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        RescueSystem system = new RescueSystem();

        while (true) {
            String[] mainOptions = {
                    "Animal Management",
                    "Placement Management",
                    "Medical Records",
                    "Adoption Management",
                    "Volunteer Management",
                    "Task Management",
                    "Reports",
                    "Exit"
            };

            int mainChoice = JOptionPane.showOptionDialog(null,
                    "Animal Rescue Management System",
                    "Main Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    mainOptions,
                    mainOptions[0]);

            if (mainChoice == -1 || mainChoice == 7)
                break;

            switch (mainChoice) {
                case 0: // Animal Management
                    handleAnimalManagement(system);
                    break;
                case 1: // Placement Management
                    handlePlacementManagement(system);
                    break;
                case 2: // Medical Records
                    system.addMedicalRecord();
                    break;
                case 3: // Adoption Management
                    handleAdoptionManagement(system);
                    break;
                case 4: // Volunteer Management
                    handleVolunteerManagement(system);
                    break;
                case 5: // Task Management
                    handleTaskManagement(system);
                    break;
                case 6: // Reports
                    handleReports(system);
                    break;
            }
        }
    }

    private static void handleAnimalManagement(RescueSystem system) {
        String[] options = { "Register Rescue", "View Animals", "Update Animal", "Delete Animal", "Back" };
        int choice = JOptionPane.showOptionDialog(null, "Animal Management", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                system.registerRescue();
                break;
            case 1:
                system.viewAnimals();
                break;
            case 2:
                system.updateAnimal();
                break;
            case 3:
                system.deleteAnimal();
                break;
        }
    }

    private static void handlePlacementManagement(RescueSystem system) {
        String[] options = { "Assign Placement", "Update Placement", "Remove Placement", "Back" };
        int choice = JOptionPane.showOptionDialog(null, "Placement Management", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                system.assignPlacement();
                break;
            case 1:
                system.updatePlacement();
                break;
            case 2:
                system.removePlacement();
                break;
        }
    }

    private static void handleAdoptionManagement(RescueSystem system) {
        String[] options = { "New Request", "Review Requests", "Delete Request", "Back" };
        int choice = JOptionPane.showOptionDialog(null, "Adoption Management", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                system.manageAdoptions(); // Will handle new request
                break;
            case 1:
                system.manageAdoptions(); // Will handle review
                break;
            case 2:
                system.deleteAdoptionRequest();
                break;
        }
    }

    private static void handleVolunteerManagement(RescueSystem system) {
        String[] options = { "Register Volunteer", "View Volunteers", "Update Volunteer", "Delete Volunteer",
                "Back" };
        int choice = JOptionPane.showOptionDialog(null, "Volunteer Management", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                system.manageVolunteers();
                break;
            case 1:
                system.viewVolunteers();
                break;
            case 2:
                system.updateVolunteer();
                break;
            case 3:
                system.deleteVolunteer();
                break;
        }
    }

    private static void handleTaskManagement(RescueSystem system) {
        String[] options = { "Schedule Task", "View Tasks", "Update Task", "Delete Task", "Back" };
        int choice = JOptionPane.showOptionDialog(null, "Task Management", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                system.scheduleTask();
                break;
            case 1:
                system.viewTasks();
                break;
            case 2:
                system.updateTask();
                break;
            case 3:
                system.deleteTask();
                break;
        }
    }

    private static void handleReports(RescueSystem system) {
        String[] options = { "View Statistics", "View Animals", "View Tasks", "View Volunteers", "Back" };
        int choice = JOptionPane.showOptionDialog(null, "Reports", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                system.generateStats();
                break;
            case 1:
                system.viewAnimals();
                break;
            case 2:
                system.viewTasks();
                break;
            case 3:
                system.viewVolunteers();
                break;
        }
    }
}
