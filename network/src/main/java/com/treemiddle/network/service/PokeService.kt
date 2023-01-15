package com.treemiddle.network.service

import com.treemiddle.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("ability/")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): PokemonListResponse
}
