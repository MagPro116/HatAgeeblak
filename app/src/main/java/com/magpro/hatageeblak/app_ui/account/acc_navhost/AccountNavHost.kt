package com.magpro.hatageeblak.app_ui.account.acc_navhost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.magpro.hatageeblak.app_ui.account.acc_views.CreateAccountView
import com.magpro.hatageeblak.app_ui.account.acc_views.CreatePassword
import com.magpro.hatageeblak.app_ui.account.acc_views.ForgotPasswordView
import com.magpro.hatageeblak.app_ui.account.acc_views.LoginView

@Composable
fun AccountNavHost() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AccountScreens.AccountScreenLogin.rout
    ) {

        composable(AccountScreens.AccountScreenLogin.rout) {
            LoginView(navController = navController)
        }

        composable(AccountScreens.AccountScreenRegister.rout) {
            CreateAccountView(navController = navController)
        }

        composable(AccountScreens.AccountScreenRecoverPassword.rout) {
            ForgotPasswordView(navController = navController)
        }

        composable(AccountScreens.AccountCreateNewPassword.rout) {
            CreatePassword(navController = navController)
        }

    }

}