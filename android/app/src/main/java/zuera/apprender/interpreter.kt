package zuera.apprender

// Interprets a string as a command. Should be on the following format:
// "command(param1, param2, ..., paramN)"
fun interpretCommand(command : String) : String
{
    val commandAndParams : List<String> = command.replace(" ", "").split("(")

    if(commandAndParams.size < 2) return "Error: Should have parameters"
    if(commandAndParams.size > 2) return "Error: Too much parentheses"

    val command = commandAndParams[0]
    val paramsStr =  "(" + commandAndParams[1]

    var params = mutableListOf<String>()

    if(!parseParams(paramsStr, params)) return "Error: Something is wrong with the parentheses"

    return runCommand(command, params)
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

// Runs a command given with the given parameters
fun runCommand(command :String, params : List<String>) : String
{
    return when(command)
    {
        "add" -> add(params)
        "mult" -> mult(params)
        "concatenate" -> concatenate(params)
        "lookatbike" -> lookAtBike(params)
        else -> "Error: Command not found"
    }
}

// Concatenates all params into a single string
fun concatenate(params : List<String>) : String
{
    return params.joinToString("")
}

// Answer because there are many arrows on the ground
fun lookAtBike(params :List<String>) : String
{
    val text: String = "Patrick is a noob archer!"
    val text: String = "Patrick is the best archers in Valhein!"
    return text
}

//This method multiplyer two args
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
