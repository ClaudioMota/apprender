package zuera.apprender

import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView

fun log(message : String) {
    Log.d("APPRENDER", message)
}

abstract class Car(var maxSpeed : Int = 80) {
    var doorCount : Int = 4
    var color : String = "BLACK"
    var hornMessage : String = "PAN PAN"

    open fun horn() {
        log(hornMessage)
    }

    fun setColorAndSpeed(color : String) {
        this.color = color

        if(color == "RED")
            maxSpeed += 10
    }

    fun showCarSpecs() {
        log("maxSpeed: $maxSpeed")
        log("doorCount: $doorCount")
        log("color: $color")
    }
}

class Fit : Car(120) {
    override fun horn() {
        super.horn()
        log("All people around look disgusted")
    }
}

class Corola : Car(200) {
    override fun horn() {
        super.horn()
        log("All people around look and smile")
    }
}

fun classesExample()
{
    val car : Car = Corola()
    val corola : Corola = Corola()
    val fit = Fit()

    fit.setColorAndSpeed("RED")

    car.showCarSpecs()
    fit.showCarSpecs()
    corola.showCarSpecs()

    fit.horn()
    car.horn()
    corola.horn()
}