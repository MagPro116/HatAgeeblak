package com.magpro.hatageeblak.app_ui.home.home_navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeBottomScreens(
    val rout: String,
    val title: String,
    val icon: ImageVector
) {

    object One : HomeBottomScreens(
        rout = "one",
        title = "One",
        icon = Icons.Default.Home
    )

    object Two : HomeBottomScreens(
        rout = "two",
        title = "Two",
        icon = Icons.Default.Person
    )

    object Three : HomeBottomScreens(
        rout = "three",
        title = "Three",
        icon = Icons.Default.Settings
    )

    object Four : HomeBottomScreens(
        rout = "four",
        title = "Four",
        icon = Icons.Default.Info
    )

}
