package com.jetpack.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.movieapp.navigation.MovieNavigation
import com.jetpack.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootContent {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun RootContent(content: @Composable () -> Unit) {
    MovieAppTheme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RootContent {
        MovieNavigation()
    }
}