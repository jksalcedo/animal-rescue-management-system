package abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstraction Demo ===");
        System.out.println("Demonstrating the IAdmittable interface.");

        // sample inner class implementing the interface to demonstrate abstraction
        IAdmission abstractDemo = new IAdmission() {
            private boolean admitted = false;

            @Override
            public void admit() {
                admitted = true;
                System.out.println("-> admit() called: Entity is now admitted.");
            }

            @Override
            public String getAdmissionDetails() {
                return "-> getAdmissionDetails(): Status is " + (admitted ? "Admitted" : "Pending");
            }
        };

        // Using the interface methods
        System.out.println("Initial State: " + abstractDemo.getAdmissionDetails());
        abstractDemo.admit();
        System.out.println("Final State: " + abstractDemo.getAdmissionDetails());
    }
}
