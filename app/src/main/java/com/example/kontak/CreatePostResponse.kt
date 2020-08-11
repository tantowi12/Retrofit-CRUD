package com.example.kontak

import com.google.gson.annotations.SerializedName

data class CreatePostResponse(
    val id : Int,
    val name : String?,
    val email : String?,
    val no_hp : String?,
    @SerializedName("address")
    val text : String?
)