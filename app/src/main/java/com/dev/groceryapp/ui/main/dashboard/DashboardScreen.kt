package com.dev.groceryapp.ui.main.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.groceryapp.ui.theme.AppTheme


@Composable
fun DashboardScreen(uiState: DashboardUiState, interActor: DashboardInterActor) {


    var showDialog by remember {
        mutableStateOf(false)
    }



    MainLayout(
        onSettingClick = {
            interActor.gotoSetting()
        }
    )


}

@Preview
@Composable
fun ViewDashboardScreen() {

    DashboardScreen(uiState = DashboardUiState(), object : DashboardInterActor {

        override fun gotoSetting() {}

    })
}



@Composable
fun MainLayout(
    onSettingClick: () -> Unit,
) {
    Column {
        Button(onClick = { onSettingClick() }) {

        }
    }
}


@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isClickable: Boolean = true,
    function: @Composable () -> Unit = {},
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.onPrimary),
        modifier = modifier
            .then(
                if (isClickable) Modifier.clickable { onClick() } else Modifier
            )
    ) {
        function()
    }
}

@Composable
fun CustomIcon(icon: Int, modifier: Modifier, imageModifier: Modifier) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(35.dp)
            .background(Color.Transparent)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(AppTheme.colors.textColorMedium),
            modifier = imageModifier.fillMaxSize()
        )

    }
}


@Composable
fun AddButton(modifier: Modifier = Modifier, onAddClick: () -> Unit = {}) {

    Box(
        modifier = modifier.padding(end = 20.dp, bottom = 20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { onAddClick() },
            containerColor = AppTheme.colors.primary
        ) {
            Text(
                text = "+",
                fontSize = 35.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }

    }

}


@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier
            .padding(top = 6.dp)
            .fillMaxWidth(0.9f),
        thickness = 1.5.dp,
        color = Color.LightGray
    )
}
