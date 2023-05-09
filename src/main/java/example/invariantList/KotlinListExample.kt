package example.invariantList

import example.Animal
import example.Cat
import example.Dog

fun main(args: Array<String>) {
    KotlinListExample().example()
}

class KotlinListExample {

    fun example() {

        var catList = MutableList<Cat>(1, createCat())
        var animalList = MutableList<Animal>(1, createCat())

//        catList = animalList
//        animalList = catList

//        fillList(catList)
//        fillList(animalList)
    }

    private fun fillList(list: MutableList<Animal>) {
        list.add(Cat())
        list.add(Dog())
    }

    private fun createCat() = { _: Int -> Cat() }
}