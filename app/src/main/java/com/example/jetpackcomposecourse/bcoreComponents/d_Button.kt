package com.example.jetpackcomposecourse.bcoreComponents

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

//  why we use diffrent button  beacuse in big appp we want all the summit button looks same and add to cart summit and if chnage one layout it chnage all the buuton but we want diffrent theme for diffrent button

// Filled Button  summit or save ke iye used hota hai

@Composable
fun FilledButtonSample(){

    val context= LocalContext.current// activty ke traha ismei context use nhi hota isliye ye use karte hai
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
    Button(
        onClick = {
            Toast.makeText(context,"hello toast",Toast.LENGTH_SHORT).show()
        }
    ){
        Text("Filled Button")
    }
}}

//Tonal Button -> ADD to cart or wishlist ke liye used hota hai
@Composable
fun TonallButtonSample() {
     val context= LocalContext.current
    Box(
        modifier=Modifier.fillMaxSize(),
        contentAlignment=Alignment.Center

    ){
        FilledTonalButton(
            onClick = {
                Toast.makeText(context, "hello this is tonal button", Toast.LENGTH_SHORT).show()
            }
            ){
            Text("Tonal Button")
        }
    }

}
// Outline Button -> non primary ,cancel or back ke liye
@Composable
fun OutlinedButtonsample(){
    val context=LocalContext.current
    Box(
        modifier=Modifier.fillMaxSize(),
        contentAlignment=Alignment.Center

    ){
OutlinedButton(

    onClick = {
        Toast.makeText(context,"hello this is outline button",Toast.LENGTH_SHORT).show()
    }
)  {
    Text("Outlined Button")
    }
}
}

// ELEVATED BUTTON -> PRIMARY BUTTON KE LIYE
@Composable
fun elevatedButtonSample(){
    Box(
        modifier=Modifier.fillMaxSize(),
        contentAlignment=Alignment.Center
    ){
    val context=LocalContext.current
    ElevatedButton(
        onClick= {

        }
    ) {
        Text("Elevated Button")
    }
}
}

// Text Button -> TEXT BUTTON KE LIYE
@Composable
fun TextbuttonSample() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        TextButton(
            onClick = {
            }

        ) {
            Text("Text Button")
        }
    }

}
@Preview(showSystemUi=true)
@Composable
fun FilledButtonSamplePreview(){
   // FilledButtonSample()
   // TonallButtonSample()
   // OutlinedButtonsample()
   // elevatedButtonSample()
  TextbuttonSample()
    



}