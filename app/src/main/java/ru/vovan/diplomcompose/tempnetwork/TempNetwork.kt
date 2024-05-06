package ru.vovan.diplomcompose.tempnetwork


/*
@Composable
fun Screen(modifier: Modifier = Modifier, postViewModel: PostViewModel = koinViewModel()){
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
}*/
