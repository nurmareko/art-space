package com.example.artspace

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            .aspectRatio(3f / 4f)
            .shadow(4.dp),
        color = Color.White
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp),
            painter = painterResource(R.drawable.frieren_silly_face),
            contentDescription = "friren silly face",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .width(300.dp)
            .aspectRatio(3f),
        color = Color(0xFFEFD2B0),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Artwork Title",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Artwork Artist (Year)",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .width(300.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF547792),
                    contentColor = Color.White
                )
            ) {
                Text("Previous")
            }

            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF547792),
                    contentColor = Color.White
                )
            ) {
                Text("Next")
            }

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