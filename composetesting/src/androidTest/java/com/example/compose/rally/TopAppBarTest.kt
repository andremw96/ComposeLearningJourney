package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = RallyScreen.values().toList(),
                    onTabSelected = { },
                    currentScreen = RallyScreen.Accounts
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = RallyScreen.values().toList(),
                    onTabSelected = { },
                    currentScreen = RallyScreen.Accounts
                )
            }
        }

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }

    @Test
    fun rallyTopAppBar_correct_state_click() {
        composeTestRule.setContent {
            RallyApp()
        }

        composeTestRule.onRoot().printToLog("RallyApp")
        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Bills.name)
        ).performClick()

        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Bills.name)
        ).assertIsSelected()
    }
}
