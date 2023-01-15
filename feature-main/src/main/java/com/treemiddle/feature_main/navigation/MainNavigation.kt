package com.treemiddle.feature_main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.treemiddle.feature_main.MainRoute

const val mainRoute = "main_route"

fun NavGraphBuilder.onMainRoute() {
    composable(route = mainRoute) {
        MainRoute()
    }
}
