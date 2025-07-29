package com.example.jetpackcomposecourse


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed

@Composable
fun CheckBoxexample() {
    val childCheckedStates = remember {
        mutableListOf(false, false, false,true)
    }
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.any { it } -> ToggleableState.Indeterminate
        else -> ToggleableState.Off
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (childCheckedStates.all { it }) {
            Text("All selected",)
        } else {
            Text("Not all selected")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select all")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckedStates.fastForEachIndexed { index, _ ->
                        childCheckedStates[index] = newState
                    }
                }
            )
        }
        childCheckedStates.forEachIndexed { index, checked ->/**This is a loop that goes through each item in the list items, and gives you:

index → the position (0, 1, 2, ...)

item → the actual value at that position (like "Milk", "Bread"...)**/
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        childCheckedStates[index] = it
                    }
                )
            }
        }



    }
}
@Preview
@Composable
fun preview(){
    CheckBoxexample()
}