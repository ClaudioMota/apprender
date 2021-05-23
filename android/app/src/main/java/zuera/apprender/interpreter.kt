package zuera.apprender

import kotlin.random.Random
import kotlin.random.nextInt


// Interprets a string as a command. Should be on the following format:
// "command(param1, param2, ..., paramN)"
fun interpretCommand(command : String) : String
{
    val commandAndParams : List<String> = command.replace(" ", "").split("(")

    if(commandAndParams.size < 2) return "Error: Should have parameters"
    if(commandAndParams.size > 2) return "Error: Too much parentheses"

    val commandName = commandAndParams[0]
    val paramsStr =  "(" + commandAndParams[1]

    var params = mutableListOf<String>()

    if(!parseParams(paramsStr, params)) return "Error: Something is wrong with the parentheses"

    val command = getCommandByName(commandName)
    return if(command != null) command!!.run(params)
    else "Error: Command not found"
}

// Retrieves a list of params from a string. The string should be on the following format:
// "(param1, param2, ..., paramN)"
fun parseParams(paramsStr : String, outParamsList : MutableList<String>) : Boolean
{
    if(!paramsStr.startsWith("(")) return false
    if(!paramsStr.endsWith(")")) return false

    val internalParams = paramsStr.substring(1, paramsStr.length-1)

    if(internalParams.isEmpty()) return true

    outParamsList.addAll(internalParams.split(","))

    var result = true

    outParamsList.forEach { param ->
        if(param.isEmpty()) result = false
    }

    return result
}

fun getCommandByName(command :String) : Command?
{
    return when(command) {
        "add" -> Add()
        "classes" -> Classes()
        else -> null
    }
}

// Runs a command given with the given parameters
// @deprecated
fun runCommand(command :String, params : List<String>) : String
{
    return when(command)
    {
        "add" -> add(params)
        "rolldice" -> rollDice(params)
        "mult" -> mult(params)
        "concatenate" -> concatenate(params)
        "classes" -> classes(params)
        else -> "Error: Command not found"
    }
}

// Concatenates all params into a single string
fun concatenate(params : List<String>) : String
{
    return params.joinToString("")
}

//This method roll dice
fun rollDice(params :List<String>): String {

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

//This method multiplyer parameters.
fun mult(params :List<String>): String {

    if(params.isEmpty()) return "Duuuude, heeelp me!"

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

//This method add two arguments
fun add(params :List<String>): String {

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

fun classes(params :List<String>) : String
{
    classesExample()

    return ""
}
