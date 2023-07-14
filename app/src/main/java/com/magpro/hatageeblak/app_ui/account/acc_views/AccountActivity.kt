package com.magpro.hatageeblak.app_ui.account.acc_views

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.magpro.hatageeblak.MainActivity
import com.magpro.hatageeblak.app_ui.account.acc_navhost.AccountNavHost
import com.magpro.hatageeblak.services.AppServices

class AccountActivity : ComponentActivity() {

    lateinit var services: AppServices.Colors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        services = AppServices.Colors()
        setContent {
            Surface() {
                services.barStatusColor(color = services.blackColor)
                AccountNavHost()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        startActivity(Intent(this, MainActivity::class.java))
        return true
    }
}

