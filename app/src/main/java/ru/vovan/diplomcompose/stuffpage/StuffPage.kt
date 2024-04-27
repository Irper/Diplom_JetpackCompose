package ru.vovan.diplomcompose.stuffpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.Menu
import ru.vovan.diplomcompose.NumberOfAudience
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun StuffPage(){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
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
        Menu(modifier = Modifier
            .padding(bottom = 40.dp)
            .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StuffPagePreview() {
    DiplomComposeTheme {
        StuffPage()
    }
}