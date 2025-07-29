package com.example.jetpackcomposecourse.segmentButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsBike
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Segemenetbuttonex(){
    val selections=remember{
        mutableStateListOf(false,false,false)
    }
    val options=listOf("walk","Ride","Drive")
    Box(modifier= Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        MultiChoiceSegmentedButtonRow() {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    checked = selections[index],
                    onCheckedChange = {
                        selections[index] = !selections[index]
                    },
                    icon = {
                        SegmentedButtonDefaults.Icon(selections[index])
                    },
                    label = {
                        when (label) {
                            "walk" -> Icon(
                                imageVector = Icons.AutoMirrored.Filled.DirectionsWalk,
                                contentDescription = "walk"
                            )

                            "Ride" -> Icon(
                                imageVector = Icons.Default.DirectionsBus,
                                contentDescription = null
                            )

                            "Drive" -> Icon(
                                imageVector = Icons.Default.DirectionsCar,
                                contentDescription = null
                            )

                        }

                    }
                )

            }
        }

    }
}
@Preview(showSystemUi = true)
@Composable
fun pre(){
    Segemenetbuttonex()
}


