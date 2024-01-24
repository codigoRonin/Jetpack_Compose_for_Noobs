package com.codigoronin.jetpack_compose_for_noobs

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codigoronin.jetpack_compose_for_noobs.models.SuperHero
import kotlinx.coroutines.launch


@Composable

fun MyLazyColumns(){

    // MyLazyColumnsExample1()
    // MyLazyColumnsExample2()
   //  SuperHeroHorizontalView()
    // SuperHeroVerticallView()
    //  SuperHeroGridView()
    // SuperHeroSpecialControlView()
     SuperHeroVerticalStickylView()
}
@Composable
fun MyLazyColumnsExample1() {

    LazyColumn {
        // Los LazyColumns solo reciben items
        item() { Text(text = "Ejemplo 1") }
        items(7) {
            Text(text = "Este es el ejemplo $it")
        }
    }
}

@Composable
fun MyLazyColumnsExample2() {
    var myList = listOf("Michel", "Juana", "Silvia", "Lucia")

    LazyColumn {
        // Lo normal es que los datos lleguen en un listado,además podriamos tener
        // un header y un footer ya que se crea en orden
        item { Text(text = "HEADER") }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "FOOTER") }

    }

}

@Composable
fun SuperHeroHorizontalView() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) { // Espacio entre los items
        items(getSuperHeroes()) {
            ItemSuperHero(superHero = it)
        }
    }
}


@Composable
fun ItemSuperHero(superHero: SuperHero) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.width(200.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "Photo SuperHero",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp,

                )
        }

    }

}

fun getSuperHeroes(): List<SuperHero> {

    return listOf(
        SuperHero("Siperman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverin", "James Howlet", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}

@Composable
fun SuperHeroVerticallView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) { // Espacio entre los items
        items(getSuperHeroes()) {superHero ->
            ItemSuperHeroClickable(superHero = superHero) {
                Log.i("Michel", it.superHeroName)
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }

}
@Composable
fun ItemSuperHeroClickable(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .fillMaxWidth()
            .clickable { onItemSelected(superHero) },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "Photo SuperHero",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp,

                )
        }

    }

}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        content = {
            // Disponemos de GridCell.Adaptative(100.dp) para que se adapte con al menos un tamaño minimo
            // en este caso de 100dp
            items(getSuperHeroes()) {
                ItemSuperHeroClickable(superHero = it) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        })
}

@Composable
fun SuperHeroSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()

    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f),
            state = rvState
        ) { // Espacio entre los items
            items(getSuperHeroes()) {
                ItemSuperHeroClickable(superHero = it) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(
                onClick = {
                    coroutinesScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(text = "Soy un Boton Fijo")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroVerticalStickylView() {
    val context = LocalContext.current
    val superHero: Map<String, List<SuperHero>> = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) { // Espacio entre los items
        superHero.forEach { (publisher, mySuperHero) ->
            stickyHeader {
                Text(
                    text = publisher,
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Black).padding(8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }
            items(mySuperHero) {
                ItemSuperHeroClickable(superHero = it) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}

