package encapsulation;

import abstraction.IAdmission;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements IAdmission {
    // Encapsulation: Private fields, public getters/setters
    private final String name;
    private final int age;
    private String condition;
    private boolean admitted;
    private final List<String> medicalRecords;

    public Animal(String name, int age, String condition) {
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.admitted = false;
        this.medicalRecords = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void addMedicalRecord(String record) {
        medicalRecords.add(record);
    }

    public List<String> getMedicalRecords() {
        return new ArrayList<>(medicalRecords); // Return copy to protect internal list
    }

    // Abstraction: Abstract method forcing subclasses to implement
    public abstract String getSpecies();

    @Override
    public void admit() {
        this.admitted = true;
    }

    @Override
    public String getAdmissionDetails() {
        return "ID: " + hashCode() + " | " + getSpecies() + ": " + name + ", Age: " + age + ", Condition: " + condition
                + ", Status: "
                + (admitted ? "Admitted" : "Pending");
    }

    @Override
    public String toString() {
        return getAdmissionDetails();
    }
}
