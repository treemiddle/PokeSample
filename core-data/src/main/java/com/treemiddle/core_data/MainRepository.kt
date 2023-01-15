package com.treemiddle.core_data

import com.treemiddle.core.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun fetchPokemonList(
        limit: Int,
        offset: Int
    ): List<Pokemon>
}
