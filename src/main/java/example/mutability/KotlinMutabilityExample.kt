package example.mutability

fun main(args: Array<String>) {
    KotlinMutabilityExample().example()
}

class KotlinMutabilityExample {

    fun example() {
        var x = 5
        val list = mutableListOf("string")
        val notMutable = mapOf("str" to 1, "ing" to 2)
        val map = notMutable.toMutableMap()

        x = 4
        list.add("new str")
        map["add"] = 3
        println("mutable $map")
        println("not mutable $notMutable")
    }

}