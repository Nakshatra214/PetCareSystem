package models;

import exception.*;
import java.io.*;

public abstract class Pet {
    protected String name;
    protected int hunger;
    protected int happiness;
    protected int thirst;

    public Pet(String name, int hunger, int happiness, int thirst) {
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
        this.thirst = thirst;
    }

    public abstract void makeSound();
    public abstract void feed(int amount) throws InvalidPetActionException, OverDietException;
    public abstract void giveWater(int amount) throws InvalidPetActionException, OverDietException;
    public abstract void play();

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(name + "_data.txt")) {
            writer.write("Pet Name: " + name + "\nHunger: " + hunger + "\nHappiness: " + happiness + "\nThirst: " + thirst);
            System.out.println("Pet data saved.");
        } catch (IOException e) {
            System.out.println("Error saving pet data.");
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(name + "_data.txt"))) {
            System.out.println("Loading pet data...");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading pet data.");
        }
    }

    public void displayStatus() {
        System.out.println(name + "'s Status -> Hunger: " + hunger + ", Happiness: " + happiness + ", Thirst: " + thirst);
    }
}
