package com.example.jetpackcomposecourse.afundamental

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecourse.R

@Composable
fun AccessStringRes(){
    //container
    Box(
        modifier=Modifier.fillMaxSize(), //modifier modify karne ke liye layout ko
        contentAlignment = Alignment.Center//jo bhi content hai box me kaha aayega
    ){
        Text(text= stringResource(R.string.fruit),color= colorResource(R.color.purple_200))// R means res folder denote
    }
}
@Composable
fun image(){
    Box(
       modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Image(painter= painterResource(R.drawable.under), contentDescription = "undertaker")

    }
}
@Preview(showSystemUi=true)
@Composable
fun prev(){
    image()
//    AccessStringRes()
}