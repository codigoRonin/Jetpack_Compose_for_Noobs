package com.codigoronin.jetpack_compose_for_noobs

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MySpacer() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Texto Ejemlo 1")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Texto Ejemlo 2")
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Text("Texto Ejemlo 3")
            Spacer(modifier = Modifier.width(32.dp))
            Text("Texto Ejemlo 4")
        }
    }
}

@Composable
fun MyDivider() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Texto Ejemlo 1")
        Divider(
            thickness = 1.dp,
            color = Color.Black
        )
        Text("Texto Ejemlo2")
        Divider(
            modifier = Modifier
                .height(1.dp),
            color = Color.Red
        )
        Text("Texto Ejemlo3")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        BadgedBox(
            modifier = Modifier.padding(16.dp),
            badge = {
                Badge(contentColor = Color.Green, containerColor = Color.Yellow) {
                    Text(text = "150")
                }
            },
            content = {
                Icon(
                    imageVector = Icons.Default.HeartBroken, contentDescription = "Corazón",
                    tint = Color.Red,
                    modifier = Modifier.size(96.dp)
                )
            }
        )
    }
}

@Composable
fun MyDropDownMenu() {

    val context = LocalContext.current
    var expanded by rememberSaveable { mutableStateOf(false) }
    val languages = listOf("C", "C++", "Java", "Kotlin", "Swift", "Python")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .wrapContentSize(Alignment.TopEnd)
    ) {

        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },

            ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    text = { Text(text = language) },
                    onClick = {
                        expanded = false
                        Toast.makeText(context, language, Toast.LENGTH_LONG).show()
                    })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenuBox() {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }
    // var selectedText by remember { mutableStateOf("Starbucks Cafe") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = {/* No permitimos cambios desde el TextField */ },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEach { coffee ->
                    DropdownMenuItem(
                        text = { Text(text = coffee) },
                        onClick = {
                            selectedText = coffee
                            expanded = false
                            Toast.makeText(context, coffee, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(10.dp, Color.Yellow),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green,
            contentColor = Color.Red
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 1")
        }

    }
}
