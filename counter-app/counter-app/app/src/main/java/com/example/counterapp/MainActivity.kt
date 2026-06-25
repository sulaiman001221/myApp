package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterScreen()
        }
    }
}

@Composable
fun CounterScreen() {
    // This is the "state" — it remembers the count value
    var count by remember { mutableStateOf(0) }

    // The full screen background
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xfff4f7fa)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Title
            Text(
                text = "Counter",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff1a1c1e)
                )
            )

            Spacer(modifier = Modifier.height(48.dp))

            // The big number display
            Text(
                text = "$count",
                style = TextStyle(
                    fontSize = 96.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff5170ff)
                )
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Increment and Decrement buttons side by side
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Decrease button
                Button(
                    onClick = { count-- },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffff5151)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(130.dp)
                        .height(56.dp)
                ) {
                    Text(
                        text = "− Decrease",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    )
                }

                // Increase button
                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff5170ff)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(130.dp)
                        .height(56.dp)
                ) {
                    Text(
                        text = "+ Increase",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Reset button
            TextButton(onClick = { count = 0 }) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color(0xff787b86)
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 917)
@Composable
fun CounterPreview() {
    CounterScreen()
}
