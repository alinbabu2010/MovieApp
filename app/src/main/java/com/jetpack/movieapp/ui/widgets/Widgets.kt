package com.jetpack.movieapp.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.jetpack.movieapp.models.Movie

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
                    shape = RectangleShape,
                    elevation = 4.dp
                ) {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")
                }
                Text(text = movie.title)
            }
        }
    }
}