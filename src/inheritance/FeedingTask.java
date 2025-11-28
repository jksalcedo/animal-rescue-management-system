package inheritance;

import polymorphism.Task;

public class FeedingTask extends Task {
    private final String foodType;

    public FeedingTask(String description, String dueDate, String foodType) {
        super(description, dueDate);
        this.foodType = foodType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Diet: " + foodType + "]";
    }
}
