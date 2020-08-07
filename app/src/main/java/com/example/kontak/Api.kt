package com.example.kontak

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun post():Call<ArrayList<PostRespoonse>>
}