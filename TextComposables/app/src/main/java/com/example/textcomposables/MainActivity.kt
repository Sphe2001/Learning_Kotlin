package com.example.textcomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textcomposables.ui.theme.TextComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextComposablesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableTextScreen()
                }
            }
        }
    }
}

@Composable
fun ComposableTexts(title: String, message: String, backgroundC: Color, modifier: Modifier = Modifier) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(backgroundC)
                .padding(16.dp)

            ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = message,
                textAlign = TextAlign.Justify,

                )
        }

}

@Composable
fun ComposableTextScreen() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableTexts(
                title = stringResource(R.string.first_title),
                message = stringResource(R.string.first_message),
                backgroundC = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableTexts(
                title = stringResource(R.string.second_title),
                message = stringResource(R.string.second_message),
                backgroundC = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableTexts(
                title = stringResource(R.string.third_title),
                message = stringResource(R.string.third_message),
                backgroundC = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f),
                
            )
            ComposableTexts(
                title = stringResource(R.string.forth_title),
                message = stringResource(R.string.forth_message),
                backgroundC = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableTextScreenPreview() {
    TextComposablesTheme {
        ComposableTextScreen()
    }
}