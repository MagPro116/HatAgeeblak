package com.magpro.hatageeblak.services

import android.app.Activity
import android.content.Context
import android.graphics.Color.parseColor
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class AppServices{

    class Colors{
        val String.color get() = Color(parseColor(this))
        val backgroundColor = "#FFFFFF".color
        val lightGray = "#F3F3F3".color
        val grayColor = "#969696".color
        val darGrayColor = "#2B2B2B".color
        val blackColor = "#000000".color
        val whiteColor = "#FFFFFF".color

        @Composable
        fun barStatusColor(color: Color) {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(color = color)
            }
        }
    }

    companion object{
        fun toastMessage(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }


}
