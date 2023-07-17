package com.nityam.chatgptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nityam.chatgptapp.databinding.ActivityChatBinding
import com.nityam.chatgptapp.databinding.ActivityMainBinding
import com.nityam.chatgptapp.model.model.MessageModel

class ChatActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChatBinding
    var list = ArrayList<MessageModel>()
    private lateinit var mLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}