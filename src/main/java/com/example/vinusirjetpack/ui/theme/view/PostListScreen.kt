package com.example.vinusirjetpack.ui.theme.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vinusirjetpack.ViewModels.postViewmodel
import com.example.vinusirjetpack.models.Post
import com.example.vinusirjetpack.ui.theme.PurpleGrey40

@Composable
fun PostListScreen(viewModel: postViewmodel = postViewmodel(), paddingValues: PaddingValues) {
    val posts by viewModel.posts.collectAsState()

    if (posts.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(posts) { post ->
                PostCard(post)
            }
        }
    }
}

@Composable
fun PostCard(post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = PurpleGrey40)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Post #${post.id} - ${post.title}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = post.body, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
