package com.example.jetpackcomposecourse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipExaaaaample(){
    var enable by remember{
        mutableStateOf(true)
    }
    Box(
        modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
    if(enable){
        InputChip(
            onClick={
                enable=!enable
            },label={
                Text("Enabled")
            },
            selected = enable,
            avatar= {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                            Modifier.size(InputChipDefaults.AvatarSize))
            },
                    trailingIcon={
                        Icon(Icons.Filled.Close,
                            contentDescription = "localize",
                            Modifier.size(InputChipDefaults.AvatarSize)
                            )
                    }


                )
            }


    }}

@Preview(showSystemUi = true)
@Composable
fun previ(){
    InputChipExaaaaample()
}