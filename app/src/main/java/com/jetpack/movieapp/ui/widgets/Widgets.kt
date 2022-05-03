package com.jetpack.movieapp.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jetpack.movieapp.R
import com.jetpack.movieapp.models.Movie
import com.jetpack.movieapp.models.getMovies

@Preview
@Composable
fun MovieRow(
    movie: Movie = getMovies(LocalContext.current)[0],
    onItemClicked: (String) -> Unit = {}
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        //.height(130.dp),
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
                        text = stringResource(R.string.movie_year, movie.year),
                        style = MaterialTheme.typography.caption
                    )
                    AnimatedVisibility(visible = expanded) {
                        Column {
                            // Span text creation in compose
                            Text(buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append(movie.plot)
                                }
                            })
                        }
                    }
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = stringResource(R.string.down_arrow),
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { expanded = !expanded },
                        tint = Color.DarkGray
                    )
                }
            }
        }
    }
}