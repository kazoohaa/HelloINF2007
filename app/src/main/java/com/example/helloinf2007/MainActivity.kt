package com.example.helloinf2007

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloinf2007.ui.theme.HelloINF2007Theme
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ThreeTenABP
        AndroidThreeTen.init(this)

        // Get the current date and time
        val currentDateTime = LocalDateTime.now()

        // Define a custom date and time format
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        // Format the current date and time using the formatter
        val formattedDateTime = currentDateTime.format(formatter)

        Log.d("MainActivity", "OnCreate function is created at $formattedDateTime")
        setContent {
            HelloINF2007Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("INF2007")
                        From("Elon Musk")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun From(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "From $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloINF2007Theme {
        Greeting("INF2007")
        From("Elon Musk")
    }
}