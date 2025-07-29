package com.example.jetpackcomposecourse.u_Datapicker

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun datapicker() {
    var selecteddate by remember { mutableStateOf<Long?>(null) }
    var showModel by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center)    {
    OutlinedTextField(
        value = selecteddate?.let { convermillisToDateString(it) } ?: "",
        onValueChange = {

        },
        label = {
            Text("DoB")
        },
        placeholder = { Text("dd/mm/yyyy") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "date")
        },
        modifier = Modifier.fillMaxWidth().pointerInput(selecteddate) {
            awaitEachGesture {
                awaitFirstDown(pass = PointerEventPass.Initial)
                val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                if (upEvent != null) {
                    showModel = true
                }
            }
        }
    )
    if (showModel) {
        DataPickerModal(
            onDateSelected = {
                selecteddate = it
                showModel = false
            },
            onDismiss = {
                showModel = false
            }
        )
    }
}   }
fun convermillisToDateString(millis:Long):String{
    val formatter= SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataPickerModal(
    onDateSelected:(Long)->Unit,
    onDismiss:()->Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    datePickerState.selectedDateMillis?.let { onDateSelected(it) }
                    onDismiss
                }
            ) {
                Text("ok")

            }
        },

    dismissButton = {
        TextButton(
            onClick = onDismiss
        ) {
            Text("cancel")
        }
    }
    ){
    DatePicker(state = datePickerState)
    }
}

@Preview
@Composable
fun datapickerPreview(){
    datapicker()
}

