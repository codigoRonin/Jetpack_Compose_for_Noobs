package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = Color.Red,
            strokeWidth = 8.dp
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 24.dp),
            color = Color.Blue,
            trackColor = Color.Green
        )
    }
}

@Composable
fun MyProgressBarExample() {
    var showLoadind by rememberSaveable() {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoadind) {
            LinearProgressIndicator(
                Modifier.padding(top = 24.dp, bottom = 24.dp),
                color = Color.Red,
                trackColor = Color.Gray
            )
        }
        Button(onClick = { showLoadind = !showLoadind }) {
            Text(text = "Download File")
        }

    }
}

@Composable
fun MyAdvanceProgressBar() {

    var progressStatus by rememberSaveable { mutableFloatStateOf(0f) }
    var stateIncrease by rememberSaveable { mutableStateOf(true) }
    var stateDecrease by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progressStatus)
        Row(Modifier.padding(24.dp)) {
            Button(
                enabled = stateIncrease,
                onClick = {
                    if (progressStatus < 1f) progressStatus += 0.1f else stateIncrease = false
                },
                modifier = Modifier.padding(24.dp, 0.dp),

                ) {
                Text(text = "Increase")
            }
            Button(
                enabled = stateDecrease,
                onClick = {
                    if (progressStatus > 0f) progressStatus -= 0.1f else stateDecrease = false
                },
                modifier = Modifier.padding(24.dp, 0.dp)
            ) {
                Text(text = "Decrease")
            }
        }
    }
}