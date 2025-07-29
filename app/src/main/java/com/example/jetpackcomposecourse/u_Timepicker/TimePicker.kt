package com.example.jetpackcomposecourse.u_Timepicker

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material3.*
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun timepickerex() {
    var showDialog by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = if (selectedTime.isEmpty()) "No Time selected" else "Selected Time: $selectedTime",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { showDialog = true }) {
                Text(text = "Select Time")
            }
        }

        if (showDialog) {
            AdvanceTimepicker(
                onConfirm = {
                    val hour = it.hour
                    val minute = it.minute
                    selectedTime = if (it.is24hour) {
                        String.format("%02d:%02d", hour, minute)
                    } else {
                        val amPm = if (hour >= 12) "PM" else "AM"
                        val hour12 = if (hour % 12 == 0) 12 else hour % 12
                        String.format("%02d:%02d %s", hour12, minute, amPm)
                    }
                    showDialog = false
                },
                onDismiss = { showDialog = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun AdvanceTimepicker(
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit
) {
    val calendar = Calendar.getInstance()
    var is24Hour by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState(
        initialHour = calendar.get(Calendar.HOUR_OF_DAY),
        initialMinute = calendar.get(Calendar.MINUTE),
        is24Hour = is24Hour
    )

    var showDial by remember { mutableStateOf(true) }

    val toggleIcon = if (showDial) Icons.Default.EditCalendar else Icons.Default.AccessTime

    AdvanceTimepickerDialog(
        title = "Choose Time",
        onDismiss = onDismiss,
        onConfirm = { onConfirm(timePickerState) },
        toggle = {
            IconButton(onClick = { showDial = !showDial }) {
                Icon(imageVector = toggleIcon, contentDescription = null)
            }
        },
        formatToggle = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("12-Hour", style = MaterialTheme.typography.labelLarge)
                Switch(
                    checked = is24Hour,
                    onCheckedChange = { is24Hour = it }
                )
                Text("24-Hour", style = MaterialTheme.typography.labelLarge)
            }
        }
    ) {
        AnimatedContent(targetState = showDial, label = "TimePickerSwitch") { show ->
            if (show) {
                TimePicker(state = timePickerState)
            } else {
                TimeInput(state = timePickerState)
            }
        }
    }
}

@Composable
fun AdvanceTimepickerDialog(
    title: String? = "Select Time",
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    toggle: @Composable () -> Unit = {},
    formatToggle: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 8.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.surface
                )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (title != null) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        text = title,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }

                formatToggle()
                Spacer(modifier = Modifier.height(8.dp))
                content()

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    toggle()
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = onDismiss) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = onConfirm) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun pre() {
    // timepickerex()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(16.dp),
            tonalElevation = 8.dp,
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Hello Surface!")
        }
    }
}