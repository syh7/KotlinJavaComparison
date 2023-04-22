package example.invariantArray

import example.Animal
import example.Cat
import example.Dog

fun main(args: Array<String>) {
    KotlinArrayExample().example()
}


class KotlinArrayExample {

    fun example() {
        var catArray = Array<Cat>(1, createCat())
        var animalArray = Array<Animal>(1, createCat())

//        catArray = animalArray
//        animalArray = catArray

//        copy(catArray, animalArray)
//        copyOut(animalArray, animalArray)
//        copyIn(animalArray, animalArray)

        animalArray = fillArray(animalArray)

        println("catArray")
        println(catArray)
        println("animalArray")
        println(animalArray)

    }

    private fun copy(from: Array<Animal>, to: Array<Animal>) {
        to.plus(from)
    }

    private fun copyOut(from: Array<out Animal>, to: Array<Animal>) {
//        to.plus(from)
    }

    private fun copyIn(from: Array<in Cat>, to: Array<Animal>) {
//        to.plus(from)
    }

    private fun fillArray(array: Array<Animal>): Array<Animal> {
        var temp = array.plus(Cat())
        temp = temp.plus(Dog())
        return temp
    }


    private fun createCat() = { _: Int -> Cat() }

}