package com.example.jetpackcomposecourse.h_scaffold

import android.text.Layout
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// scafold is ui strcuture in which we can add our own ui it has top bar bottom bar and floating button
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaf() {
    var press by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                    navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.primaryContainer
                ),

                title = {
                    Text("Top app bar")
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
           //tonalElevation = 10.dp
            ) {
                Text(
                    "Bottom app bar",
                    modifier = Modifier.padding(16.dp).weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    press++
                }
            ) {
                Text(press.toString())
            }

        }
    ) { innerPadding ->
        Text(
            "This is content",
            modifier = Modifier.padding(innerPadding)
        )


    }

}
@Preview(showSystemUi = true)
@Composable
fun pre() {
    scaf()
}