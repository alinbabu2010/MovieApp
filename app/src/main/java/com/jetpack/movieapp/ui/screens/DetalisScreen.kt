package com.jetpack.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {

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
                    text = movieData.toString(),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }


        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = movieData.toString(), style = MaterialTheme.typography.h5)
            }
        }

    }

}