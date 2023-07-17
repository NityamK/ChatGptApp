package com.nityam.chatgptapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nityam.chatgptapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generateImage.setOnClickListener {
            startActivity(Intent(this,ImageGenrateActivity::class.java))
        }
        binding.chatWithBot.setOnClickListener {
            startActivity(Intent(this,ChatActivity::class.java))
        }
    }
}