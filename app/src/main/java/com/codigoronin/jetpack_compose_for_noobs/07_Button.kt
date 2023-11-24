package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyButtonExample1() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Cyan,
                containerColor = Color.Red
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Mi Botón", fontSize = 24.sp)
        }
    }
}

@Composable
fun MyButtonExample2() {
    var activated by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Button(
            onClick = { activated = false },
            enabled = activated,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Cyan,
                containerColor = Color.Red,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Magenta
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Mi Botón", fontSize = 24.sp)
        }
    }
}

@Composable
fun MyOutlinedButton() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {

        OutlinedButton(
            onClick = { /*TODO*/ },
            enabled = true,
            //      colors = ButtonDefaults.outlinedButtonColors(
            //          contentColor = Color.White,
            //          containerColor = Color.Gray
            //     )
        )
        {
            Text(text = "My Outlined")
        }
    }
}

@Composable
fun MyTextButton() {

    // Realmente es el mismo botón porque dentro podriamos colocar cualquier cosa no solo un
    // Text, pero eso si, no tendría borde. Además también podríamos hacer que el Text tuviera el
    // Modifier.clickable y obtendriamos lo mismo.

    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text("Pulsame")
        }
    }
}