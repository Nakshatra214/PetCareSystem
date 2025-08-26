    import models.*;
import interfaces.*;
import exception.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VirtualPetCareSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Pet Care System");

        Pet pet = choosePet();
        if (pet != null) {
            performActions(pet);
        }
        System.out.println("Goodbye!");
    }

    private static Pet choosePet() {
        while (true) {
            try {
                System.out.println("Choose your pet: 1. Dog  2. Cat");
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter hunger level (0-100): ");
                int hunger = scanner.nextInt();
                if (hunger < 0 || hunger > 100) {
                    System.out.println("Hunger level must be between 0 and 100. Please try again.");
                    continue;
                }

                System.out.print("Enter happiness level (0-100): ");
                int happiness = scanner.nextInt();
                if (happiness < 0 || happiness > 100) {
                    System.out.println("Happiness level must be between 0 and 100. Please try again.");
                    continue;
                }

                System.out.print("Enter thirst level (0-100): ");
                int thirst = scanner.nextInt();
                if (thirst < 0 || thirst > 100) {
                    System.out.println("Thirst level must be between 0 and 100. Please try again.");
                    continue;
                }
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter your dog's name: ");
                    String dogName = scanner.nextLine();
                    return new Dog(dogName, hunger, happiness, thirst);
                } else if (choice == 2) {
                    System.out.print("Enter your cat's name: ");
                    String catName = scanner.nextLine();
                    return new Cat(catName, hunger, happiness, thirst);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private static void performActions(Pet pet) {
        boolean exit = false;
        Care carePet = (Care) pet;

        while (!exit) {
            try {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Feed");
                System.out.println("2. Play");
                System.out.println("3. Give Water");
                System.out.println("4. Save Pet Data");
                System.out.println("5. Load Pet Data");
                System.out.println("6. Display Pet Status");
                System.out.println("7. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("How much food (1-50)? ");
                        int foodAmount = scanner.nextInt();
                        carePet.feed(foodAmount);
                        break;
                    case 2:
                        carePet.play();
                        break;
                    case 3:
                        System.out.print("How much water (1-50)? ");
                        int waterAmount = scanner.nextInt();
                        carePet.giveWater(waterAmount);
                        break;
                    case 4:
                        pet.saveToFile();
                        break;
                    case 5:
                        pet.loadFromFile();
                        break;
                    case 6:
                        pet.displayStatus();
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InvalidPetActionException | OverDietException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
    }
}
