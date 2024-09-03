package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        LemonadeImage(
            modifier = Modifier
                .fillMaxSize()
        )

    }
}

@Composable
fun HeaderText(modifier: Modifier = Modifier){
    Surface(
        color = Color.Yellow
    ) {
        Text(
            text = "Lemonade",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LemonadeImage(modifier: Modifier = Modifier) {

    var imageIndex by remember { mutableStateOf(0) }

    val images = listOf(
        painterResource(R.drawable.lemon_tree),
        painterResource(R.drawable.lemon_squeeze),
        painterResource(R.drawable.lemon_drink),
        painterResource(R.drawable.lemon_restart)
    )

    Image(
        painter = images[imageIndex],
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxSize()
            .clickable {
            imageIndex = (imageIndex + 1) % images.size

        }
    )

}