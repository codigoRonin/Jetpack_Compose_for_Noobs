package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    var sliderPosition by rememberSaveable { mutableFloatStateOf(0f) }
    var sliderFinishedPosition by rememberSaveable { mutableStateOf("") }
    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            enabled = true,
            valueRange = 0f..10f,
            steps = 9,  // Siempre hay que restar 2 en este caso el 0 y el 10
            onValueChangeFinished = { sliderFinishedPosition = sliderPosition.toString() }
        )
        Text(text = sliderFinishedPosition)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(1f..9f) }
    Column(Modifier.padding(24.dp)) {
        RangeSlider(
            value = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = "Valor inferior ${currentRange.start.toString()}")
        Text(text = "Valor Superior ${currentRange.endInclusive.toString()}")
    }

}