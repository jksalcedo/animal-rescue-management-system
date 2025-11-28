package polymorphism;

public class Task implements ISchedulable {
    private String description;
    private String dueDate;

    public Task(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public void perform() {
        System.out.println("Performing task: " + description + " due on " + dueDate);
    }

    @Override
    public String getDescription() {
        return description + " (" + dueDate + ")";
    }
}
