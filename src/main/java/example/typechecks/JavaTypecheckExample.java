package example.typechecks;

import example.Animal;
import example.Cat;
import example.Dog;

public class JavaTypecheckExample {


    private void makeAnimalTalk(Animal animal) {
        if (animal instanceof Cat c) {
            c.meow();
            ((Cat) animal).meow();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.woof();
        }
    }
}
