package ru.vovan.diplomcompose.tempnetwork

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.network.Post
import org.koin.androidx.compose.koinViewModel
import ru.vovan.diplomcompose.viewmodel.PostViewModel


@Composable
fun TempScreen(modifier: Modifier = Modifier, postViewModel: PostViewModel = koinViewModel()){
    val posts by postViewModel.getAllPosts().collectAsState(initial = emptyList())
    ListPost(listPost = posts)
}

@Composable
fun ListPost(modifier: Modifier = Modifier, listPost: List<Post>) {
    LazyColumn {
        items(listPost) {
            PostCard(modifier = Modifier, title = it.title, completed = it.completed)
        }
    }
}

@Composable
fun PostCard(
    modifier: Modifier,
    title: String,
    completed: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(title)
        Icon(
            imageVector = if (completed) Icons.Filled.Check else Icons.Filled.Create,
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostCard(modifier: Modifier = Modifier) {
    PostCard(modifier = modifier, title = "example example example", completed = false)
}
