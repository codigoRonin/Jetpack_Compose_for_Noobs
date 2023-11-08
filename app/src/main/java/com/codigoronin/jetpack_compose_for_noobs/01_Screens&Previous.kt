package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HelloWord(name: String) {
    Text("Hola Mundo, bienvenido $name")
}

@Preview(name = "Vista Simple", showBackground = true)
@Composable
fun MyPreview() {
    HelloWord(name = "Paco")
}

@Preview(
    name = "Vista ampliada",
    showBackground = true,
    showSystemUi = true,
    heightDp = 200,
    widthDp = 200,
    // locale= ,
    apiLevel = 34,
    backgroundColor = 1111111,
    device = Devices.NEXUS_10
)
@Composable
fun MyExtendedPreview() {
    HelloWord(name = "Lucia")
}

/*
* La única limitación de las previews es que el componente de dentro no puede recibir parámetros.
* Solución -> crear un método fake por encima.
*/

// MODIFICADORES

@Composable
fun HelloWordWithModifier(name: String) {
    Text(
        text = "Hola Mundo, bienvenido $name",
       // modifier = Modifier.padding(start = 56.dp, end = 10.dp, top = 16.dp, bottom = 6.dp)
      //  modifier = Modifier.padding(horizontal = 32.dp)
          modifier = Modifier.padding(vertical = 32.dp)
              .clickable {  }
    )
}

@Preview(name = "Modificadores", showSystemUi = true)
@Composable
fun MyPreviewWithModifier() {
    HelloWordWithModifier(name = "Paco")
}
