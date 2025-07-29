package com.example.jetpackcomposecourse.navigation_drawer

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedDrawerExample(){
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope=rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier= Modifier.fillMaxSize()
                        .verticalScroll(rememberScrollState()),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("Drawer Title")
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color.Gray
                    )
//                    Text("Drawer Item 1")
//                    Spacer(Modifier.size(8.dp))
//                    Text("Drawer Item 2")
//                    Text("Drawer Item 3")


                NavigationDrawerItem(
                    label={
                        Text("item 1")
                    },

                    selected = false,
                    onClick = {

                    }

                )
                NavigationDrawerItem(
                    label={
                        Text("item 1")
                    },

                    selected = false,
                    onClick = {

                    },
                )}

            }
        },
        drawerState = drawerState
    ) {
Scaffold (
    topBar={
        TopAppBar(
            title = {Text("Navigation drawer")},
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            if(drawerState.isClosed)
                            drawerState.open()
                            else{
                                drawerState.close()
                            }
                        }
                    }
                ) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },


        )

    }
){
    innerpadding->
    Column(
        modifier= Modifier.fillMaxSize()
            .padding(innerpadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Content")
    }
}
    }

}

@Preview(showSystemUi = true)
@Composable
fun DetailedDrawerExamplePreview(){
    DetailedDrawerExample()
}