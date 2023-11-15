package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// La vista se modifica mediante órdenes (normalmente). Los States son estados a los cuales no
// enganchamos de algún modo y cuando se modifiquen automáticamente se actualizarán nuestras vistas.

// Recomposición
// Cuando un texto se modifica el componente no se actualiza sino que se recompone, esto significa
// que se vuelve a crearse de nuevo. La ventaja de esto es que siempre voy a tener la última versión
// de mi componente y de esta forma evitaremos errores en la UI.

@Composable
fun MyStateExample1() {

    var counter = 0
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text("Se ha pulsado el botón $counter veces")
    }

}

@Composable
fun MyStateExample2() {

    val counter = remember { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Pulsar")
        }
        Text("Se ha pulsado el botón ${counter.value} veces")
    }

}

@Composable
fun MyStateExample3() {

    val counter = rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Pulsar")
        }
        Text("Se ha pulsado el botón ${counter.value} veces")
    }

}

// Para no tener que usuar continuamente el .value podemos usar "by" en cuenta del "="
// import androidx.compose.runtime.getValue
// import androidx.compose.runtime.setValue
@Composable
fun MyStateExample4() {

    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text("Se ha pulsado el botón ${counter} veces")
    }

}
@Preview(showSystemUi = true)
@Composable

fun MyStatesPreview() {
    MyStateExample1()
}