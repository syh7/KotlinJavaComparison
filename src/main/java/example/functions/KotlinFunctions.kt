package example.functions

import example.Cat

fun main(args: Array<String>) {
    KotlinFunctions().objectsAreFunctions()
    KotlinFunctions().canExpandObjectsWithFunctions()
}

class KotlinFunctions {

    fun plus(a: Int, b: Int): Int {
        return a + b
    }

    fun objectsAreFunctions() {
        // can create object from own function
        val plus = ::plus
        println("call plus: " + plus.call(1, 1))

        // can create object from other function
        val intToBinary = String::toString
        println("str to str:  " + intToBinary.call("str"))

        // same with lambdas
        val lambda = { a: Int, b: Int -> a + b }
        println("invoke lambda: " + lambda.invoke(1, 1)) // not - lambda or function? uses invoke instead of call
        println("direct lambda: " + lambda(1, 1))

        // same with constructors
        val catConstructor = ::Cat
        val cat: Cat = catConstructor.call()
    }


    fun canExpandObjectsWithFunctions() {
        val once = "once"
        val twice = once.repeatTwice()
        
        println("once: $once")
        println("twice: $twice")
    }

    fun String.repeatTwice(): String {
        return this.repeat(2)
    }


}