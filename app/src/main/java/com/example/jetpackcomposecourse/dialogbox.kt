package com.example.jetpackcomposecourse

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun DialongWithImage(g

){
    val context= LocalContext.current
    Box(modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
    Dialog(onDismissRequest= {

    })
    {

        Card(
            modifier= Modifier.fillMaxWidth()
                .padding(16.dp),
            shape=RoundedCornerShape(16.dp)
        ){

      Image(
          painter= painterResource(R.drawable.under),
          contentDescription = "hell",
          contentScale = ContentScale.Fit,
          modifier= Modifier.height(160.dp)
              .padding(start=24.dp)
      )
            Text(text="this is the dialog",
                modifier=Modifier.padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                TextButton(
                    onClick={
                        Toast.makeText(context,"you can do have pateint",Toast.LENGTH_SHORT).show()

                    },
                    modifier=Modifier.padding(8.dp)
                ){
                    Text("Confirm")
                }
                TextButton(
                    onClick={

                    },
                    modifier=Modifier.padding(8.dp)
                ){
                    Text("Dismiss")
                }
            }
        }
    }}
    }


@Preview(showSystemUi = true)
@Composable
fun DD(){
    DialongWithImage()
}