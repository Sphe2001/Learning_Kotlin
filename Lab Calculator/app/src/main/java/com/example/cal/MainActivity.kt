package com.example.cal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cal.ui.theme.CalTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LabEq("10-140")
                }
            }
        }
    }
}

@Composable
fun LabEq(labName: String, modifier: Modifier = Modifier) {
    var computers by remember { mutableStateOf("") }
    var screens by remember { mutableStateOf("") }
    var keyboards by remember { mutableStateOf("") }
    var totalValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = computers,
            onValueChange = { computers = it },
            label = { Text("Number of Computers") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = screens,
            onValueChange = { screens = it },
            label = { Text("Number of Screens") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = keyboards,
            onValueChange = { keyboards = it },
            label = { Text("Number of Keyboards") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                val computersValue = (computers.toIntOrNull() ?: 0) * 5000
                val screensValue = (screens.toIntOrNull() ?: 0) * 2000
                val keyboardsValue = (keyboards.toIntOrNull() ?: 0) * 200
                val total = computersValue + screensValue + keyboardsValue
                totalValue = "Total Value for $labName: R$total"
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Calculate Total Value")
        }
        Text(
            text = totalValue,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalTheme {
        LabEq("10-140")
    }
}