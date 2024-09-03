package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayUI()
                }
            }
        }
    }
}

@Composable
fun DisplayUI(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().fillMaxHeight()
    )  {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit

        )
        TastTexts(tMessage = stringResource(R.string.tasks_completed_text),
                  pMessage = stringResource(R.string.nice_work_text)
        )
    }
}

@Composable
fun TastTexts(tMessage: String, pMessage: String , modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = tMessage,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold

            )

        Text(
            text = pMessage,
            fontSize = 16.sp,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayUIPreview() {
    TaskManagerTheme {
        DisplayUI()
    }
}