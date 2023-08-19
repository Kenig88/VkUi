package com.kenig.vkui.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.kenig.vkui.R

sealed class NavigationItem(val titleResId: Int, val icon: ImageVector) { //sealed - это такой класс, внутри которого можно объявить всех его наследников и потом использовать их где надо

    object Home : NavigationItem(R.string.main, Icons.Filled.Home)

    object Favorite : NavigationItem(R.string.favorite, Icons.Filled.Favorite)

    object Person : NavigationItem(R.string.profile, Icons.Filled.Person)

}

