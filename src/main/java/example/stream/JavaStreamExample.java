package example.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreamExample {

    public static void main(String[] args) {
        new JavaStreamExample().partitionExample();
        new JavaStreamExample().mapExample();
        new JavaStreamExample().associateExample();
        new JavaStreamExample().groupExample();
        new JavaStreamExample().sumExample();
    }

    List<Person> personList = List.of(
            new Person("Alice", 18, 0),
            new Person("Bob", 18, 1),
            new Person("Eve", 21, 6),
            new Person("Jan", 24, 9),
            new Person("Julia", 24, 3),
            new Person("Kees", 30, 0)
    );

    private void sumExample() {
        int totalAge = personList.stream().mapToInt(Person::getAge).sum();
        System.out.println("All ages combined is " + totalAge);
    }

    private void groupExample() {
        Map<Integer, List<Person>> ageMap = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("age map: " + ageMap);
    }

    private void associateExample() {

        Map<String, Integer> nameAgeMap = personList.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        Map<Person, String> personNameMap = personList.stream().collect(Collectors.toMap(Function.identity(), Person::getName));
        Map<String, Person> namePersonMap = personList.stream().collect(Collectors.toMap(Person::getName, Function.identity()));

        System.out.println("name to age: " + nameAgeMap);
        System.out.println("person to name: " + personNameMap);
        System.out.println("name to person: " + namePersonMap);
    }

    private void partitionExample() {
        Map<Boolean, List<Person>> partitionMap = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getName().contains("a")));
        List<Person> namesWithA = partitionMap.get(true);
        List<Person> namesWithoutA = partitionMap.get(false);

        System.out.println("names with an a: " + namesWithA);
        System.out.println("names without an a: " + namesWithoutA);
    }

    private void mapExample() {
        Map<String, Integer> nameBeerMap = personList.stream().collect(Collectors.toMap(Person::getName, Person::getBeerDrank));

        Map<String, Integer> filteredMap = nameBeerMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 5)
//                .filter((name,  beerDrank) ->  beerDrank > 5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Deze mensen zijn alcoholisten: " + filteredMap.keySet());
    }

}
