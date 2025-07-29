package com.example.jetpackcomposecourse.bcoreComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PartiallySelectlableText(){
    Box(
        modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
         Column {
             Text("this is a Text boii")
             Text("this is a  boii")
             Text("this is a T ii")
             Text("this is a ii")
             Text("this is a")
             Text("your boy badshaa")
             DisableSelection {
                 Text("you cannot copy this or select this")
             }

         }
    }
}

@Composable
fun AnnotatedStringwithListenerSample() {
    val uriHandler = LocalUriHandler.current// to open the link
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
    val annotatedText = buildAnnotatedString {//to style add the  link
        append("You can click  ")

        // Add clickable and styled link
        pushStringAnnotation(// we pushed the link into the text
            tag = "URL",
            annotation = "https://developer.android.com/jetpack"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline

            )
        ) {
            append("here")
        }
        append("for link")

    }


        ClickableText(// to make the text clickable
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "URL",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    uriHandler.openUri(annotation.item)
                }
            }
        )
    }
}

@Preview(showSystemUi=true)
@Composable
fun PartiallySelectlableTextPreview(){
    // PartiallySelectlableText()
    AnnotatedStringwithListenerSample()
}