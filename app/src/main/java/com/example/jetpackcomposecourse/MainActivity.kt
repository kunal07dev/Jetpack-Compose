package com.example.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposecourse.afundamental.AccessStringRes
import com.example.jetpackcomposecourse.bcoreComponents.AnnotatedStringwithListenerSample
import com.example.jetpackcomposecourse.bcoreComponents.FilledButtonSample
import com.example.jetpackcomposecourse.bcoreComponents.PartiallySelectlableText
import com.example.jetpackcomposecourse.bcoreComponents.PartiallySelectlableTextPreview
import com.example.jetpackcomposecourse.bcoreComponents.PasswordField
import com.example.jetpackcomposecourse.d_bottomsheet.partialBottomSheet
import com.example.jetpackcomposecourse.g_Menus.DropDownmenuexa
import com.example.jetpackcomposecourse.navigation_drawer.DetailedDrawerExample
import com.example.jetpackcomposecourse.o_pulltorequest.PulltoRefreshScreen
import com.example.jetpackcomposecourse.u_Timepicker.timepickerex
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import com.example.jetpackcomposecourse.v_Topappbar.TopAppBarex
import com.example.jetpackcomposecourse.v_bottomnavigation.BottomSheetNavigationBarr
import com.example.jetpackcomposecourse.w_navigation.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCourseTheme {//ismei ui ko call karna hota hai
               // Greeting()
                //AccessStringRes()
             //   PasswordField()
                //PartiallySelectlableText()
               // AnnotatedStringwithListenerSample()
               // FilledButtonSample()
               // partialBottomSheet()
                //bottlesheets()
                //tributton()
              //  InputChipExaaaaample()
                //DialongWithImage()
                //DropDownmenuexa()
               // DetailedDrawerExample()
               // PulltoRefreshScreen()
              //  timepickerex()
              //  BottomSheetNavigationBarr()
                //TopAppBarex()
                App()


            }
        }
    }
}



