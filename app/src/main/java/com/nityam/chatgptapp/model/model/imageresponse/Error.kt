package com.nityam.chatgptapp.model.model.imageresponse

data class Error(
    val code: String,
    val message: String,
    val `param`: Any,
    val type: String
)