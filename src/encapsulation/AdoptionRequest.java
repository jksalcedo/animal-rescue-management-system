package encapsulation;

public class AdoptionRequest {
    private final String applicantName;
    private final Animal animal;
    private String status; // Pending, Approved, Rejected

    public AdoptionRequest(String applicantName, Animal animal) {
        this.applicantName = applicantName;
        this.animal = animal;
        this.status = "Pending";
    }

    public String getApplicantName() {
        return applicantName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject() {
        this.status = "Rejected";
    }

    @Override
    public String toString() {
        return "Applicant: " + applicantName + " for " + animal.getName() + " [" + status + "]";
    }
}
