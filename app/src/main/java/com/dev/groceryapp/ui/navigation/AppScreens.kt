package com.dev.groceryapp.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.groceryapp.ui.main.dashboard.DashboardScreen
import com.dev.groceryapp.ui.main.dashboard.DashboardViewModel
import com.dev.groceryapp.ui.main.setting.SettingScreen
import com.dev.groceryapp.ui.main.setting.SettingsViewModel


sealed class AppScreens(val route: String) {
  data object SplashScreen : AppScreens("SplashScreen")
  data object IntroScreen : AppScreens("IntroScreen")
  data object LoginScreen : AppScreens("LoginScreen")
  data object LoadingScreen : AppScreens("LoadingScreen")
  data object DashboardScreen : AppScreens("DashboardScreen")
  data object PrivacyPolicyScreen : AppScreens("PrivacyPolicyScreen")
  data object TermsAndConditionsScreen : AppScreens("TermsAndConditionsScreen")
  data object AboutUsScreen : AppScreens("AboutUsScreen")
  data object UpdateAppScreen : AppScreens("UpdateAppScreen")
  data object SettingScreen : AppScreens("SettingScreen")
  data object StudentListScreen : AppScreens("StudentListScreen")
  data object Staff_StudentLoginScreen : AppScreens("Staff_StudentLoginScreen")
  data object CreateLibraryScreen : AppScreens("CreateLibraryScreen")
  data object AddStaffScreen : AppScreens("AddStaffScreen")
  data object AddStudentScreen : AppScreens("AddStudentScreen")
  data object AddStudentPlanScreen : AppScreens("AddStudentPlanScreen")
  data object SeatListScreen : AppScreens("SeatListScreen")
  data object PlanListScreen : AppScreens("PlanListScreen")
  data object StudentProfileScreen : AppScreens("StudentProfileScreen")
  data object CollectedFeesScreen : AppScreens("CollectedFeesScreen")
  data object EnquiryScreen : AppScreens("EnquiryScreen")
  data object EnquiryProfileScreen : AppScreens("EnquiryProfileScreen")
  data object LibraryListScreen : AppScreens("LibraryListScreen")
  data object StudentAttendanceScreen : AppScreens("StudentAttendanceScreen")
  data object StaffListScreen : AppScreens("StaffListScreen")
  data object StaffProfileScreen : AppScreens("StaffProfileScreen")
  data object DueFeesScreen : AppScreens("DueFeesScreen")
  data object InvoiceScreen : AppScreens("InvoiceScreen")
  data object StaffAttendanceScreen : AppScreens("StaffAttendanceScreen")
  data object ExpenseScreen : AppScreens("ExpenseScreen")
  data object AddPlanScreen : AppScreens("AddPlanScreen")
  data object AddEnquiryScreen : AppScreens("AddEnquiryScreen")
  data object AttendanceListScreen : AppScreens("AttendanceListScreen")

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


)