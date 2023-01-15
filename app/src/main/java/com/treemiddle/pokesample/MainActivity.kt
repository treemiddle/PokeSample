package com.treemiddle.pokesample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.treemiddle.feature_main.navigation.mainRoute
import com.treemiddle.feature_main.navigation.onMainRoute
import com.treemiddle.pokesample.theme.PokemonAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokeAppUi()
        }
    }
}

@Composable
fun PokeAppUi() {
    PokemonAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            PokemonNavigationGraph()
        }
    }
}

@Composable
fun PokemonNavigationGraph() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = mainRoute
    ) {
        onMainRoute()
    }
}
