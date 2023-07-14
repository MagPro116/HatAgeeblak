package com.magpro.hatageeblak.app_ui.account.acc_views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.magpro.hatageeblak.R
import com.magpro.hatageeblak.app_ui.account.acc_navhost.AccountScreens
import com.magpro.hatageeblak.services.AppServices
import com.magpro.hatageeblak.services.AppServices.Companion.toastMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordView(navController: NavController) {
    val context = LocalContext.current
    var email by rememberSaveable { mutableStateOf("") }
    val emailMessage = stringResource(id = R.string.email)
    val services = AppServices.Colors()


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(services.blackColor)
            .padding(top = 65.dp),
        shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(services.backgroundColor)
                .padding(start = 21.dp, end = 21.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 21.dp, end = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    modifier = Modifier.size(21.dp),
                    onClick = {
                        navController.navigate(AccountScreens.AccountScreenLogin.rout)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_down),
                        contentDescription = "down icon",
                        tint = Color.Black
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.recover_password),
                color = Color.Black,
                fontSize = 21.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 21.dp)
            )
            Spacer(modifier = Modifier.height(33.dp))



            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = stringResource(id = R.string.email)) },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "phone_icon"
                    )
                },
                placeholder = { Text(text = "@magpro116@gmail.com") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    placeholderColor = Color.Gray,
                    containerColor = services.backgroundColor,
                    cursorColor = services.darGrayColor,
                    focusedLabelColor = services.darGrayColor,
                    focusedIndicatorColor = services.darGrayColor
                ),
                shape = RoundedCornerShape(7.dp)
            )





            Row(modifier = Modifier.padding(vertical = 11.dp)) {
                Button(
                    onClick = {
                        if (email.isEmpty()) {
                            toastMessage(context, emailMessage)
                        } else {
                            navController.navigate(AccountScreens.AccountCreateNewPassword.rout)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(49.dp),
                    shape = RoundedCornerShape(0.dp),
                    border = BorderStroke(1.dp, services.whiteColor),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = services.whiteColor,
                        contentColor = services.whiteColor,
                        disabledContainerColor = services.whiteColor,
                        disabledContentColor = services.whiteColor
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 11.dp,
                        pressedElevation = 21.dp
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.recover),
                        color = services.blackColor,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }


        }

    }
}

@Preview
@Composable
fun PassPreview() {
    val navController = rememberNavController()
    ForgotPasswordView(navController = navController)
}

