package com.treemiddle.core_domain

import com.treemiddle.core_data.MainRepository
import com.treemiddle.core_domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.treemiddle.core.model.Pokemon as CoreModel

class GetPokemonListUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    operator fun invoke(
        limit: Int,
        offset: Int
    ): Flow<List<Pokemon>> {
        return mainRepository.fetchPokemonList(limit, offset)
            .map { it.toDomain() }
    }
}

private fun List<CoreModel>.toDomain(): List<Pokemon> {
    return this.map {
        Pokemon(
            name = it.name,
            url = it.url
        )
    }
}
