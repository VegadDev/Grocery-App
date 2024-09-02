package com.dev.groceryapp.ui.main.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groceryapp.repository.DataRepository
import com.dev.groceryapp.ui.navigation.AppScreens
import com.dev.groceryapp.ui.navigation.NavigationCommand
import com.dev.groceryapp.ui.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject
constructor(
  private val navigator: Navigator,
  private val dataRepository: DataRepository
) : ViewModel() {

  private val _uiState = MutableStateFlow(DashboardUiState())
  val uiState = _uiState.asStateFlow()

  val interActor = object : DashboardInterActor {

    override fun gotoSetting() {
      navigator.navigate(NavigationCommand.To(AppScreens.SettingScreen.route))
    }

  }

  init {
      viewModelScope.launch {
        _uiState.value = uiState.value.copy(
          totalStudents = invoke(totalS = dataRepository.getTotalStudents()),
          totalShift = invoke(totalS = dataRepository.getTotalShifts())
        )
      }
  }

  suspend operator fun invoke(totalS: Int): Int {
    return totalS
  }

}