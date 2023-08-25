package com.kenig.vkui.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.kenig.vkui.R
import com.kenig.vkui.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) { //sealed - это такой класс, внутри которого можно объявить всех его наследников и потом использовать их где надо
    object Home : NavigationItem(
        screen = Screen.NewsFeed,
        R.string.main,
        Icons.Filled.Home
    )

    object Favorite : NavigationItem(
        screen = Screen.Favorite,
        R.string.favorite,
        Icons.Filled.Favorite
    )

    object Profile : NavigationItem(
        screen = Screen.Profile,
        R.string.profile,
        Icons.Filled.Person
    )
}

