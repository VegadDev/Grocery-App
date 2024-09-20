package com.dev.groceryapp.ui.main.setting

import androidx.lifecycle.ViewModel
import com.dev.groceryapp.ui.main.setting.SettingInterActor
import dagger.hilt.android.lifecycle.HiltViewModel
import com.dev.groceryapp.ui.navigation.NavigationCommand
import com.dev.groceryapp.ui.navigation.Navigator
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject
constructor(
  private val navigator: Navigator
) : ViewModel() {

  val interActor = object : SettingInterActor {

    override fun onBackPress() {
      navigator.navigate(NavigationCommand.Back)
    }

  }
}