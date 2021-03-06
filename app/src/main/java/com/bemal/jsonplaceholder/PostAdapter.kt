package com.bemal.jsonplaceholder

import android.view.LayoutInflater
import android.view.View
import com.bemal.jsonplaceholder.modal.PostModel
import kotlinx.android.synthetic.main.post_item.view.*
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(var posts: List<PostModel>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.apply{
            postTitle.text = posts[position].title
        }
    }
}