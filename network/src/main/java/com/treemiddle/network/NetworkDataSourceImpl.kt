package com.treemiddle.network

import com.treemiddle.network.model.PokemonListResponse
import com.treemiddle.network.service.PokeService
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val pokeService: PokeService
) : NetworkDataSource {
    override suspend fun fetchPokemonList(limit: Int, offset: Int): PokemonListResponse {
        return pokeService.fetchPokemonList(limit, offset)
    }
}
