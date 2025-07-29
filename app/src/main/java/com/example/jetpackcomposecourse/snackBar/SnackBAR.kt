package com.example.jetpackcomposecourse.snackBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun snackbaex() {
    var scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }, floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "show snackbar") },
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Snackbar jnj",
                            actionLabel = "ACTION",
                            duration = SnackbarDuration.Indefinite
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                snackbarHostState.showSnackbar(
                                    message = "Action performed",
                                    duration = SnackbarDuration.Short
                                )
                            }

                            SnackbarResult.Dismissed -> {
                            }
                        }
                    }

                },
            )
        },
                content = { padding ->
                    Box(
                        modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
                    ){
                        Text(text="tab the button to show the sncak bar")
                    }
                }
    )


}
    @Preview(showSystemUi = true)
@Composable
fun pre(){
    snackbaex()
}

