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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CreatePassword(navController: NavController) {

    val context = LocalContext.current
    val maxLength = 7
    val services = AppServices.Colors()

    var code by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmValue by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var passwordRecoverVisibility by remember { mutableStateOf(false) }


    val icon = if (passwordVisibility) painterResource(id = R.drawable.ic_visibility_on)
    else painterResource(id = R.drawable.ic_visibility_off)

    val recoverIcon =
        if (passwordRecoverVisibility) painterResource(id = R.drawable.ic_visibility_on)
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
                .padding(start = 21.dp, end = 21.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 21.dp, end = 7.dp),
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
                text = stringResource(id = R.string.create_password),
                color = Color.Black,
                fontSize = 21.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 21.dp)
            )
            Spacer(modifier = Modifier.height(33.dp))


            TextField(
                value = code,
                onValueChange = { code = it },
                label = { Text(text = stringResource(id = R.string.verify_code)) },
                singleLine = true,
                maxLines = 1,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "verification_icon"
                    )
                },
                placeholder = { Text(text = stringResource(id = R.string.code_has_sent)) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Number,
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
            )


            TextField(
                value = password,
                onValueChange = { if (it.length <= maxLength) password = it },
                label = { Text(text = stringResource(id = R.string.password)) },
                singleLine = true,
                maxLines = 1,
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
                placeholder = { Text(text = "******") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.NumberPassword,
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
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )


            TextField(
                value = confirmValue,
                onValueChange = { if (it.length <= maxLength) confirmValue = it },
                label = { Text(text = stringResource(id = R.string.confirm_password)) },
                singleLine = true,
                maxLines = 1,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "password_icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordRecoverVisibility = !passwordRecoverVisibility
                    }) {
                        Icon(
                            painter = recoverIcon, contentDescription = "visibility icon"
                        )
                    }
                },
                placeholder = { Text(text = "******") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.NumberPassword,
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
                visualTransformation = if (passwordRecoverVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )








            Row(modifier = Modifier.padding(vertical = 21.dp)) {
                Button(
                    onClick = {
                        if (code.isNotEmpty() && password.isNotEmpty() && confirmValue.isNotEmpty()) {
                            if (password == confirmValue) {
                                navController.navigate(AccountScreens.AccountScreenLogin.rout)
                            } else {
                                toastMessage(context, "Not matches")
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
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
                        text = stringResource(id = R.string.save),
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
fun RecoverPasswordPreview() {
    val navController = rememberNavController()
    CreatePassword(navController = navController)
}
