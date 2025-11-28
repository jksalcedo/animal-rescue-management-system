package inheritance;

import encapsulation.Animal;

public class Dog extends Animal {
    private final String breed;

    public Dog(String name, int age, String condition, String breed) {
        super(name, age, condition);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String getSpecies() {
        return "Dog (" + breed + ")";
    }
}
