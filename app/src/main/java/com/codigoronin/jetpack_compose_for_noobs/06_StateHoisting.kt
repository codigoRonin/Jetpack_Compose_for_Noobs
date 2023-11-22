@file:OptIn(ExperimentalMaterial3Api::class)

package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

// State Hoisting es un patrón para quitar estados de los composables,
// consiguiendo sacar el estado en un elemento superior.

@Composable
fun MainComposable() {
    var myText by rememberSaveable { mutableStateOf("") }
    MyTextfieldStateHoisting(myText) { myText = it }
}

@Composable
fun MyTextfieldStateHoisting(text: String, onValueChanged: (String) -> Unit) {
    TextField(value = text, onValueChange = { onValueChanged(it) })
}
