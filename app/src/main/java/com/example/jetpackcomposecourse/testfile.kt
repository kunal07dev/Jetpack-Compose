package com.example.jetpackcomposecourse


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.material3.Checkbox

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier

                .fillMaxWidth()

                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Title
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            // Username Input
            var username by remember { mutableStateOf("") }
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                singleLine = true,//kitna bhi bada text ho ek hi line mei aaye
                modifier = Modifier.fillMaxWidth()
            )

            // Password Input
            var password by remember { mutableStateOf("") }
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            // Login Button
            Button(
                onClick = {
                    // TODO: handle login action
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            // Optional: Forgot Password
            TextButton(onClick = {
                // TODO: navigate to forgot password
            }) {
                Text("Forgot Password?")
            }
        }
    }
}

@Composable
fun HeightComparisonExample() {
    Row(modifier = Modifier.fillMaxSize()) {
        // ✅ Box with wrapContentHeight
        Box(
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight()
                .background(Color.Green)
                .padding(16.dp)
        ) {
            Column {
                Text("Wrap Content Height", color = Color.White)
                Text("This box", color = Color.White)
                Text("Only takes the space it needs", color = Color.White)
            }
        }

        // 🔴 Box with fillMaxHeight
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red)
                .padding(16.dp)
        ) {
            Column {
                Text("Fill Max Height", color = Color.White)
                Text("This box", color = Color.White)
                Text("Fills the whole screen height", color = Color.White)
            }
        }
    }
}


@Composable
fun logins() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp

            )

            var userName by rememberSaveable {
                mutableStateOf("")
            }

            // username
            OutlinedTextField(
                value = userName,
                onValueChange = {
                    userName = it
                },
                label = { Text("UserName") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            var password by rememberSaveable{
                mutableStateOf("")
            }
            //Passwaord
            OutlinedTextField(
                value=password,
                onValueChange ={
                    password=it
                },
                label={Text("password")},
                singleLine=true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()

            )
            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
            ){
                Text("login")
            }
            TextButton(

                onClick = {

                }
            ){
                Text("Forgot Password")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottlesheets(){
    var bottomsheet by rememberSaveable{
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment=Alignment.CenterHorizontally,

    ){
        Button(
            modifier=Modifier.wrapContentHeight(),
            onClick = {
                bottomsheet=true
            }

        ){
            Text("open")
        }
        if(bottomsheet){
            ModalBottomSheet(
                modifier=Modifier.fillMaxSize(),
                sheetState=sheetState,
                onDismissRequest={
                    bottomsheet=false
                }

            ) {
                Text("you man this is bottom sheet")
            }
        }
    }

    }


    @Composable
    fun tributton() {
        val products = listOf("Milk", "Bread", "Cheese", "Yogurt")
        val child = remember{
            mutableStateListOf(*Array(products.size) { false })
        }

        val parentState = when {
            child.all { it } -> ToggleableState.On
            child.any { it } -> ToggleableState.Indeterminate
            else -> ToggleableState.Off
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 16.dp), // ✅ Proper padding
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Parent (TriState) row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Selected",
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp
                )
                TriStateCheckbox(
                    state = parentState,
                    onClick = {
                        val newState = parentState != ToggleableState.On
                        for (i in child.indices) {
                            child[i] = newState
                        }
                    }
                )
            }

            // Child items
            products.fastForEachIndexed { i, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        item,
                        modifier = Modifier.weight(1f),
                        fontSize = 16.sp
                    )
                    Checkbox(
                        checked = child[i],
                        onCheckedChange = { child[i] = it }
                    )
                }
            }
        }
    }


    @Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    //LoginScreen()

  // logins()
   // bottlesheets()
    tributton()
}

