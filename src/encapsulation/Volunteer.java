package encapsulation;

public class Volunteer {
    private final String name;
    private String contact;

    public Volunteer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return name + " (" + contact + ")";
    }
}
