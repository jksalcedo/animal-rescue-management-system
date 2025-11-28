package inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Demo ===");

        // Instantiate a Dog (Subclass)
        System.out.println("Creating a Dog...");
        Dog dog = new Dog("Buddy", 3, "Good", "Golden Retriever");

        // Accessing methods inherited from Animal (Parent Class)
        System.out.println("Name (Inherited from Animal): " + dog.getName());
        System.out.println("Age (Inherited from Animal): " + dog.getAge());

        // Accessing methods specific to Dog (Subclass)
        System.out.println("Breed (Specific to Dog): " + dog.getBreed());

        System.out.println("\nCreating a Cat...");
        Cat cat = new Cat("Luna", 2, "Healthy", true);

        // Accessing inherited methods
        System.out.println("Name (Inherited from Animal): " + cat.getName());

        // Accessing specific methods
        System.out.println("Is Indoor (Specific to Cat): " + cat.isIndoor());

        // Demonstrating overridden behavior
        System.out.println("Species (Overridden in Cat): " + cat.getSpecies());
    }
}
