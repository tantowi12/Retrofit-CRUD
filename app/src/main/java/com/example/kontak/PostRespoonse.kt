package com.example.kontak

import com.google.gson.annotations.SerializedName

data class PostRespoonse(
    val id : Int,
    val title : String?,
    @SerializedName("body")
    val text : String?
)