package com.codigoronin.jetpack_compose_for_noobs.models

sealed class Routes (val routes: String){
    object Pantalla1 : Routes("Pantalla 1")
    object Pantalla2 : Routes("Pantalla 2")
    object Pantalla3 : Routes("Pantalla 3")

}