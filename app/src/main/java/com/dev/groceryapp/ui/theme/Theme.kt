package com.dev.groceryapp.ui.theme

import android.app.Activity
import android.content.ContextWrapper
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private val lightColorScheme = lightColorScheme(
  primary = customAppColorsLight.primary,
  onPrimary = customAppColorsLight.onPrimary,
  primaryContainer = customAppColorsLight.primaryContainer,
  onPrimaryContainer = customAppColorsLight.onPrimaryContainer,
  secondary = customAppColorsLight.secondary,
  onSecondary = customAppColorsLight.onSecondary,
  secondaryContainer = customAppColorsLight.secondaryContainer,
  onSecondaryContainer = customAppColorsLight.onSecondaryContainer,
  tertiary = customAppColorsLight.tertiary,
  onTertiary = customAppColorsLight.onTertiary,
  tertiaryContainer = customAppColorsLight.tertiaryContainer,
  onTertiaryContainer = customAppColorsLight.onTertiaryContainer,
  error = customAppColorsLight.error,
  onError = customAppColorsLight.onError,
  errorContainer = customAppColorsLight.errorContainer,
  onErrorContainer = customAppColorsLight.onErrorContainer,
  outline = customAppColorsLight.outline,
  background = customAppColorsLight.background,
  onBackground = customAppColorsLight.onBackground,
  surface = customAppColorsLight.surface,
  onSurface = customAppColorsLight.onSurface,
  surfaceVariant = customAppColorsLight.surfaceVariant,
  onSurfaceVariant = customAppColorsLight.onSurfaceVariant,
  inverseSurface = customAppColorsLight.inverseSurface,
  inverseOnSurface = customAppColorsLight.inverseOnSurface,
  inversePrimary = customAppColorsLight.inversePrimary,
  surfaceTint = customAppColorsLight.surfaceTint,
  outlineVariant = customAppColorsLight.outlineVariant,
  scrim = customAppColorsLight.scrim,
)

private val darkColorScheme = darkColorScheme(
  primary = customAppColorsDark.primary,
  onPrimary = customAppColorsDark.onPrimary,
  primaryContainer = customAppColorsDark.primaryContainer,
  onPrimaryContainer = customAppColorsDark.onPrimaryContainer,
  secondary = customAppColorsDark.secondary,
  onSecondary = customAppColorsDark.onSecondary,
  secondaryContainer = customAppColorsDark.secondaryContainer,
  onSecondaryContainer = customAppColorsDark.onSecondaryContainer,
  tertiary = customAppColorsDark.tertiary,
  onTertiary = customAppColorsDark.onTertiary,
  tertiaryContainer = customAppColorsDark.tertiaryContainer,
  onTertiaryContainer = customAppColorsDark.onTertiaryContainer,
  error = customAppColorsDark.error,
  onError = customAppColorsDark.onError,
  errorContainer = customAppColorsDark.errorContainer,
  onErrorContainer = customAppColorsDark.onErrorContainer,
  outline = customAppColorsDark.outline,
  background = customAppColorsDark.background,
  onBackground = customAppColorsDark.onBackground,
  surface = customAppColorsDark.surface,
  onSurface = customAppColorsDark.onSurface,
  surfaceVariant = customAppColorsDark.surfaceVariant,
  onSurfaceVariant = customAppColorsDark.onSurfaceVariant,
  inverseSurface = customAppColorsDark.inverseSurface,
  inverseOnSurface = customAppColorsDark.inverseOnSurface,
  inversePrimary = customAppColorsDark.inversePrimary,
  surfaceTint = customAppColorsDark.surfaceTint,
  outlineVariant = customAppColorsDark.outlineVariant,
  scrim = customAppColorsDark.scrim,
)

val LocalAppColor = compositionLocalOf { customAppColorsLight }
val LocalAppTypography = compositionLocalOf { AppTypography(Density(3.0F, 1.0F)) }
//val LocalSharePrefs = compositionLocalOf<Shareprefs> { error("No SharePrefs") }

object AppTheme {

  val colors: AppColors
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColor.current

  val textStyles: AppTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalAppTypography.current

  val activity: Activity?
    @Composable
    @ReadOnlyComposable
    get() {
      var context = LocalContext.current
      while (context is ContextWrapper) {
        if (context is Activity) {
          return context
        }
        context = context.baseContext
      }
      return null
    }
}


@Composable
fun GroceryAppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  viewModel: GroceryAppThemeViewModel = hiltViewModel(),
  content: @Composable () -> Unit
) {

  val density = LocalDensity.current

  val colorScheme = when {
    darkTheme -> darkColorScheme
    else -> lightColorScheme
  }
  val tufeeColors = if (darkTheme) customAppColorsDark else customAppColorsLight
  val appTypography = remember { AppTypography(density = density) }
  //val shareprefs = viewModel.getSharePrefs()

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = {
      CompositionLocalProvider(
        LocalAppColor provides tufeeColors,
        LocalAppTypography provides appTypography,
        //LocalSharePrefs provides shareprefs
      ) {
        content()
      }
    }
  )
}

@HiltViewModel
class GroceryAppThemeViewModel
@Inject
constructor(
  //private val shareprefs: Shareprefs
) : ViewModel() {
  //fun getSharePrefs() = shareprefs

}