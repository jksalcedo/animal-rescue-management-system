package polymorphism;

public class Task implements ISchedule {
    private String description;
    private String dateTime;

    public Task(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public void perform() {
        System.out.println("Performing task: " + description + " due on " + dateTime);
    }

    @Override
    public String getDescription() {
        return description + " (" + dateTime + ")";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
