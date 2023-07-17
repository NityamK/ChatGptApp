package com.nityam.chatgptapp.model.model.request

data class ImageGenrateRequest(
    val n: Int,
    val prompt: String,
    val size: String
)