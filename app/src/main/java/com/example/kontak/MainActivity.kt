package com.example.kontak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<PostRespoonse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPosts()
//        createPost()

    }

    private fun createPost() {
        RetrofitClient.instance.create(
            12,
            "tantowi",
            "tantowi@gmail.com",
            "234264575687",
            "tegal"
        ).enqueue(object : Callback<CreatePostResponse> {
            override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                tvResponse.text = t.message
            }

            override fun onResponse(
                call: Call<CreatePostResponse>,
                response: Response<CreatePostResponse>
            ) {
                val responseText = "Responsee Code ${response.code()}\n" +
                        "name: ${response.body()?.name} \n"  +
                        "email: ${response.body()?.email} \n" +
                        "no_hp: ${response.body()?.no_hp} \n" +
                        "address: ${response.body()?.text}"
                tvResponse.text = responseText
            }

        })
    }

    private fun showPosts() {
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.post().enqueue(object : Callback<ArrayList<PostRespoonse>>{
            override fun onFailure(call: Call<ArrayList<PostRespoonse>>, t: Throwable) {
                println("anjing "+t.message)
            }

            override fun onResponse(
                call: Call<ArrayList<PostRespoonse>>, response: Response<ArrayList<PostRespoonse>>) {
                val responseCode = response.code().toString()
                tvResponse.text = responseCode
                response.body()?.let { list.addAll(it) }
                println("ASU" + response.body())
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

        })    }
}