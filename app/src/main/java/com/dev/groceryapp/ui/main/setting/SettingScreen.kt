package com.dev.groceryapp.ui.main.setting

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.groceryapp.R
import com.dev.groceryapp.ui.common.CustomIcon
import com.dev.groceryapp.ui.theme.AppTheme

@Composable
fun SettingScreen(interActor: SettingInterActor?) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Support",
                        style = AppTheme.textStyles.extraBold.large,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 23.dp, bottom = 10.dp)
                    )

                    Card(
                        colors = CardDefaults.cardColors(AppTheme.colors.cardBackgroundColor),
                        border = BorderStroke(width = 0.2.dp, color = AppTheme.colors.outlineVariant),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Rate App",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                        Divider(
                            color = AppTheme.colors.surfaceVariant,
                            thickness = 1.dp,
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Contact Us",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                        Divider(
                            color = AppTheme.colors.surfaceVariant,
                            thickness = 1.dp,
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "About Us",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }

                    Text(
                        text = "Support",
                        style = AppTheme.textStyles.extraBold.large,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 23.dp, bottom = 10.dp, top = 20.dp)
                    )

                    Card(
                        colors = CardDefaults.cardColors(AppTheme.colors.cardBackgroundColor),
                        border = BorderStroke(width = 0.2.dp, color = AppTheme.colors.outlineVariant),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Terms and Conditions",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                        Divider(
                            color = AppTheme.colors.surfaceVariant,
                            thickness = 1.dp,
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Privacy Policy",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }


                    Card(
                        colors = CardDefaults.cardColors(AppTheme.colors.cardBackgroundColor),
                        border = BorderStroke(width = 0.2.dp, color = AppTheme.colors.outlineVariant),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 30.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Logout",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Support",
                        style = AppTheme.textStyles.extraBold.large,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 23.dp, bottom = 10.dp)
                    )

                    Card(
                        colors = CardDefaults.cardColors(AppTheme.colors.cardBackgroundColor),
                        border = BorderStroke(width = 0.2.dp, color = AppTheme.colors.outlineVariant),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Rate App",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                        Divider(
                            color = AppTheme.colors.surfaceVariant,
                            thickness = 1.dp,
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Contact Us",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                        Divider(
                            color = AppTheme.colors.surfaceVariant,
                            thickness = 1.dp,
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "About Us",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }

                    Text(
                        text = "Support",
                        style = AppTheme.textStyles.extraBold.large,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 23.dp, bottom = 10.dp, top = 20.dp)
                    )

                    Card(
                        colors = CardDefaults.cardColors(AppTheme.colors.cardBackgroundColor),
                        border = BorderStroke(width = 0.2.dp, color = AppTheme.colors.outlineVariant),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Terms and Conditions",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                        Divider(
                            color = AppTheme.colors.surfaceVariant,
                            thickness = 1.dp,
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Privacy Policy",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }


                    Card(
                        colors = CardDefaults.cardColors(AppTheme.colors.cardBackgroundColor),
                        border = BorderStroke(width = 0.2.dp, color = AppTheme.colors.outlineVariant),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 30.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {
                            CustomIcon(
                                icon = R.drawable.ic_launcher_foreground,
                                modifier = Modifier.padding(start = 10.dp , top = 5.dp),
                                imageModifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "Logout",
                                style = AppTheme.textStyles.extraBold.regular,
                                modifier = Modifier
                                    .padding(start = 60.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                    }

                }
            }
        }



    }


}

@Preview
@Composable
fun ViewScreen() {
    SettingScreen(object : SettingInterActor {
        override fun onBackPress() {}
    })
}