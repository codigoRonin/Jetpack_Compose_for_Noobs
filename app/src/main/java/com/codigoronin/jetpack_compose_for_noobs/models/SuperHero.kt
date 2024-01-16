package com.codigoronin.jetpack_compose_for_noobs.models

import androidx.annotation.DrawableRes

data class SuperHero(
    var superHeroName:String,
    var realName:String,
    var publisher:String,
    @DrawableRes var photo:Int
)
