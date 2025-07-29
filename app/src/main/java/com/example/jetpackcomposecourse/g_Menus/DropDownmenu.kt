package com.example.jetpackcomposecourse.g_Menus

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropDownmenuexa() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize()
        ,
        contentAlignment = Alignment.TopEnd
    ) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        IconButton(
            onClick = {
                expanded = !expanded
            }

        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "3 dot")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }) {
            DropdownMenuItem(
                text = {
                    Text("Profile")
                },
                trailingIcon = { Icon(Icons.Outlined.Person, contentDescription = "profile") },
                onClick = {

                }
            )

            DropdownMenuItem(
                text = {
                    Text("Settings")
                },
                trailingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "profile") },
                onClick = {})
        }


    }
}}
@Preview(showSystemUi = true)
@Composable
fun pre(){
    DropDownmenuexa()
}