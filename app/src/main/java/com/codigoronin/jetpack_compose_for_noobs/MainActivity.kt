package com.codigoronin.jetpack_compose_for_noobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.codigoronin.jetpack_compose_for_noobs.ui.theme.Jetpack_Compose_for_NoobsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_Compose_for_NoobsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //  HelloWord(name = "Michel")
                    MyCard()

                }
            }
        }
    }
}

/*
* JetpackCompose
* **************
* Nuevo kit para desarrollar vistas nativas desde Android
* Problema xml -> entenderlo y transformalo -> tiempos de compilacion más largos
* Todas las cosas se programan en kotlin -> vista y logica ->  quita mucho código
* Pasamos de paradigma Imperativo cambia a declarativo
*
*/
