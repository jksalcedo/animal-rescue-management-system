package encapsulation;

import inheritance.Dog;
import inheritance.Cat;
import inheritance.FeedingTask;
import polymorphism.Task;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RescueSystem {
    // Encapsulation: The system hides the internal lists and logic
    private final List<Animal> animals;
    private final List<Task> tasks;
    private final List<AdoptionRequest> adoptions;
    private final List<Volunteer> volunteers;

    // Simple tracking for placements (Animal ID -> Location)
    private final java.util.Map<Animal, String> placements;

    public RescueSystem() {
        this.animals = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.adoptions = new ArrayList<>();
        this.volunteers = new ArrayList<>();
        this.placements = new java.util.HashMap<>();
    }

    public void registerRescue() {
        String[] options = { "Dog", "Cat" };
        int type = JOptionPane.showOptionDialog(null, "Select Animal Type", "Register Rescue",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (type == -1)
            return;

        String name = JOptionPane.showInputDialog("Enter Name:");
        if (name == null || name.trim().isEmpty())
            return;

        String ageStr = JOptionPane.showInputDialog("Enter Age:");
        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            return;
        }

        String condition = JOptionPane.showInputDialog("Enter Condition:");

        // Record rescue event details (simulated by asking, stored in admission details
        // implicitly or could be explicit)
        String rescuer = JOptionPane.showInputDialog("Rescuer Name:");
        String place = JOptionPane.showInputDialog("Rescue Location:");

        Animal animal = null;
        if (type == 0) { // Dog
            String breed = JOptionPane.showInputDialog("Enter Breed:");
            animal = new Dog(name, age, condition, breed);
        } else { // Cat
            int indoor = JOptionPane.showConfirmDialog(null, "Is it an indoor cat?", "Cat Details",
                    JOptionPane.YES_NO_OPTION);
            animal = new Cat(name, age, condition, indoor == JOptionPane.YES_OPTION);
        }

        animal.admit();
        // Append rescue info to condition or notes for now to keep it simple but
        // recorded
        animal.setCondition(condition + " [Rescued by " + rescuer + " at " + place + "]");

        animals.add(animal);
        JOptionPane.showMessageDialog(null, "Animal Rescued!\n" + animal.getAdmissionDetails());
    }

    public void assignPlacement() {
        Animal a = selectAnimal();
        if (a == null)
            return;

        String[] types = { "Shelter", "Foster Home" };
        int choice = JOptionPane.showOptionDialog(null, "Select Placement Type", "Placement",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, types, types[0]);

        if (choice == -1)
            return;

        String location = JOptionPane.showInputDialog("Enter " + types[choice] + " Name/ID:");
        if (location != null) {
            placements.put(a, types[choice] + ": " + location);
            JOptionPane.showMessageDialog(null,
                    "Placed " + a.getName() + " in " + types[choice] + " (" + location + ")");
        }
    }

    public void addMedicalRecord() {
        Animal a = selectAnimal();
        if (a == null)
            return;
        String record = JOptionPane.showInputDialog("Enter Medical/Vaccination Notes:");
        if (record != null) {
            a.addMedicalRecord(record);
            JOptionPane.showMessageDialog(null, "Record Added.");
        }
    }

    public void manageAdoptions() {
        String[] ops = { "New Request", "Review Requests" };
        int choice = JOptionPane.showOptionDialog(null, "Adoption Management", "Adoptions",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ops, ops[0]);

        if (choice == 0) {
            Animal a = selectAnimal();
            if (a == null)
                return;
            String applicant = JOptionPane.showInputDialog("Applicant Name:");
            if (applicant != null) {
                adoptions.add(new AdoptionRequest(applicant, a));
                JOptionPane.showMessageDialog(null, "Request Submitted.");
            }
        } else if (choice == 1) {
            if (adoptions.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No active requests.");
                return;
            }
            AdoptionRequest req = (AdoptionRequest) JOptionPane.showInputDialog(null, "Select Request", "Review",
                    JOptionPane.QUESTION_MESSAGE, null, adoptions.toArray(), adoptions.getFirst());

            if (req != null) {
                int action = JOptionPane.showConfirmDialog(null, "Approve this request?", "Review",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (action == JOptionPane.YES_OPTION)
                    req.approve();
                else if (action == JOptionPane.NO_OPTION)
                    req.reject();
            }
        }
    }

    public void manageVolunteers() {
        String name = JOptionPane.showInputDialog("Register Volunteer Name:");
        String contact = JOptionPane.showInputDialog("Contact Info:");
        if (name != null && contact != null) {
            volunteers.add(new Volunteer(name, contact));
            JOptionPane.showMessageDialog(null, "Volunteer Registered.");
        }
    }

    public void scheduleTask() {
        String[] types = { "General Task", "Feeding Schedule" };
        int type = JOptionPane.showOptionDialog(null, "Task Type", "Schedule",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, types, types[0]);

        if (type == -1)
            return;

        String desc = JOptionPane.showInputDialog("Description:");
        String date = JOptionPane.showInputDialog("Time/Date:");

        if (desc != null && date != null) {
            if (type == 0) {
                tasks.add(new Task(desc, date));
            } else {
                String diet = JOptionPane.showInputDialog("Diet/Food Type:");
                tasks.add(new FeedingTask(desc, date, diet));
            }
            JOptionPane.showMessageDialog(null, "Task Scheduled.");
        }
    }

    public void generateStats() {
        int total = animals.size();
        int dogs = 0, cats = 0;
        for (Animal a : animals) {
            if (a instanceof Dog)
                dogs++;
            else if (a instanceof Cat)
                cats++;
        }
        int pendingAdoptions = 0;
        for (AdoptionRequest r : adoptions)
            if (r.getStatus().equals("Pending"))
                pendingAdoptions++;

        String stats = "--- Population Statistics ---\n" +
                "Total Animals: " + total + "\n" +
                "Dogs: " + dogs + "\n" +
                "Cats: " + cats + "\n" +
                "Volunteers: " + volunteers.size() + "\n" +
                "Pending Adoptions: " + pendingAdoptions + "\n" +
                "Active Placements: " + placements.size();

        JOptionPane.showMessageDialog(null, stats);
    }

    public void viewAnimals() {
        if (animals.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No animals in system.");
            return;
        }
        StringBuilder sb = new StringBuilder("--- Current Animals ---\n");
        for (Animal a : animals) {
            sb.append(a.getAdmissionDetails());
            if (placements.containsKey(a)) {
                sb.append(" [Placed in ").append(placements.get(a)).append("]");
            }
            sb.append("\n");
            if (!a.getMedicalRecords().isEmpty()) {
                sb.append("   Medical: ").append(a.getMedicalRecords()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks scheduled.");
            return;
        }
        StringBuilder sb = new StringBuilder("--- Tasks ---\n");
        for (Task t : tasks) {
            sb.append(t.getDescription()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private Animal selectAnimal() {
        if (animals.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No animals to select.");
            return null;
        }
        Object[] choices = animals.toArray();
        return (Animal) JOptionPane.showInputDialog(null, "Select Animal", "Selection",
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    }
}
