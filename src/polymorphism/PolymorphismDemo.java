package polymorphism;

import inheritance.FeedingTask;

public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("=== Polymorphism Demo ===");

        // Polymorphism: Treating different objects as their common interface/superclass type
        ISchedule[] schedule = new ISchedule[2];

        // 1. A Task
        schedule[0] = new Task("General Cleaning", "2023-11-01");

        // 2. A FeedingTask (Subclass of Task, which implements ISchedulable)
        schedule[1] = new FeedingTask("Morning Feed", "2023-11-01", "Dog Food");

        System.out.println("Iterating through ISchedulable array:");

        for (ISchedule item : schedule) {
            System.out.println("--------------------------------");
            // The perform() method is called on the interface
            item.perform();

            // Task returns: description + date
            // FeedingTask returns: description + date + diet
            System.out.println("Description: " + item.getDescription());
        }
    }
}
