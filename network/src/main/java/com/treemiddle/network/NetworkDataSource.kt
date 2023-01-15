package com.treemiddle.network

import com.treemiddle.network.model.PokemonListResponse

interface NetworkDataSource {
    suspend fun fetchPokemonList(
        limit: Int,
        offset: Int
    ): PokemonListResponse
}
