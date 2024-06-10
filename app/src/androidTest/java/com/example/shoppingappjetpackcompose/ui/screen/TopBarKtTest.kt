package com.example.shoppingappjetpackcompose.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//test if the text "Screen" is being displayed

@RunWith(AndroidJUnit4::class)
class TopBarKtTest{

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMyTopAppBar(){
        composeTestRule.setContent {
            MyTopAppBar()
        }
        composeTestRule.onNodeWithText("Store").assertIsDisplayed()
    }

}