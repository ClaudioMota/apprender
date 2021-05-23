package zuera.apprender

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


