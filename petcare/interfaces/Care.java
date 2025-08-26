package interfaces;

import exception.InvalidPetActionException;
import exception.OverDietException;

public interface Care {
    void makeSound();
    void feed(int amount) throws InvalidPetActionException, OverDietException;
    void giveWater(int amount) throws InvalidPetActionException, OverDietException;
    void play();
}
