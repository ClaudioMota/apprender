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