package com.example.jetpackcomposecourse.bcoreComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R

@Composable
fun Imagesample(){
    val context = LocalContext.current
    val colors = remember {
        Brush.sweepGradient(
        listOf(
            Color.Red,
            Color.Cyan,
            Color.Red,
            Color.Green,
            Color.Yellow,

        )
        )}
        val borderWidth = 5.dp

    Image(
        painter= painterResource(id= R.drawable.under),
        contentDescription = "An illustrative image",
        contentScale = ContentScale.Crop,// agar ye size bada hota hai to ye crop karega
        modifier= Modifier.size(250.dp).border(
            width = borderWidth,
            brush = colors,//color=Color.Blue
            shape = CircleShape
        )
            .clip(CircleShape),// ye image ko round karega koi bhi shape de skte hai
        alignment = Alignment.Center,
        colorFilter =   ColorFilter.colorMatrix(ColorMatrix().apply {//filter hai image ke liye
            setToSaturation(0f)
        })
    )

}
@Preview(showSystemUi = true)
@Composable
fun ImagePreview(){
    Imagesample()
}