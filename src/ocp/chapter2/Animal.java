package ocp.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {

    private final List<String> favoriteFoods;
    private final String species;
    private final int age;

    public Animal(String species, int age, List<String> favoriteFoods) {
        if (favoriteFoods == null) {
            throw new IllegalArgumentException("Favorite foods is required");
        }
        this.favoriteFoods = new ArrayList<>(favoriteFoods);

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative number");
        }
        this.age = age;

        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be empty");
        }
        this.species = species;
    }

    // Modifying an immutable object.
    public static void main(String[] args) {
        Animal lion = new Animal("lion", 5, Arrays.asList("meat", "more meat"));

        List<String> favoriteFoods = new ArrayList<>(lion.getFavoriteFoods());

        Animal updatedLion = new Animal(lion.getSpecies(), lion.getAge() + 1, favoriteFoods);

        System.out.println(lion);
        System.out.println(updatedLion);
    }

    public List<String> getFavoriteFoods() {
//        return favoriteFoods; // make the class mutable
        return new ArrayList<>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "favoriteFoods=" + favoriteFoods +
                ", species='" + species + '\'' +
                ", age=" + age +
                '}';
    }
}