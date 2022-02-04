package com.example.composetablayout

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun TabPage(pagerState: PagerState, tabItems: List<TabItem>) {
    HorizontalPager(count = tabItems.size, state = pagerState) { index ->
        tabItems[index].screenToLoad()
    }
}

@Composable
fun TextTabLayout(
    tabItems: List<TabItem>,
    selectedIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectedIndex) {
        tabItems.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectedIndex, onClick = { onPageSelected(tabItem) }, text = {
                Text(text = tabItem.title)
            })
        }
    }
}

@Composable
fun IconTabLayout(
    tabItems: List<TabItem>,
    selectedIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectedIndex) {
        tabItems.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectedIndex, onClick = { onPageSelected(tabItem) }, icon = {
                Icon(tabItem.icon, contentDescription = "")
            })
        }
    }
}

@Composable
fun ScrollableTabLayout(
    tabItems: List<TabItem>,
    selectedIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    ScrollableTabRow(selectedTabIndex = selectedIndex) {
        tabItems.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectedIndex, onClick = { onPageSelected(tabItem) }, text = {
                Text(text = tabItem.title)
            }, icon = {
                Icon(tabItem.icon, contentDescription = "")
            })
        }
    }
}

@Composable
fun IconWithTextTabLayout(
    tabItems: List<TabItem>,
    selectedIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectedIndex) {
        tabItems.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectedIndex, onClick = { onPageSelected(tabItem) }, text = {
                Text(text = tabItem.title)
            }, icon = {
                Icon(tabItem.icon, contentDescription = "")
            })
        }
    }
}
