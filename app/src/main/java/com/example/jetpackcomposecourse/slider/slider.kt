package com.example.jetpackcomposecourse.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Sliderex() {
    var sliderposition by remember {
        mutableStateOf(0f)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderposition,
            onValueChange = {
                sliderposition = it
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
            ), steps = 4,
            valueRange = 0f..50f
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row( modifier = Modifier.fillMaxWidth(),
            ){
            Text("0", modifier = Modifier.weight(1f))
            Text("${sliderposition.toInt()}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            Text("50", modifier = Modifier.weight(1f), textAlign = TextAlign.End)
    }}
}

@Preview(showSystemUi = true)
@Composable
fun pre() {
    Sliderex()
}