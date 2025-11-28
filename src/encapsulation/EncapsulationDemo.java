package encapsulation;

public class EncapsulationDemo {
    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demo ===");

        // Create a Volunteer object
        // The state (name, contact) is hidden (private) and only accessible via methods
        Volunteer vol = new Volunteer("John Doe", "0999999999");

        System.out.println("Created Volunteer object.");

        // Accessing data through public getters
        System.out.println("Getting Name via getName(): " + vol.getName());

        // We cannot access vol.name directly because it is private.
        // System.out.println(vol.name); // This would cause a compile error

        System.out.println("Volunteer toString(): " + vol.toString());
    }
}
