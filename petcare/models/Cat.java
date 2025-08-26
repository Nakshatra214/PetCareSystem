package models;

import exception.*;
import interfaces.*;

public class Cat extends Pet implements Care {

    public Cat(String name, int hunger, int happiness, int thirst) {
        super(name, hunger, happiness, thirst);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    @Override
    public void feed(int amount) throws InvalidPetActionException, OverDietException {
        if (amount <= 0) {
            throw new InvalidPetActionException("Cannot feed negative or zero food.");
        }
        if (hunger - amount < 0) {
            throw new OverDietException("Overfeeding is not allowed. The pet's hunger cannot go below 0.");
        }
        hunger -= amount;
        System.out.println(name + " has been fed. Hunger level: " + hunger);
    }

    @Override
    public void giveWater(int amount) throws InvalidPetActionException, OverDietException {
        if (amount <= 0) {
            throw new InvalidPetActionException("Cannot give negative or zero water.");
        }
        if (thirst - amount < 0) {
            throw new OverDietException("Overhydration is not allowed. The pet's thirst cannot go below 0.");
        }
        thirst -= amount;
        System.out.println(name + " drank water. Thirst level: " + thirst);
    }

    @Override
    public void play() {
        happiness += 15;
        System.out.println(name + " is playing. Happiness level: " + happiness);
    }

    @Override
    public void displayStatus() {
        System.out.println("Cat's Status -> Name: " + name + ", Hunger: " + hunger + ", Happiness: " + happiness + ", Thirst: " + thirst);
    }
}
