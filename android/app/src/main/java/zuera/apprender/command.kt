package zuera.apprender

import kotlin.random.Random
import kotlin.random.nextInt

// Defines a basic command
abstract class Command {
    // Runs the command
    abstract fun run(params : List<String>) : String
}

class Classes : Command() {
    override fun run(params :List<String>) : String
    {
        classesExample()
        return ""
    }
}

// Adds the arguments
class Add : Command() {
    override fun run(params :List<String>) : String
    {
        if(params.isEmpty()) return "Something is wrong!"

        val parseInt = params.map {
            it.toIntOrNull()
        }

        var add = 0

        for (i in parseInt) {
            if (i == null) return "You didn't insert acceptable values!"
            else
                add += i
        }

        return add.toString()
    }
}

// Concatenates all params into a single string
class Concatenate : Command(){
    override fun run(params: List<String>): String {
        return params.joinToString("")
    }
}

// Roll dices
class RollDice : Command() {
    override fun run(params :List<String>): String {
        if(params.isEmpty()) return "You didn't insert parameters"

        val parseInt = params.map {
            it.toIntOrNull()
        }


        val roll = mutableListOf<Int>()

        for (i in parseInt) {
            if (i == null) return "You didn't insert acceptable values!"
            if (i <= 0) return "Have you ever seen a negative or zero sided dice? Bitch..."
            else
                roll.add(Random.nextInt(1..i))

        }
        return roll.toString()
    }
}

// Multiplies parameters.
class Mult : Command() {
    override fun run(params: List<String>): String {

        if (params.isEmpty()) return "Duuuude, heeelp me!"

        val parseInt = params.map {
            it.toIntOrNull()
        }

        var mult = 1

        for (i in parseInt) {
            if (i == null) return "You didn't insert acceptable values!"
            else
                mult *= i
        }

        return mult.toString()
    }
}



