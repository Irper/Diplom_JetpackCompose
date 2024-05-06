package ru.vovan.diplomcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun StuffScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NumberOfAudience(modifier = Modifier
            .padding(top = 10.dp)
            .align(Alignment.CenterHorizontally)
        )
        Text(text = stringResource(id = R.string.lorem_impum_long),
            fontSize = 30.sp,
            lineHeight = 30.sp,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
        AudiencePhotos(modifier = Modifier.padding(top = 10.dp, bottom = 20.dp))
    }
}

@Composable
fun AudiencePhotos(modifier: Modifier){
    val colors = listOf(
        Color.Black,
        Color.Green,
        Color.Magenta,
        Color.Yellow,
        Color.Blue,
        Color.Cyan,
        Color.Red
    )

    LazyRow (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 30.dp, end = 30.dp)
        ) {
        items(colors){
            item ->
            Box(modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .background(color = item)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StuffScreenPreview() {
    DiplomComposeTheme {
        StuffScreen()
    }
}