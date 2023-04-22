package example.staticexample

import example.staticexample.KotlinStaticExample.CompanionName.nonJvmStatic

// cannot be called from Java
fun topLevelFunction() {
    println("top level")
}

fun main(args: Array<String>) {
    // can call with or without companion object name
    KotlinStaticExample.nonJvmStatic()
    KotlinStaticExample.CompanionName.nonJvmStatic()

    // can call as static import
    KotlinStaticExample.nonJvmStatic()
    nonJvmStatic()

    // companion object is a class
    val companionObject = KotlinStaticExample.CompanionName
    companionObject.nonJvmStatic()

    // non-companion objects have to be called specifically
    KotlinStaticExample.OtherObject.otherObject()

    // top level functions are static
    topLevelFunction()
}

class KotlinStaticExample {

    object OtherObject {
        fun otherObject() {
            println("other object")
        }
    }

    companion object CompanionName {

        val NON_CONSTANT = 1 // available from CompanionName.NON_CONSTANT
        const val CONSTANT = 1 // directly visible from KotlinStaticExample

        fun nonJvmStatic() {
            println("nonJvmStatic")
        }

        @JvmStatic
        fun jvmStatic() {
            println("jvmStatic")
        }
    }

}

