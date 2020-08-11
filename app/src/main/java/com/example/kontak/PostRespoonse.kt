package com.example.kontak

import com.google.gson.annotations.SerializedName

data class PostRespoonse(
    val id : Int,
    val name : String?,
    val email : String?,
    val no_hp : String?,
    @SerializedName("address")
    val text : String?
)