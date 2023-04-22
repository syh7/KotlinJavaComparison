package example.range

fun main(args: Array<String>) {
    KotlinRangeExample().example()
}

class KotlinRangeExample {

    fun example() {
        for (i in (1..10).filter { it % 2 == 0 }) {
            println(i)
        }
    }
}