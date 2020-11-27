package com.bemal.jsonplaceholder.retrofit

import retrofit2.Call
import retrofit2.http.GET
import com.bemal.jsonplaceholder.modal.PostModel

interface ApiInterface {

    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}