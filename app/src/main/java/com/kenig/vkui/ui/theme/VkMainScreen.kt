package com.kenig.vkui.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kenig.vkui.MainViewModel
import com.kenig.vkui.navigation.AppNavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState() //тут будет сохраняться текущий экран
                val currentRoute =
                    navBackStackEntry?.destination?.route //когда state navBackStack изменится произойдёт рекомпозиция и я получу Route который открыт и обновится BottomNavItem
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )
                items.forEach { navigationItem ->
                    BottomNavigationItem(
                        selected = currentRoute == navigationItem.screen.route, //так-же обновится Selected у того элемента который сейчас открыт и виден
                        onClick = { navHostController.navigate(navigationItem.screen.route) },
                        icon = {
                            Icon(navigationItem.icon, contentDescription = "null")
                        },
                        label = {
                            Text(text = stringResource(navigationItem.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) {
        AppNavGraph(
            navController = navHostController,
            homeScreenContent = { HomeScreen(viewModel = viewModel) },
            favoriteScreenContent = { TextCounter(name = "Favorite") },
            profileScreenContent = { TextCounter(name = "Profile") }
        )
    }
}

@Composable
fun TextCounter(name: String) {
    var count by remember {
        mutableStateOf(0)
    }
    Text(
        modifier = Modifier.clickable {
            count++
        },
        text = "$name Count: $count",
        color = Color.Black
    )
}