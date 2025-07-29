package com.example.jetpackcomposecourse.c_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Modifiers

//Modifiers are availabele in all  the composables like text,button,image,column,row
// we can  modifier in every componenet cconstructer
@Composable
fun ModifierExample(){
       Box(
           modifier = Modifier
               .fillMaxSize() // fills entire screen
               .wrapContentSize(Alignment.Center) // centers the Box content
               .size(200.dp) // actual size of the Box
               .background(Color.Magenta),
           contentAlignment = Alignment.Center
       ){
           Text("hellolkkoo",
               maxLines=1,
               modifier = Modifier.size(100.dp))
       }
}
@Preview(showSystemUi = true)
@Composable
fun prev(){
    ModifierExample()
}