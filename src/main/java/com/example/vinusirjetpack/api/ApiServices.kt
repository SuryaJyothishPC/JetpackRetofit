package com.example.vinusirjetpack.api

import com.example.vinusirjetpack.models.Post
import retrofit2.http.GET

interface ApiServices {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}