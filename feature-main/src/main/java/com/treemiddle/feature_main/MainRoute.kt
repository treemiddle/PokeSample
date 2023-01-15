package com.treemiddle.feature_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainRoute(viewModel: MainViewModel = hiltViewModel()) {
    val pokemonListUiState by viewModel.pokemonListUiState.collectAsStateWithLifecycle()

    MainScreen(pokemonListUiState = pokemonListUiState)
}

@Composable
fun MainScreen(pokemonListUiState: PokemonListUiState) {
    val state = pokemonListUiState
    if (state is PokemonListUiState.Loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }

    if (state is PokemonListUiState.Success) {
        LazyColumn {
            items(state.pokemonList) {
                Text(text = it.name)
            }
        }
    }
}
