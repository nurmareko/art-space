package com.example.artspace

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkWall()

        Spacer(Modifier.height(20.dp))

        ArtworkDescriptor()

        Spacer(Modifier.height(20.dp))

        DisplayController()
    }
}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
            .width(300.dp)
            .aspectRatio(3f / 4f),
        color = Color(0xFFFFC570)
    ) {
        Text("An image")
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .width(300.dp)
            .aspectRatio(4f),
        color = Color(0xFFEFD2B0)
    ) {
        Column {
            Text("Artwork Title")
            Text("Artwork Artist Year")
        }
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .width(300.dp)
            .aspectRatio(4f),
        color = Color(0xFF547792)
    ) {
        Text("button button button")
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}