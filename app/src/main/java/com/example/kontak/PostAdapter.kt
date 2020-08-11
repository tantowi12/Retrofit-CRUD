package com.example.kontak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter (private val list: ArrayList<PostRespoonse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postRespoonse: PostRespoonse) {
            with(itemView) {
                val text = "id: ${postRespoonse.id}\n" +
                        "name: ${postRespoonse.name}\n" +
                        "email: ${postRespoonse.email}\n" +
                        "no_hp: ${postRespoonse.no_hp}\n" +
                        "address : ${postRespoonse.text}"
                tvText.text = text
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}