package com.magpro.hatageeblak

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.magpro.hatageeblak.app_ui.account.acc_views.AccountActivity
import com.magpro.hatageeblak.app_ui.home.HomeActivity
import com.magpro.hatageeblak.services.AppPreferences
import com.magpro.hatageeblak.services.AppServices

class MainActivity : ComponentActivity() {

    lateinit var preferences: AppPreferences
    lateinit var services: AppServices.Colors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        services = AppServices.Colors()
        preferences = AppPreferences(this)
        preferences.set("is_logged_in", false)


        setContent {
            Surface() {
                services.barStatusColor(color = services.backgroundColor)
                MainView()
            }
        }

        Handler().postDelayed({
            if (preferences.getBoolean("is_logged_in"))
                startActivity(Intent(this, HomeActivity::class.java))
            else
                startActivity(Intent(this, AccountActivity::class.java))
        }, 2 * 1000)

    }
}

@Composable
fun MainView() {
    val services = AppServices.Colors()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(services.backgroundColor)
            .padding(horizontal = 21.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(services.backgroundColor)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(195.dp)
                    .background(services.backgroundColor)
                    .border(width = 7.dp, services.blackColor, CutCornerShape(55.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = services.backgroundColor,
                    fontSize = 45.sp,
                    fontFamily = FontFamily.Cursive,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(services.blackColor)
                        .padding(vertical = 13.dp)
                )
            }

        }

    }

}

@Preview
@Composable
fun mainPreview() {
    MainView()
}