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

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.post().enqueue(object : Callback<ArrayList<PostRespoonse>>{
            override fun onFailure(call: Call<ArrayList<PostRespoonse>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ArrayList<PostRespoonse>>,
                response: Response<ArrayList<PostRespoonse>>
            ) {
                val responseCode = response.code().toString()
                tvResponse.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

        })
    }
}