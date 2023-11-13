package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter

        ) {
            Text(
                "Ejemplo 1 muyyyyy largo para que no quepa en la caja  " +
                        "Ejemplo 1 muyyyyy largo para que no quepa en la caja"
            )

        }
    }
}

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Hola Ejemplo 1")
        Text("Hola Ejemplo 2")
        Text("Hola Ejemplo 3")
        Text("Hola Ejemplo 1")
        Text("Hola Ejemplo 2")
        Text("Hola Ejemplo 3")
    }
}

@Composable
fun MyColumn() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Hola Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .weight(1f)
           .height(100.dp)
        )
        Text(
            text = "Hola Ejemplo 2", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .weight(2f)
            //    .height(100.dp)
        )
        Text(
            text = "Hola Ejemplo 3", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
               .weight(1f)
             //   .height(100.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyPreviewLayouts() {
    // MyBox()
    // MyRow()
    MyColumn()
}
