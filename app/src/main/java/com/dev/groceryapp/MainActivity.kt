package com.dev.groceryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import com.dev.groceryapp.ui.navigation.AppScreens
import com.dev.groceryapp.ui.navigation.NavigationCommand
import com.dev.groceryapp.ui.navigation.NavigationEvent
import com.dev.groceryapp.ui.navigation.Navigator
import com.dev.groceryapp.ui.navigation.screens
import com.dev.groceryapp.ui.theme.AppTheme
import com.dev.groceryapp.ui.theme.GroceryAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      GroceryAppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = AppTheme.colors.surface) {
          GroceryApp()
          //MainScreen()
        }
      }
    }
  }
}



@Composable
fun GroceryApp(
  navigator: Navigator = hiltViewModel()
) {
  val navController = rememberNavController()
  val navigationCommands by navigator.navigation.collectAsState(
    initial = NavigationEvent(
      NavigationCommand.Idle
    )
  )
  when (val command = navigationCommands.command) {
    NavigationCommand.Back -> navController.popBackStack()
    is NavigationCommand.RouteCommand -> {
      when (command) {
        is NavigationCommand.To -> navController.navigate(command.routeWithArgs)
        is NavigationCommand.ToAndClear -> {
          navController.navigate(command.routeWithArgs) {
            popUpTo(
              navController.currentBackStackEntry?.destination?.route
                ?: return@navigate
            ) { inclusive = true }
          }
        }

        is NavigationCommand.ToAndClearAll -> {
          navController.navigate(command.routeWithArgs) {
            popUpTo(navController.graph.id) {
              inclusive = true
            }
          }
        }

        else -> {}
      }
    }

    NavigationCommand.Idle -> {}
  }

  NavHost(navController = navController, startDestination = AppScreens.DashboardScreen.route) {
    screens.forEach { screen ->
      composable(
        route = "${screen.route}?json={json}",
        arguments = listOf(navArgument("json") {
          type = NavType.StringType
          defaultValue = ""
        })
      ) { backStackEntry ->
        screen.content(backStackEntry)
      }
    }
  }
}


