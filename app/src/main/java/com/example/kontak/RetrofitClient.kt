package com.example.kontak

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.GsonBuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private const val BASE_URL = "https://7148072b8767.ngrok.io/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}

data class WrappedListResponse<T> (
    @SerializedName("status") var status : String?,
    @SerializedName("values") var values : List<T>
){
    constructor() : this(null, listOf())

}