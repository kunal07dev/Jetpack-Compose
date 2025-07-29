package com.example.jetpackcomposecourse.E_cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R
import com.example.jetpackcomposecourse.afundamental.image

@Composable
fun ElevatedCardsample() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center

    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                10.dp
            ),
            modifier = Modifier.size(width = 300.dp, height = 400.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.under),
                    contentDescription = "Card Image"
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text("Elevated Card")
            }

        }
    }
}
@Preview
@Composable
fun preview(){
    ElevatedCardsample()
}