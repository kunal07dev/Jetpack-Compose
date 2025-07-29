package com.example.jetpackcomposecourse.afundamental
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// what is composable function
// A composable function is a building block of UI in Jetpack Compose, the modern declarative UI toolkit for Android.

@Composable // ui function jetpack ko bata rahe rahe hai ki ye ui ka fuction hai
fun Greeting(){
    Text(text = "Hello")
}
// ui dekhna preview dekhta device me nhi
//@Preview(showSystemUi=true)
//@Composable
//fun GreetingPreview(){
//    Greeting()
//}


// | Use Case                       | Recommended Padding |
//| ------------------------------ | ------------------- |
//| **Screen edge (outer margin)** | `16.dp` – `24.dp`   |
//| **Between items (vertical)**   | `8.dp` – `16.dp`    |
//| **Inside cards / buttons**     | `12.dp` – `16.dp`   |
//| **Icon + Text spacing**        | `8.dp`              |
//| **Touch targets**              | ≥ `48.dp` height    |


//rememberCoroutineScope() is the right and safe choice for UI events like opening a drawer.