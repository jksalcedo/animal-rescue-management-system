package encapsulation;

import inheritance.Dog;
import inheritance.Cat;
import polymorphism.Task;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RescueSystem {
    // Encapsulation: The system hides the internal lists and logic
    private List<Animal> animals;
    private List<Task> tasks;

    public RescueSystem() {
        this.animals = new ArrayList<>();
        this.tasks = new ArrayList<>();
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
        animals.add(animal);
        JOptionPane.showMessageDialog(null, "Animal Rescued!\n" + animal.getAdmissionDetails());
    }

    public void addMedicalRecord() {
        Animal a = selectAnimal();
        if (a == null)
            return;
        String record = JOptionPane.showInputDialog("Enter Medical Notes:");
        if (record != null) {
            a.addMedicalRecord(record);
            JOptionPane.showMessageDialog(null, "Record Added.");
        }
    }

    public void viewAnimals() {
        if (animals.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No animals in system.");
            return;
        }
        StringBuilder sb = new StringBuilder("--- Current Animals ---\n");
        for (Animal a : animals) {
            sb.append(a.getAdmissionDetails()).append("\n");
            if (!a.getMedicalRecords().isEmpty()) {
                sb.append("   Medical: ").append(a.getMedicalRecords()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void scheduleTask() {
        String desc = JOptionPane.showInputDialog("Task Description:");
        String date = JOptionPane.showInputDialog("Due Date:");
        if (desc != null && date != null) {
            tasks.add(new Task(desc, date));
            JOptionPane.showMessageDialog(null, "Task Scheduled.");
        }
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
