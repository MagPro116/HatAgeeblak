package com.magpro.hatageeblak.app_ui.home

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.magpro.hatageeblak.services.AppServices

class HomeActivity : ComponentActivity() {

    lateinit var services: AppServices.Colors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        services = AppServices.Colors()
        setContent {
            Surface() {
                services.barStatusColor(color = services.lightGray)
                HomeView()
            }
        }
    }

    @Preview
    @Composable
    fun HomePreview() {
        HomeView()
    }

}
