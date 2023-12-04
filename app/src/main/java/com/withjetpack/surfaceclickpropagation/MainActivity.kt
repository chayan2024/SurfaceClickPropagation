package com.withjetpack.surfaceclickpropagation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withjetpack.surfaceclickpropagation.ui.theme.SurfaceClickPropagationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceClickPropagationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SurfaceClickPropagation()
                }
            }
        }
    }
}

@Composable
fun SurfaceClickPropagation() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)) {
        Text(text = "SurfaceClickPropagation", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
        var context= LocalContext.current
        Box(modifier = Modifier.fillMaxWidth().wrapContentSize()) {

            Surface(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp),
                color = (Color(0xFFFDD835)),
                modifier = Modifier
                    .size(150.dp)
                    .padding(12.dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Surface(Left) inside Box is clicked!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    })
            ) {

                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(80.dp)
                        .offset(x = 50.dp, y = (-40).dp)
                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Surface inside Surface is clicked!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }),
                    elevation = 12.dp,
                    color = (Color(0xFF26C6DA))
                ) {}
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SurfaceClickPropagationTheme {
        SurfaceClickPropagation()
    }
}