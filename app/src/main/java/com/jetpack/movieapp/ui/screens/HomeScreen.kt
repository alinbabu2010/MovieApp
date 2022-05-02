package com.jetpack.movieapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.movieapp.models.Movie
import com.jetpack.movieapp.models.getMovies
import com.jetpack.movieapp.ui.navigation.MovieScreens
import com.jetpack.movieapp.ui.widgets.MovieRow

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

@Composable
fun MainContent(navController: NavController, movieList: List<Movie> = getMovies(LocalContext.current)) {
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