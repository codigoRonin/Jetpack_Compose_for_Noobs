package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ejemplo del Componente Text")
        Text("Ejemplo del Componente Text", color = Color.Red)
        Text("Ejemplo del Componente Text", fontWeight = FontWeight.Bold)
        Text("Ejemplo del Componente Text", fontWeight = FontWeight.Light)
        Text("Ejemplo del Componente Text", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            "Ejemplo del Componente Text",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            "Ejemplo del Componente Text",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            "Ejemplo del Componente Text", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        // Si no queremos crear un style y solo queremos acceder a uno de los estilos podemos obviar
        // TextStyle,directamente FontFamily, TextDecoration, etc..
        Text("Ejemplo del Componente Text", fontFamily = FontFamily.Monospace)
        Text("Ejemplo del Componente Text", fontSize = 16.sp)

    }

}

@Preview(name = "Ejemplos con el componente Text", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewText() {
    MyText()
}