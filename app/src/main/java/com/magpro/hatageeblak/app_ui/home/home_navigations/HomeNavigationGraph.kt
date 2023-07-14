package com.magpro.hatageeblak.app_ui.home.home_navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.magpro.hatageeblak.app_ui.home.home_tabs.TabFour
import com.magpro.hatageeblak.app_ui.home.home_tabs.TabOne
import com.magpro.hatageeblak.app_ui.home.home_tabs.TabThree
import com.magpro.hatageeblak.app_ui.home.home_tabs.TabTwo

@Composable
fun HomeNavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeBottomScreens.One.rout) {

        composable(HomeBottomScreens.One.rout) {
            TabOne()
        }

        composable(HomeBottomScreens.Two.rout) {
            TabTwo()
        }

        composable(HomeBottomScreens.Three.rout) {
            TabThree()
        }

        composable(HomeBottomScreens.Four.rout) {
            TabFour()
        }

    }

}