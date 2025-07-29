package com.example.jetpackcomposecourse.v_bottomnavigation



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorDirection
import com.example.bottombar.model.IndicatorStyle

data class Bottomnav(val name:String,val icon:ImageVector,val unselectedIcon:ImageVector)




@Composable
fun BottomSheetNavigationBarr(){

    var selectedItems by remember { mutableIntStateOf(0) }
    var content by remember { mutableStateOf("this is Home ") }
    val BottomNavItem=listOf(
        Bottomnav(
            name = "Home",
            icon = Icons.Default.Home,
            unselectedIcon = Icons.Outlined.Home
    ),
        Bottomnav(
            name = "wishList",
            icon = Icons.Default.Favorite,
            unselectedIcon = Icons.Outlined.Favorite
        ),
        Bottomnav(
            name = "Cart",
            icon = Icons.Default.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart
        ),
        Bottomnav(
            name = "Profile",
            icon = Icons.Default.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )
    Scaffold(
        bottomBar={
            Surface(
                modifier= Modifier.fillMaxWidth().padding(bottom= WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding())

            ){
              AnimatedBottomBar(selectedItem=selectedItems,
                  itemSize=BottomNavItem.size,
                  containerColor = Color.Transparent,
                  indicatorColor = MaterialTheme.colorScheme.primary,
                  indicatorDirection = IndicatorDirection.TOP,
                  indicatorStyle = IndicatorStyle.LINE
              ) {
                  BottomNavItem.forEachIndexed { index, items ->
                      BottomBarItem(
                  modifier=Modifier.align(alignment= Alignment.Top),
                          selected=selectedItems==index,
                          onClick={selectedItems=index
                                  when(index){
                                      0->content="this is home"
                                      1->content="this is wishlist"
                                      2->content="this is cart"
                                      3->content="this is profile"

                                  }

                                  },

                          imageVector = items.icon,
                          label=items.name,
                          containerColor = Color.Transparent


                      )
              }}
            }

        }

    ){
        innerpadding->
        Box(modifier = Modifier.padding(innerpadding).fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text(text=content, fontSize = 24.sp)
        }
    }

}
@Preview(showSystemUi = true)
@Composable
fun prevv(){
    BottomSheetNavigationBarr()
}