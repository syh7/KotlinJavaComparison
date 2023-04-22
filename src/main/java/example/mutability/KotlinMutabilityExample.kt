package example.mutability

fun main(args: Array<String>) {
    KotlinMutabilityExample().example()
}

class KotlinMutabilityExample {

    fun example() {
        val list: List<String> = listOf("string")
        val map: Map<String, Int> = mapOf("str" to 1, "ing" to 2)
    }

}