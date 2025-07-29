package com.example.jetpackcomposecourse.bcoreComponents


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp




@Composable
fun SimpleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello JetPack",
            style = TextStyle(
                color = Color.Blue,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                shadow= Shadow(color=Color.Black, blurRadius = 20f)//blurRadius ki kitna glow hai

            )
        )
    }
}
@Composable
fun ColorFullText() {
    val color = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Cyan,
        Color.Magenta,
        Color.Yellow
    )
    Box(  modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
    Text(text=buildAnnotatedString{
        append("Do not allow people\n")
        withStyle(
            SpanStyle(
                brush= Brush.linearGradient(colors=color)
            )
        ){
            append("Beacuse they are blind")
        }
        append("\n tell them to put some")
    })
}}

@Composable
fun ScrollableText(){// marquee bhi bolte hai  animated text
    Box(
        modifier=Modifier.fillMaxSize(),
            contentAlignment=Alignment.Center
    ){
       Text(text="hey this is alex, and what about you brother".repeat(20),
           maxLines = 2,
         //  modifier = Modifier.basicMarquee(), // for roll side by side
           fontSize =  80.sp,
         overflow = TextOverflow.Ellipsis//.... hai vo indicate karta hai
           )
    }

}






@Preview(showSystemUi = true)
@Composable
fun prev(){
    //SimpleText()
   // ColorFullText()
    ScrollableText()
}