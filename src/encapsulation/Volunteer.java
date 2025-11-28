package encapsulation;

public class Volunteer {
    private final String name;
    private final String contact;

    public Volunteer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + contact + ")";
    }
}
