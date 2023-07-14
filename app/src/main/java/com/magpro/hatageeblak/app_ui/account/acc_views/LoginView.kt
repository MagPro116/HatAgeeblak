package com.magpro.hatageeblak.app_ui.account.acc_views

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.magpro.hatageeblak.R
import com.magpro.hatageeblak.app_ui.account.acc_navhost.AccountScreens
import com.magpro.hatageeblak.app_ui.home.HomeActivity
import com.magpro.hatageeblak.services.AppServices

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavController) {
    val services = AppServices.Colors()

    var mobile by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val toastMobile = stringResource(id = R.string.enter_mobile)
    val toastPassword = stringResource(id = R.string.enter_pass)

    val icon = if (passwordVisibility) painterResource(id = R.drawable.ic_visibility_on)
    else painterResource(id = R.drawable.ic_visibility_off)


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
                .padding(top = 65.dp, start = 21.dp, end = 21.dp, bottom = 21.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 33.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(id = R.string.login),
                    color = Color.Black,
                    fontSize = 27.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.welcome_back),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(top = 7.dp)
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 11.dp))

            OutlinedTextField(
                value = mobile,
                onValueChange = { mobile = it },
                label = { Text(text = stringResource(id = R.string.enter_mobile)) },
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "phone_icon"
                    )
                },
                placeholder = { Text(text = "0123456789") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    placeholderColor = services.grayColor,
                    containerColor = services.backgroundColor,
                    cursorColor = services.darGrayColor,
                    focusedLabelColor = services.darGrayColor,
                    focusedIndicatorColor = services.darGrayColor
                ),
                shape = RoundedCornerShape(11.dp)

            )

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(id = R.string.enter_pass)) },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "password_icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon, contentDescription = "visibility icon"
                        )
                    }
                },
                placeholder = { Text(text = "*******") },
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (mobile.isEmpty()) {
                            Toast.makeText(context, toastMobile, Toast.LENGTH_SHORT).show()
                        } else {
                            if (password.isEmpty()) {
                                Toast.makeText(context, toastPassword, Toast.LENGTH_SHORT).show()
                            } else {
                                keyboardController?.hide()
                                focusManager.clearFocus(true)
                                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    placeholderColor = services.grayColor,
                    containerColor = services.backgroundColor,
                    cursorColor = services.darGrayColor,
                    focusedLabelColor = services.darGrayColor,
                    focusedIndicatorColor = services.darGrayColor
                ),
                shape = RoundedCornerShape(11.dp),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Button(
                    onClick = {
                        navController.navigate(AccountScreens.AccountScreenRecoverPassword.rout)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = services.backgroundColor,
                        containerColor = services.backgroundColor
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.DarkGray,
                        fontFamily = FontFamily.Serif
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 17.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    onClick = {
                        if (mobile.isEmpty()) {
                            Toast.makeText(context, toastMobile, Toast.LENGTH_SHORT).show()
                        } else {
                            if (password.isEmpty()) {
                                Toast.makeText(context, toastPassword, Toast.LENGTH_SHORT).show()
                            } else {
                                keyboardController?.hide()
                                focusManager.clearFocus(true)
                                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(49.dp),
                    shape = RoundedCornerShape(33.dp),
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
                        text = stringResource(id = R.string.login),
                        color = services.blackColor,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }


            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { context.startActivity(Intent(context, HomeActivity::class.java)) },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = services.backgroundColor,
                        containerColor = services.backgroundColor
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.guest),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.DarkGray,
                        fontFamily = FontFamily.Serif
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { navController.navigate(AccountScreens.AccountScreenRegister.rout) },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = services.backgroundColor,
                        containerColor = services.backgroundColor
                    )
                ) {
                    Text(
                        buildAnnotatedString {

                            withStyle(style = SpanStyle(
                                fontSize = 15.sp,
                                color = Color.DarkGray,
                                fontFamily = FontFamily.Serif
                            )){
                                append(stringResource(id = R.string.create_account))
                            }

                            append(" ")
                            withStyle(style = SpanStyle(
                                fontSize = 15.sp,
                                color = Color.Blue,
                                fontFamily = FontFamily.Default
                            )){
                                append(stringResource(id = R.string.signup))
                            }

                        }
                    )
                }
            }

        }
    }


}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginView(navController)
}



