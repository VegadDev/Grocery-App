package com.dev.groceryapp.ui.main.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.groceryapp.R
import com.dev.groceryapp.ui.common.CustomCard
import com.dev.groceryapp.ui.common.CustomIcon
import com.dev.groceryapp.ui.common.CustomSearchBar
import com.dev.groceryapp.ui.main.Cart.ProfileScreen
import com.dev.groceryapp.ui.main.setting.SettingScreen
import com.dev.groceryapp.ui.navigation.myNav.NavItem
import com.dev.groceryapp.ui.theme.AppTheme

@Preview
@Composable
fun ViewDashboardScreen() {
    DashboardScreen(uiState = DashboardUiState(), object : DashboardInterActor {
        override fun gotoSetting() {}
        override fun gotoHome() {}
        override fun gotoProfile() {}
    })
}


@Composable
fun DashboardScreen(
    uiState: DashboardUiState = DashboardUiState(),
    interActor: DashboardInterActor
) {
    Main(interActor, uiState)
}


@Composable
fun Main(interActor: DashboardInterActor, uiState: DashboardUiState) {

    val navItemList = listOf(
        NavItem(label = "Home", icon = Icons.Default.Home, 0),
        NavItem(label = "Cart", icon = Icons.Default.ShoppingCart, 5),
        NavItem(label = "Settings", icon = Icons.Default.Settings, 0)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            BadgedBox(badge = {
                                if (navItem.badgeCount > 0) Badge { Text(text = navItem.badgeCount.toString()) }
                            }) {
                                Icon(imageVector = navItem.icon, contentDescription = null)
                            }

                        },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, interActor, uiState)
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    interActor: DashboardInterActor,
    uiState: DashboardUiState
) {
    when (selectedIndex) {
        0 -> MainLayout(onSettingClick = { interActor.gotoSetting() },
            onProfileClick = { interActor.gotoProfile() })

        1 -> ProfileScreen()
        2 -> SettingScreen(interActor = null)
    }
}


@Composable
fun MainLayout(
    onSettingClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
) {


    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = "Welcome",
                    color = AppTheme.colors.textColorLight,
                    style = AppTheme.textStyles.extraBold.large
                )
                Text(
                    text = "Vegad Dev",
                    color = AppTheme.colors.textColorDark,
                    style = AppTheme.textStyles.extraBold.extraLarge
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            CustomIcon(
                icon = R.drawable.user,
                modifier = Modifier,
                imageModifier = Modifier.size(55.dp),
                isClickable = true,
                onClick = { onProfileClick() }
            )
        }

        CustomSearchBar()

        CategoryScreen()


    }


}

@Composable
fun CategoryScreen() {
    // The current selected category, initially "All"
    var selectedCategory by remember { mutableStateOf("All") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Row for selecting categories
        CategorySelectionRow(selectedCategory) { category ->
            selectedCategory = category  // Update the selected category when clicked
        }

        // Display content based on the selected category
        LazyColumn {
            item {
                CategoryContent(selectedCategory)
            }
        }

    }
}

@Composable
fun CategorySelectionRow(selectedCategory: String, onCategorySelected: (String) -> Unit) {
    val categories = listOf("All", "Fruits", "Vegetables", "Dairy")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        categories.forEach { category ->
            CategoryItem(
                category = category,
                isSelected = selectedCategory == category,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

@Composable
fun CategoryItem(category: String, isSelected: Boolean, onClick: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Text(
            text = category,
            fontSize = if (isSelected) 20.sp else 18.sp,
            color = (if (isSelected) AppTheme.colors.green else Color.Gray),
            style = AppTheme.textStyles.extraBold.regular
        )
        Spacer(modifier = Modifier.size(5.dp))
        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dot),
                contentDescription = null,
                tint = AppTheme.colors.green,
                modifier = Modifier.size(10.dp)
            )
        }
    }
}

@Composable
fun CategoryContent(selectedCategory: String) {
    // Display content based on selected category
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        when (selectedCategory) {
            "All" -> AllScreen()
            "Fruits" -> Text(text = "Fruits Section", fontSize = 24.sp)
            "Vegetables" -> Text(text = "Vegetables Section", fontSize = 24.sp)
            "Dairy" -> Text(text = "Dairy Section", fontSize = 24.sp)
        }
    }
}


@Composable
fun AllScreen(modifier: Modifier = Modifier) {

    LazyRow(Modifier.padding(top = 10.dp , bottom = 10.dp)) {
        item {
            ItemCard()
            ItemCard()
            ItemCard()
        }
    }
}


@Composable
fun ItemCard() {
    CustomCard(
        modifier = Modifier
            .width(150.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            CustomIcon(
                icon = R.drawable.tomato,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally),
                imageModifier = Modifier.size(100.dp)
            )
            Column(Modifier.padding(start = 10.dp , top = 5.dp)) {
                Text(
                    text = "Tomato",
                    color = AppTheme.colors.darkblue,
                    fontSize = 21.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    style = AppTheme.textStyles.extraBold.large,
                )
                Text(
                    text = "Fruit",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    style = AppTheme.textStyles.extraBold.regular
                )
                Text(
                    text = "$10.00/KG",
                    color = AppTheme.colors.green,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
                    style = AppTheme.textStyles.extraBold.regular
                )
            }
            CustomCard(
                cardColor = AppTheme.colors.orange,
                modifier = Modifier.fillMaxWidth(),
                cardCorner = 0
            ){
                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        tint = AppTheme.colors.onPrimary,
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        text = "Add to Cart",
                        color = AppTheme.colors.onPrimary,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(6.dp),
                        style = AppTheme.textStyles.extraBold.large,
                    )
                }

            }
        }
    }
    Spacer(modifier = Modifier.size(15.dp))
}
