package com.codigoronin.jetpack_compose_for_noobs.models

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)