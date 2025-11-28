package inheritance;

import encapsulation.Animal;

public class Cat extends Animal {
    private final boolean isIndoor;

    public Cat(String name, int age, String condition, boolean isIndoor) {
        super(name, age, condition);
        this.isIndoor = isIndoor;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    @Override
    public String getSpecies() {
        return "Cat (" + (isIndoor ? "Indoor" : "Outdoor") + ")";
    }
}
