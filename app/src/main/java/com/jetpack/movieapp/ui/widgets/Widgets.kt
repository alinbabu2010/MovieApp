package com.jetpack.movieapp.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jetpack.movieapp.R
import com.jetpack.movieapp.models.Movie
import com.jetpack.movieapp.models.getMovies

@Composable
fun MovieRow(movie: Movie, onItemClicked: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Box(Modifier.clickable {
            onItemClicked(movie.id)
        }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Surface(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp),
                    shape = CircleShape,
                    elevation = 8.dp
                ) {
//                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(movie.images[0])
                            .crossfade(true)
                            .build(),
                        placeholder = rememberVectorPainter(Icons.Default.AccountBox),
                        contentDescription = stringResource(R.string.poster_description),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Column(Modifier.padding(4.dp)) {
                    Text(text = movie.title, style = MaterialTheme.typography.h5)
                    Text(
                        text = stringResource(R.string.movie_director, movie.director),
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = stringResource(R.string.movie_rating, movie.rating),
                        style = MaterialTheme.typography.caption
                    )
                    Text(
                        text = stringResource(R.string.movie_year, movie.year),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}