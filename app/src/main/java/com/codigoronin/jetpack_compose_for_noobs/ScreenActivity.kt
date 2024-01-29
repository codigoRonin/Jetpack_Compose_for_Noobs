package com.codigoronin.jetpack_compose_for_noobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codigoronin.jetpack_compose_for_noobs.models.Routes
import com.codigoronin.jetpack_compose_for_noobs.ui.theme.Jetpack_Compose_for_NoobsTheme

class ScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_Compose_for_NoobsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //BASIC
                    /*
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = "Pantalla 1") {
                        composable("Pantalla 1") { Screen1(navigationController) }
                        composable("Pantalla 2") { Screen2(navigationController) }
                        composable("Pantalla 3") { Screen3(navigationController) }
                }
                */

                    //PRO
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.routes
                    ) {
                        composable(Routes.Pantalla1.routes) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.routes) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.routes) { Screen3(navigationController) }
                        // Pasar argumentos obligatorios de manera básica
                        composable("Pantalla4/{name}") { backStackEntry -> //backStackEntry es el nombre que se suele dar pero lo llamo como me da la gana
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                        // Pasar argumentos obligatorios que no sean String de manera básica
                        composable("Pantalla5/{age}", arguments = listOf(navArgument("age") {
                            type =
                                NavType.IntType
                        })) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                    }
            }
        }
    }
}}

