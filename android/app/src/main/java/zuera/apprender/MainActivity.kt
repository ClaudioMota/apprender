package zuera.apprender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMessageBt.setOnClickListener(::runCommand)
    }

    private fun runCommand(view : View) {
        val inputTextView : TextView = TextView(applicationContext)
        val outputTextView : TextView = TextView(applicationContext)

        val message :String = messageInput.text.toString()
        inputTextView.text = message
        messageInput.text.clear()

        messagesBox.addView(inputTextView)

        outputTextView.text =  "-> " + interpretCommand(message)

        messagesBox.addView(outputTextView)
    }
}

