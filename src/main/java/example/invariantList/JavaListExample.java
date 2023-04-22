package example.invariantList;

import example.Animal;
import example.Cat;
import example.Dog;

import java.util.ArrayList;
import java.util.List;


public class JavaListExample {

    public static void main(String[] args) {
        example();
    }

    private static void example() {
        List<Cat> catList = new ArrayList<>();
        List<Animal> animalList = new ArrayList<>();

//        catList = animalList;
//        animalList = catList;

//        fillList(catList);
//        fillList(animalList);
    }

    private static void fillList(List<Animal> list) {
        list.add(new Cat());
        list.add(new Dog());
    }

}
