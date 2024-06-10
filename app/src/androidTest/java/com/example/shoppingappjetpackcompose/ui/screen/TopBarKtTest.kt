package com.example.shoppingappjetpackcompose.ui.screen


import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Test class
@RunWith(AndroidJUnit4::class)
class MyTopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMyTopAppBarDisplaysTitle() {
        // Set the composable content
        composeTestRule.setContent {
            MaterialTheme {
                MyTopAppBar()
            }
        }

        // Check that the title is displayed
        composeTestRule.onNodeWithText("Store")
            .assertIsDisplayed()
            .assertTextEquals("Store")
    }
}



