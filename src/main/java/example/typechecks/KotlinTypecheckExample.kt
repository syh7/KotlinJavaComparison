package example.typechecks

import example.Animal
import example.Cat
import example.Dog

fun main(args: Array<String>) {
    KotlinTypecheckExample().example()
}

class KotlinTypecheckExample {

    fun example() {
        val animals = listOf(Cat(), Dog())
        animals.forEach { makeAnimalTalk(it) }
    }

    fun makeAnimalTalk(animal: Animal) {
        if (animal is Cat) {
            animal.meow()
        } else if (animal is Dog) {
            animal.woof()
        }
    }

    fun makeAnimalTalkWhen(animal: Animal) {
        // also works in when statements
        when (animal) {
            is Cat -> animal.meow()
            is Dog -> animal.woof()
        }
    }

}