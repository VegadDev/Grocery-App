package com.dev.groceryapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.groceryapp.R
import com.dev.groceryapp.ui.theme.AppTheme

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    cardColor: Color = AppTheme.colors.onPrimary,
    cardCorner: Int = 10 ,
    onClick: () -> Unit = {},
    isClickable: Boolean = true,
    function: @Composable () -> Unit = {},
) {

    Card(
        shape = RoundedCornerShape(cardCorner.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        modifier = modifier
            .then(
                if (isClickable) Modifier.clickable { onClick() } else Modifier
            ),
        content = { function() }
    )
}

@Composable
fun CustomIcon(
    icon: Int,
    modifier: Modifier,
    imageModifier: Modifier,
    onClick: () -> Unit = {},
    isClickable: Boolean = false,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(Color.Transparent)
            .then(
                if (isClickable) Modifier.clickable { onClick() } else Modifier
            )
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = imageModifier.fillMaxSize(),
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

@Composable
fun AppTitleBar(
    modifier: Modifier = Modifier,
    title: String = "",
    subTitle: @Composable () -> Unit = {},
    startIcon: Int? = null,
    onBackPress: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIcon(
            icon = R.drawable.ic_back_arrow,
            modifier = Modifier
                .clip(CircleShape)
                .size(24.dp)
                .clickable { onBackPress() }
                .padding(start = 5.dp),
            imageModifier = Modifier
        )
        startIcon?.let { painterResource(id = it) }?.let {
            Icon(
                painter = it,
                contentDescription = "",
                modifier = Modifier
                    .size(35.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = title,
                color = AppTheme.colors.textColorMedium,
                style = AppTheme.textStyles.semiBold.large
            )
            subTitle()
        }
        content()
    }
}