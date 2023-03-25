package com.taqwa.plus.ui

import PdfViewer
import Start
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start") {
        composable(route = "start") {
            Start(navController)
        }

        composable(
            route = "1/{surh}",
            arguments = listOf(
                navArgument(name = "surh") {
                    type = NavType.StringType
                }
            )
        ) {
            PdfViewer(
                filePath = it.arguments?.getString("surh"), navController
            )
        }
    }
}