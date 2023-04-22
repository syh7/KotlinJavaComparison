package example.dataclass

fun main(args: Array<String>) {
    val car = Car(4, 2, 0)

    car.addPassenger()

    car.changeable = true
}

data class Car(
    override val tires: Int,
    val doors: Int,
    var passengers: Int
) : Vehicle(tires) {

    var changeable: Boolean = true

    fun addPassenger() {
        passengers++
    }

}

// Class and property do have to be open to be extended, Kotlin is implicitly final
open class Vehicle(open val tires: Int)