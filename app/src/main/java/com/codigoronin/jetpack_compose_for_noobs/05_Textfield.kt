@file:OptIn(ExperimentalMaterial3Api::class)

package com.codigoronin.jetpack_compose_for_noobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextfield() {

    var myText by rememberSaveable { mutableStateOf("hola") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = myText, onValueChange = { myText = it })
    }
}

@Composable
fun MyAdvanceTextfield() {

    var myText by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = myText,
            onValueChange = {
                myText =
                    if (it.contains("a"))
                        it.replace("a", "@")
                    else
                        it
            },
            label = { Text("Nombre") },

            placeholder = { Text(text = "Introduce tu nombre") }

        )
    }
}

@Composable
fun MyTextfieldOutlined() {
    var myText by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            label = { Text("Introduce tu nombre") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Red,
                focusedLabelColor = Color.Cyan
            )
        )
    }
}


@Composable
fun MyAdvanceTextfieldOutlined() {
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Localized description"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Send
            ),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            maxLines = 1
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyPreviewTextfield() {
    MyTextfield()
}
