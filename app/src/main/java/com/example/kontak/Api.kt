package com.example.kontak

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("mahasiswa")
    fun post():Call<ArrayList<PostRespoonse>>

    @FormUrlEncoded
    @POST("mahasiswa")
    fun create(
        @Field("id") userId: Int,
        @Field("name") title: String,
        @Field("email") body: String,
        @Field("no_hp") no_hp: String,
        @Field("address") address: String
    ) :Call<CreatePostResponse>
}