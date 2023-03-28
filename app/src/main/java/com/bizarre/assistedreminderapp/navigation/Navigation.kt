package com.bizarre.assistedreminderapp.navigation




import ReminderView3
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bizarre.assistedreminderapp.Graph

import com.bizarre.assistedreminderapp.ui.home.HomeScreen


import com.bizarre.assistedreminderapp.ui.login.LoginScreen
import com.bizarre.assistedreminderapp.ui.login.ProfileScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }

        composable(
            "home/{user}",
              // Fetching the argument which has been passed
        ) {
            val user = it.arguments?.getString("user")


            HomeScreen(user.toString(),navController)    // Using that argument in the destination Composabel
        }









        composable("profile") {
            ProfileScreen(navController = navController)
        }



        composable("reminder") {
           ReminderView3(navController = navController,)
        }
    }
}