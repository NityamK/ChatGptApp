package com.nityam.chatgptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.nityam.chatgptapp.adapter.MessageAdapter
import com.nityam.chatgptapp.api.ApiUtilities
import com.nityam.chatgptapp.databinding.ActivityImageGenrateBinding
import com.nityam.chatgptapp.model.model.MessageModel
import com.nityam.chatgptapp.model.model.request.ImageGenrateRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.RequestBody

class ImageGenrateActivity : AppCompatActivity() {
    var list = ArrayList<MessageModel>()
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var adapter: MessageAdapter

    private lateinit var binding: ActivityImageGenrateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityImageGenrateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener { finish()}
        mLayoutManager=LinearLayoutManager(this)
        mLayoutManager.stackFromEnd=true
        adapter= MessageAdapter(list)
        binding.recyclerView.adapter=MessageAdapter(list)
        binding.recyclerView.layoutManager=mLayoutManager

        binding.sendbtn.setOnClickListener {
            if(binding.userMsg.text!!.isEmpty()){
                Toast.makeText(this,"Please ask your question", Toast.LENGTH_SHORT).show()
            }else{
                callApi()
            }
        }

    }

    private fun callApi() {
        list.add(MessageModel(true,false,binding.userMsg.text.toString()))
        adapter.notifyItemInserted(list.size-1)

        binding.recyclerView.recycledViewPool.clear()
        binding.recyclerView.smoothScrollToPosition(list.size-1)
        val apiInterface = ApiUtilities.getApiInterface()
        val requestBody= RequestBody.create(
            MediaType.parse("application/json"),
            Gson().toJson(
                ImageGenrateRequest(
                    2,
                    binding.userMsg.text.toString(),
                    "1024x1024"
                )
            )
        )
        val contentType ="application/json"
        val authorization="Bearer ${Utils.API_KEY}"


        lifecycleScope.launch(Dispatchers.IO){
            try{
                val response=apiInterface.generateImage(
                    contentType,authorization, requestBody
                )
                val textResponse=response.error.message.toString()

                list.add(MessageModel(false,false,textResponse))
                withContext(Dispatchers.Main){
                    adapter.notifyItemInserted(list.size-1)

                    binding.recyclerView.recycledViewPool.clear()
                    binding.recyclerView.smoothScrollToPosition(list.size-1)
                }
                binding.userMsg.text?.clear()

            } catch(e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ImageGenrateActivity,e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
