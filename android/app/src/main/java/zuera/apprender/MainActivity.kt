package zuera.apprender

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val messages : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messagesBox.adapter = MessageAdapter(messages)
        messagesBox.layoutManager = LinearLayoutManager(applicationContext)

        showMessageBt.setOnClickListener(::runCommand)
    }

    private fun runCommand(view : View) {
        val inputMessage :String = messageInput.text.toString()
        messageInput.text.clear()
        messages.add(inputMessage)

        val outputMessage =  "-> " + interpretCommand(inputMessage)
        messages.add(outputMessage)

        messagesBox.adapter!!.notifyDataSetChanged()
    }
}

