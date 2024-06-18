package ru.vovan.diplomcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import ru.vovan.diplomcompose.ui.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.listMapPoint
import ru.vovan.diplomcompose.ui.model.CurrentAudienceObject

@Composable
fun MapScreen(){
    var dvgupsLocation by rememberSaveable { mutableStateOf(LatLng(0.0, 0.0)) }
    //var dvgupsLocation = LatLng(0.0, 0.0)

    listMapPoint.forEach {
        if (it.audName == CurrentAudienceObject.currentAudience) dvgupsLocation = it.point
    }
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
                state = MarkerState(position = dvgupsLocation),
                title = "ДВГУПС",
                snippet = "Аудитория " + CurrentAudienceObject.currentAudience
            )

        }
    }
}
