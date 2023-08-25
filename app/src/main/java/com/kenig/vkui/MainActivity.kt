package com.kenig.vkui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kenig.vkui.ui.theme.MainScreen
import com.kenig.vkui.ui.theme.VkUiTheme


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkUiTheme {
                MainScreen(viewModel)
            }
        }
    }
}




