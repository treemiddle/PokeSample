package com.treemiddle.core_domain

import com.treemiddle.core_data.MainRepository
import com.treemiddle.core_domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    operator fun invoke(
        limit: Int,
        offset: Int
    ): Flow<List<Pokemon>> {
        return mainRepository.fetchPokemonList(limit, offset)
            .map {
                it.map { pokemon ->
                    Pokemon(
                        name = pokemon.name,
                        url = pokemon.url
                    )
                }
            }
    }
}
