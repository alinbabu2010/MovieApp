package com.jetpack.movieapp.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.movieapp.ui.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Cyan,
            elevation = 5.dp
        ) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController)
    }
}


val moviesList = listOf(
    "Avatar",
    "KGF",
    "300",
    "Avengers",
    "Ruroni Kenshin"
)

@Composable
fun MainContent(navController: NavController, movieList: List<String> = moviesList) {
    Column(
        modifier = Modifier.padding(start = 12.dp, end = 12.dp)
    ) {
        LazyColumn(Modifier.padding(top = 4.dp)) {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}


@Composable
fun MovieRow(movie: String, onItemClicked: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Box(Modifier.clickable {
            onItemClicked(movie)
        }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Surface(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp),
                    shape = RectangleShape,
                    elevation = 4.dp
                ) {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")
                }
                Text(text = movie)
            }
        }
    }
}