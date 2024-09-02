package com.dev.groceryapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.groceryapp.R

val customFontFamily = FontFamily(Font(resId = R.font.rubik))

val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  )
)


data class SizeOfText(
  private val fontWeight: FontWeight,
  private val density: Density,
  val regular: TextStyle = TextStyle(fontWeight = fontWeight, fontFamily = customFontFamily, fontSize = with(density){ 16f.dp.toSp().value }.sp),
  val small: TextStyle = TextStyle(fontWeight = fontWeight, fontFamily = customFontFamily, fontSize = with(density){ 14f.dp.toSp().value }.sp),
  val extraSmall: TextStyle = TextStyle(fontWeight = fontWeight, fontFamily = customFontFamily, fontSize = with(density){ 12f.dp.toSp().value }.sp),
  val large: TextStyle = TextStyle(fontWeight = fontWeight, fontFamily = customFontFamily, fontSize = with(density){ 18f.dp.toSp().value }.sp),
  val extraLarge: TextStyle = TextStyle(fontWeight = fontWeight, fontFamily = customFontFamily, fontSize = with(density){ 24f.dp.toSp().value }.sp)
)

/**
 * Weight+Size
 */
data class AppTypography(
  private val density: Density,
  val thin: SizeOfText = SizeOfText(fontWeight = FontWeight.Thin, density = density),
  val extraLight: SizeOfText = SizeOfText(fontWeight = FontWeight.ExtraLight, density = density),
  val light: SizeOfText = SizeOfText(fontWeight = FontWeight.Light, density = density),
  val regular: SizeOfText = SizeOfText(fontWeight = FontWeight.Normal, density = density),
  val medium: SizeOfText = SizeOfText(fontWeight = FontWeight.Medium, density = density),
  val semiBold: SizeOfText = SizeOfText(fontWeight = FontWeight.SemiBold, density = density),
  val bold: SizeOfText = SizeOfText(fontWeight = FontWeight.Bold, density = density),
  val extraBold: SizeOfText = SizeOfText(fontWeight = FontWeight.ExtraBold, density = density),
  val black: SizeOfText = SizeOfText(fontWeight = FontWeight.Black, density = density),
)

