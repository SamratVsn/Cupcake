package com.example.cupcake

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CupcakeScreenNavigation {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: NavController

    @Before
    fun setupCupcakeNavHost(){
        composeTestRule.setContent {
            navController = NavController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }

    @Test
    fun cupcakeNavHost_verifyStartDestination(){
        assertEquals(CupcakeScreen.Start.name, navController.currentBackStackEntry?.destination?.route)
    }

}