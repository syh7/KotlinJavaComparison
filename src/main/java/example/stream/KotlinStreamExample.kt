package example.stream

fun main(args: Array<String>) {
    KotlinStreamExample().partitionExample()
    KotlinStreamExample().mapExample()
    KotlinStreamExample().associateExample()
    KotlinStreamExample().groupByExample()
}

class KotlinStreamExample {

    val personList = listOf(
        Person(name = "Alice", age = 18),
        Person(name = "Bob", age = 18, beerDrank = 1),
        Person(name = "Eve", age = 21, beerDrank = 6),
        Person(name = "Jan", age = 24, beerDrank = 9),
        Person(name = "Julia", age = 24, beerDrank = 3),
        Person(name = "Kees", age = 30, beerDrank = 0),
    )

    fun sumExample() {
        val totalAge = personList.sumOf { it.age }
        println("all ages combined is $totalAge")
        println("all ages combined is ${personList.sumOf { it.age }}")
    }

    fun groupByExample() {
        val ageMap = personList.groupBy { it.age }
        println("age map: $ageMap")
    }

    fun associateExample() {
        val nameAgeMap: Map<String, Int> = personList.associate { it.name to it.age }
        val personNameMap: Map<Person, String> = personList.associateWith { it.name } // associate { it to it.name }
        val namePersonMap: Map<String, Person> = personList.associateBy { it.name } // associate { it.name to it }

        println("name to age: $nameAgeMap")
        println("person to name: $personNameMap")
        println("name to person: $namePersonMap")
    }

    fun partitionExample() {
        val (namesWithA, namesWithoutA) = personList
            .partition { it.name.contains("a") }

        println("names with an a: $namesWithA")
        println("names without an a: $namesWithoutA")
    }

    fun mapExample() {
        val drunksMap = personList
            .associate { it.name to it.beerDrank }
            .filter { (name, beerDrank) -> beerDrank > 5 }

        println("Deze mensen zijn alcoholisten: ${drunksMap.keys}")
    }

    fun filtering() {
        val list = listOf("a", "b", 5, 8, true, false)

        val notStringList = list.filterNot { it is String }
        println("all elements not string in list: $notStringList")

        val evenIndices = list.filterIndexed { index, _ -> index % 2 == 0 }
        println("even indices are: $evenIndices")

        val stringList = list.filterIsInstance(String::class.java)
        println("all strings in list: $stringList")

        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        val aMap = map.filterKeys { it == "a" }
        println("a: $aMap")

        val threeMap = map.filterValues { it == 3 }
        println("3: $threeMap")

        val notA = map.filterNot { it.key == "a" }
        println("not a: $notA")
    }

}