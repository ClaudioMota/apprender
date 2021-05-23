package zuera.apprender

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Represent a element on the command list view
class MessageAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textView : TextView = view.findViewById(R.id.messageText)

    fun fillData(string : String)
    {
        textView.text = string
    }
}

// Adapter for the messages
class MessageAdapter(private val messages : MutableList<String>) :
    RecyclerView.Adapter<MessageAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapterViewHolder {
        val messageItemView : View = LayoutInflater.from(parent.context).
            inflate(R.layout.message_layout, parent, false)
        return MessageAdapterViewHolder(messageItemView)
    }

    override fun onBindViewHolder(holder: MessageAdapterViewHolder, position: Int) {
        holder.fillData(messages[position])
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}