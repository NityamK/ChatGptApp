package com.nityam.chatgptapp.model.model.chat

data class Error(
    val code: String,
    val message: String,
    val `param`: Any,
    val type: String
)