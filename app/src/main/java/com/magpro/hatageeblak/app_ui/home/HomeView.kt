package com.magpro.hatageeblak.app_ui.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.magpro.hatageeblak.app_ui.home.home_navigations.HomeBottomScreens
import com.magpro.hatageeblak.app_ui.home.home_navigations.HomeNavigationGraph
import com.magpro.hatageeblak.services.AppServices
import androidx.compose.material3.Text
import androidx.compose.material.Icon
import androidx.compose.material.Text


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    val navController = rememberNavController()
    val services = AppServices.Colors()

    Scaffold(


        topBar = { HomeTopBar(services) },


        bottomBar = { HomeBottomBar(navController = navController, services = services) },


        floatingActionButton = { HomeActionButton(services = services)}


    ) {
        HomeNavigationGraph(navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(services: AppServices.Colors) {
    TopAppBar(
        title = { Text(text = "title", fontSize = 17.sp) },
        modifier = Modifier.clip(shape = RoundedCornerShape(bottomStart = 21.dp, bottomEnd = 21.dp)),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = services.lightGray,
            navigationIconContentColor = services.blackColor,
            titleContentColor = services.blackColor,
            actionIconContentColor = services.blackColor
        ),
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "icon info",
                    tint = services.blackColor
                )
            }
        }
    )
}


@Composable
fun HomeActionButton(services: AppServices.Colors) {
    val context = LocalContext.current
    FloatingActionButton(
        onClick ={ Toast.makeText(context,"Floating action button", Toast.LENGTH_SHORT).show() },
        shape = RoundedCornerShape(33.dp),
        contentColor = services.blackColor,
        containerColor = services.lightGray,
        modifier = Modifier.padding(bottom = 33.dp)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "add icon")
    }
}

@Composable
fun HomeExtendedFloatingActionButton(services: AppServices.Colors) {
    val context = LocalContext.current
    ExtendedFloatingActionButton(
        onClick ={ Toast.makeText(context,"Floating action button", Toast.LENGTH_SHORT).show() },
        shape = RoundedCornerShape(27.dp),
        contentColor = services.blackColor,
        containerColor = services.lightGray,
        modifier = Modifier.padding(bottom = 33.dp)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "add icon")
        Text(text = "Add new order", fontSize = 13.sp)
    }
}


@Composable
fun HomeBottomBar(navController: NavHostController, services: AppServices.Colors) {
    val screens = listOf(
        HomeBottomScreens.One,
        HomeBottomScreens.Two,
        HomeBottomScreens.Three,
        HomeBottomScreens.Four
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 21.dp, topEnd = 21.dp))
    ) {
        screens.forEach { screen ->
            addItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                services = services
            )
        }
    }
}

@Composable
fun RowScope.addItem(screen: HomeBottomScreens, currentDestination: NavDestination?, navController: NavHostController, services: AppServices.Colors) {
    BottomNavigationItem(
        label = { Text(text = screen.title, fontSize = 11.sp, modifier = Modifier.padding(top = 3.dp)) },
        onClick = {
            navController.navigate(screen.rout){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = { Icon(imageVector = screen.icon, contentDescription = "navigation icon") },
        modifier = Modifier.fillMaxWidth().background(services.lightGray),
        selected = currentDestination?.hierarchy?.any { it.route == screen.rout } == true,
        selectedContentColor = services.blackColor,
        unselectedContentColor = services.grayColor
    )
}


@Preview
@Composable
fun HPreview() {
    HomeView()
}






