package com.jetpack.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootContent {
               MainContent()
            }
        }
    }
}

@Composable
fun RootContent(content: @Composable () -> Unit){
    MovieAppTheme() {
        content()
    }
}

@Composable
fun MainContent(){
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Hello")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RootContent{
        MainContent()
    }
}