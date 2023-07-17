package com.nityam.chatgptapp.api

import com.nityam.chatgptapp.model.model.chat.ChatModel
import com.nityam.chatgptapp.model.model.imageresponse.GenrateImageModel
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

@POST("/api/image/generations")
suspend fun generateImage(
    @Header("Content-Type") contentType:String,
    @Header("Authorization") authorization:String,
    @Body requestBody: RequestBody
):GenrateImageModel

@POST("/api/completions")
    suspend fun getChar():ChatModel
}