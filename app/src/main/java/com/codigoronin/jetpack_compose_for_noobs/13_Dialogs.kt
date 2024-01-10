package com.codigoronin.jetpack_compose_for_noobs

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialogs() {
   // MySimpleDialogExample()
    MyAlertDialogExample()
}

@Composable
fun MySimpleDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            //Aqui pondriamos la vista
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(text = "Mensaje del diálogo")
            }
        }
    }
}

@Composable
fun MySimpleDialogExample() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostar Diálogo Simple")
        }
        MySimpleDialog(show = show, onDismiss = { show = false })
    }
}

@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() }, // Accion cuando el usuario pulse fuera
            title = { Text(text = "Mi Título") },
            text = { Text(text = " Esta es la descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            })
    }
}

@Composable
fun MyAlertDialogExample() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostar Diálogo de Alerta")
        }
        MyAlertDialog(show = show,
            onDismiss = { show = false },
            onConfirm = { Log.i("Michel", "Se ha pulsado acceptar") })
    }

}
