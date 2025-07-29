package com.example.jetpackcomposecourse.c_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

// Best practice

   // 1. over Nesting box ke under box upto 5 is good rows column etc warna slow ho jayega

   // 2.Use .fillMaxWidth() / .fillMaxHeight() to make your layout responsive across devices. Use dp values for padding/margin, not hardcoded pixel values.

// 1.Column,it allows you to place its children in a vertical sequence.

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("First Item")
        Text("Second Item")
        Text("Third Item")
        Text("Fourth Item")

    }

}

//2.Row,it allows you to place its children in a horizontal sequence.
@Composable
fun row_Example() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text("First Item   ")
        Text("Second Item   ")
        Text("Third Item   ")
        Text("Fourth Item  ")
    }
}

//3.Box,it is a layout composable that allows you to stack composables on top of each other.
@Composable
fun Boxexample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red),
            contentAlignment = Alignment.TopCenter
        ) {
            Text("First Item")
        }


        Text("Second Item")
//        Text("Third Item")
//        Text("Fourth Item")

    }
}

//4. ConstraintLayout: use only when needed and ui is complex and performace costly
@Composable
fun ConstraintLayoutExample() {

    Column {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
                .background(Color.Blue)

        ) {
            val (text1, text2, text3, text4,text5) = createRefs()//kiske piche kon hai

            Text(
                "Bottom Left",
                modifier = Modifier.constrainAs(text1) {
                    bottom.linkTo(parent.bottom,margin=8.dp)
                    start.linkTo(parent.start,margin=8.dp)//start mtlb B Bottom

                }
            )
            Text(
                "Center Left",
                modifier = Modifier.constrainAs(text2) {
                    top.linkTo(parent.top,margin=10.dp)
                    bottom.linkTo(parent.bottom,margin=8.dp)
                    end.linkTo(parent.end,margin=8.dp)
                    start.linkTo(parent.start)

                }
            )
            Text(
                "Bottom right",
                modifier = Modifier.constrainAs(text3) {

                    bottom.linkTo(parent.bottom,margin=8.dp)
                    end.linkTo(parent.end,margin=8.dp)


                }
            )
            Text("Top Left",
                modifier = Modifier.constrainAs(text4){
                    top.linkTo(parent.top,margin=20.dp)
                    start.linkTo(parent.start,margin=8.dp)

                }
            )
            Text("top Right",
                modifier = Modifier.constrainAs(text5){
                    end.linkTo(parent.end,margin=20.dp)
                    top.linkTo(parent.top,margin=20.dp)
                    

            })
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun ColumnExamplePreview() {
    // ColumnExample()
    //row_Example()
   // Boxexample()
    ConstraintLayoutExample()



}