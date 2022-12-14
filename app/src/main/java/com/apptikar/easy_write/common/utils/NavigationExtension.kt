package com.apptikar.easy_write.common.utils

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true

    }


fun NavHostController.navigateToInclusive(route: String) {
    this.navigate(route){
        popUpTo(0)
    }
}


