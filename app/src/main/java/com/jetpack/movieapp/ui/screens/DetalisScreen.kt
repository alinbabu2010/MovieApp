package com.jetpack.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.movieapp.R
import com.jetpack.movieapp.models.getMovies
import com.jetpack.movieapp.ui.widgets.HorizontalScrollableImageView
import com.jetpack.movieapp.ui.widgets.MovieRow


@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {

    val movie = getMovies(LocalContext.current).first { it.id == movieId }

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Cyan,
            elevation = 5.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Arrow")
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = movie.title,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }


        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieRow(movie = movie)
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = stringResource(R.string.movie_images))
                HorizontalScrollableImageView(movie.images)
            }
        }

    }

}