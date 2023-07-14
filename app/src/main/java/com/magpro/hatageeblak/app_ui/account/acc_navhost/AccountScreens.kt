package com.magpro.hatageeblak.app_ui.account.acc_navhost

sealed class AccountScreens(val rout: String){
    object AccountScreenLogin: AccountScreens("Login")
    object AccountScreenRegister: AccountScreens("Register")
    object AccountScreenRecoverPassword: AccountScreens("RecoverPassword")
    object AccountCreateNewPassword: AccountScreens("CreateNewPassword")
}
