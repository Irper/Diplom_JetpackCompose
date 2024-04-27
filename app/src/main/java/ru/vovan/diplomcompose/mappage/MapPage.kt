package ru.vovan.diplomcompose.mappage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.Menu
import ru.vovan.diplomcompose.NumberOfAudience
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun MapPage(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
        ) {
        NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
        Image(painter = painterResource(id = R.drawable.stub_map_3d), contentDescription = "map")
        Menu(modifier = Modifier.padding(bottom = 40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MapPagePreview() {
    DiplomComposeTheme {
        MapPage()
    }
}