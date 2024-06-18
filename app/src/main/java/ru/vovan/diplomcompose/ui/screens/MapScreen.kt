package ru.vovan.diplomcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import ru.vovan.diplomcompose.ui.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun MapScreen(){
    val dvgupsLocation = LatLng(48.49394759217753, 135.06185639926318)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(dvgupsLocation, 18f)
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = LatLng(48.49423554597536, 135.06082643106407)),
                title = "ДВГУПС",
                snippet = "Аудитория 3430"
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    DiplomComposeTheme {
        MapScreen()
    }
}