package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.dev_d2py_uhxjqo_unsplash),
        contentDescription = "Descripción de la imagen -> importante para invidentes y testing",
        alpha = 0.5f
    )
}

@Composable
fun MyAdvanceImage() {

    Image(
        painter = painterResource(id = R.drawable.dev_d2py_uhxjqo_unsplash),
        contentDescription = "Comics",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyIcon() {

    // Icon es parte de Material Design por lo que por defecto los va a pintar de 24dp x 24dp
    // ademas contiene un objeto de tipo localContentColor  para tintar las imagenes de una forma
    // más sencilla.

    Column() {
        Icon(
            imageVector = Icons.Rounded.ShoppingCart,
            contentDescription = "Carrito de la compra",
            tint = Color.Red,
            modifier = Modifier.size(96.dp)
        )
    }

    // En material design vemos en su web que aparecen muchos más iconos, si queremos tener acceso
    // a ellos tendremos que añadir una libreria (es bastante pesada)
    // "androidx.compose.material:material-icons-extended:$compose_ui_version" -> actualmente 1.5.4
}