package com.example.vinusirjetpack.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinusirjetpack.api.RetrofitInstance
import com.example.vinusirjetpack.models.Post
import kotlinx.coroutines.launch
import android.util.Log

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPosts()
                _posts.postValue(response)  // ✅ Use postValue() instead of value
            } catch (e: Exception) {
                Log.e("PostViewModel", "Error fetching posts: ${e.message}")
            }
        }
    }
}
