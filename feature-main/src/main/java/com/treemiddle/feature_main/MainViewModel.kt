package com.treemiddle.feature_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.treemiddle.core_domain.GetPokemonListUseCase
import com.treemiddle.core_domain.base.Result
import com.treemiddle.core_domain.model.Pokemon
import com.treemiddle.core_domain.params.PokemonListUseCaseParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonUistate = MutableStateFlow<PokemonListUiState>(PokemonListUiState.Loading)
    val pokemonListUiState: StateFlow<PokemonListUiState>
        get() = _pokemonUistate

    init {
        viewModelScope.launch {
            when (
                val result = getPokemonListUseCase(
                    PokemonListUseCaseParams(20, 20)
                )
            ) {
                is Result.Success -> {
                    _pokemonUistate.emit(PokemonListUiState.Success(result.data))
                }
                is Result.Error -> {
                    _pokemonUistate.emit(PokemonListUiState.Error)
                }
            }
        }
    }
}

sealed interface PokemonListUiState {
    data class Success(val pokemonList: List<Pokemon>) : PokemonListUiState
    object Error : PokemonListUiState
    object Loading : PokemonListUiState
}
