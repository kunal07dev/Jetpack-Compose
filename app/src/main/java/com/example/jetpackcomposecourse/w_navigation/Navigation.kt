package com.example.jetpackcomposecourse.w_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun App(){
    val navController= rememberNavController()
    NavHost(navController=navController,
    startDestination = Navigation.Main){
        navigation<Navigation.Main>(startDestination = Routes.Home){
            composable<Routes.Home>{
                HomeScreen(navController=navController)
            }
            composable<Routes.WishList>{
                WishListScreen(navController=navController)
            }
        }

    }
}
