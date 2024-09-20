package com.dev.groceryapp.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.groceryapp.R
import com.dev.groceryapp.ui.main.Cart.ProfileScreen
import com.dev.groceryapp.ui.main.Cart.CartViewModel
import com.dev.groceryapp.ui.main.dashboard.DashboardScreen
import com.dev.groceryapp.ui.main.dashboard.DashboardViewModel
import com.dev.groceryapp.ui.main.setting.SettingScreen
import com.dev.groceryapp.ui.main.setting.SettingsViewModel


sealed class AppScreens(val route: String , val icon: Int? = null) {

  data object DashboardScreen : AppScreens("DashboardScreen" , icon = R.drawable.ic_launcher_foreground)
  data object SettingScreen : AppScreens("SettingScreen", icon = R.drawable.ic_launcher_foreground)
  data object ProfileScreen : AppScreens("ProfileScreen", icon = R.drawable.ic_launcher_foreground)

}

val screens = listOf(

  Screen(AppScreens.DashboardScreen.route) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    DashboardScreen(uiState, viewModel.interActor)
  },
  Screen(AppScreens.SettingScreen.route) {
    val viewModel = hiltViewModel<SettingsViewModel>()
    SettingScreen(viewModel.interActor)
  },
  Screen(AppScreens.ProfileScreen.route){
    val viewModel = hiltViewModel<CartViewModel>()
    ProfileScreen()
  }


)