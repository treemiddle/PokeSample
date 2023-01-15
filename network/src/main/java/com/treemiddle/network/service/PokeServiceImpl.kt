package com.treemiddle.network.service

import com.treemiddle.network.NetworkDataSource
import com.treemiddle.network.model.PokemonListResponse
import javax.inject.Inject

class PokeServiceImpl @Inject constructor(
    private val pokeService: PokeService
) : NetworkDataSource {
    override suspend fun fetchPokemonList(limit: Int, offset: Int): PokemonListResponse {
        return pokeService.fetchPokemonList(limit, offset)
    }
}
