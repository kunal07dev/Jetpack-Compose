package com.example.jetpackcomposecourse.bcoreComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleOutlinedTextFieldSample() {

    var text by remember {//remberSaveable tab use karte jab hume refersh ke baad state save rhti hai jaise half info bhar li aur back ho gaya toh gayab hone se bachne ke liye ye use karte hai
        mutableStateOf("")//last value yaad rkhta hai phir  set kar deta hai
    }
    val col = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Cyan,
        Color.Magenta,
        Color.Yellow
    )
    val brush by remember {
        mutableStateOf(Brush.linearGradient(
            colors = col
        ))

    }
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        // we have normal TextField also
    OutlinedTextField(//agar change hoti hai toh text ko update kar deta hai
        value=text,
        onValueChange = {
            text=it
        },
        label={
            Text("label")
            },
        textStyle = TextStyle(brush=brush)
    )

        }

}
//password textfield
@Composable
fun PasswordField(){
    var password by rememberSaveable   {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter

    ) {
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("enter password")
            },
            visualTransformation = PasswordVisualTransformation(),//this is used to hide the password ....
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password// this is done so that it dint autocorrect the password etc
            )

        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun SimpleOutlinedTextFieldSamplePreview(){
    SimpleOutlinedTextFieldSample()
    PasswordField()

}