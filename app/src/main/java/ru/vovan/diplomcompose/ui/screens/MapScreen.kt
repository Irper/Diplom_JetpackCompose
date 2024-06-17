package ru.vovan.diplomcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun MapScreen(){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.map),
            contentDescription = "map",
            modifier = Modifier
        )
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    DiplomComposeTheme {
        MapScreen()
    }
}