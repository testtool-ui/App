
package com.mdselim.testgpt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var inputMessage: EditText
    private lateinit var sendButton: Button
    private val chatAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        inputMessage = findViewById(R.id.inputMessage)
        sendButton = findViewById(R.id.sendButton)

        // RecyclerView setup
        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = chatAdapter

        // Send message on button click
        sendButton.setOnClickListener {
            val userMessage = inputMessage.text.toString()
            if (userMessage.isNotEmpty()) {
                addMessage(userMessage, isBot = false)
                sendMessageToServer(userMessage)
                inputMessage.text.clear()
            }
        }
    }

    private fun addMessage(message: String, isBot: Boolean) {
        runOnUiThread {
            chatAdapter.addMessage(ChatMessage(message, isBot))
            chatRecyclerView.smoothScrollToPosition(chatAdapter.itemCount - 1)
        }
    }

    private fun sendMessageToServer(message: String) {
        val client = OkHttpClient()
        val json = JSONObject().put("message", message).toString()
        val body = RequestBody.create(MediaType.parse("application/json"), json)
        val request = Request.Builder()
            .url("https://api-4iw5.onrender.com/chat")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                addMessage("Error: Unable to connect to the server.", isBot = true)
            }

            override fun onResponse(call: Call, response: Response) {
                val reply = JSONObject(response.body()?.string()).getString("reply")
                addMessage(reply, isBot = true)
            }
        })
    }
}
