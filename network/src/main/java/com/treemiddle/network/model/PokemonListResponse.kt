package com.treemiddle.network.model

import com.treemiddle.core.model.Pokemon

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)
