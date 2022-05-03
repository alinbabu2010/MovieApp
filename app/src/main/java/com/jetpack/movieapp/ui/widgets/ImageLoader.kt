package com.jetpack.movieapp.ui.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jetpack.movieapp.R


@Composable
fun PosterImageLoader(poster: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(poster)
            .crossfade(true)
            .build(),
        placeholder = rememberVectorPainter(Icons.Default.AccountBox),
        contentDescription = stringResource(R.string.poster_description),
        contentScale = ContentScale.FillBounds
    )
}