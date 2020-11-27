package com.bemal.jsonplaceholder

import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call
import androidx.appcompat.app.AppCompatActivity
import com.bemal.jsonplaceholder.modal.PostModel
import com.bemal.jsonplaceholder.retrofit.ApiClient
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var postList = ArrayList<PostModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPosts.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getData()


        val adapter = PostAdapter(postList)
        rvPosts.adapter = adapter
        rvPosts.layoutManager= LinearLayoutManager(this)
    }


    private fun getData() {
        val call: Call<List<PostModel>> = ApiClient.getClient.getPosts()
        call.enqueue(object : Callback<List<PostModel>> {

            override fun onResponse(call: Call<List<PostModel>>?, response: Response<List<PostModel>>) {
                postList.addAll(response.body()!!)


                rvPosts.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PostModel>>?, t: Throwable?) {
                println("there is some mistake")
            }
        })
    }


}