package com.example.jetpackcomposecourse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun floatingButtonexample(){
    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.BottomEnd
    ){
    ExtendedFloatingActionButton(
        onClick={

        },
        content = {
            Text("this is floating button")
        }

            )

    }}

@Composable
@Preview(showSystemUi = true)
fun floatingButtonexamplePreview(){
    floatingButtonexample()
}