package com.example.jetpackcomposecourse.t_Badge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecourse.c_layout.ModifierExample

@Composable
fun BadgeInteractive() {
    var itemcount by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        BadgedBox(
            badge = {

                if (itemcount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$itemcount",
                            fontSize = 18.sp)


                    }
                }

            }

        ){
            Icon(
                modifier = Modifier.size(50.dp),
                imageVector = androidx.compose.material.icons.Icons.Filled.ShoppingCart,
                contentDescription = "add"

            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick={
                itemcount++

            }) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Filled.Add,
                contentDescription = "add"
            )

                  Text(text = "Add")
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun pre(){
    BadgeInteractive()
}