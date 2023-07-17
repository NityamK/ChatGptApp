package com.nityam.chatgptapp.api

import com.nityam.chatgptapp.model.model.chat.ChatModel
import com.nityam.chatgptapp.model.model.imageresponse.GenerateImageModel
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

@POST("/v1/image/generations")
suspend fun generateImage(
    @Header("Content-Type") contentType:String,
    @Header("Authorization") authorization:String,
    @Body requestBody: RequestBody
):GenerateImageModel

@POST("/v1/completions")
    suspend fun getChat(
    @Header("Content-Type") contentType:String,
    @Header("Authorization") authorization:String,
    @Body requestBody: RequestBody
    ):ChatModel
}
