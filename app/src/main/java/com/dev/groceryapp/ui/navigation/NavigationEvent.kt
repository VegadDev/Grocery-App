package com.dev.groceryapp.ui.navigation

import com.dev.groceryapp.ui.navigation.NavigationCommand

data class NavigationEvent(
    val command: NavigationCommand,
    val id: Long = System.currentTimeMillis()
)
