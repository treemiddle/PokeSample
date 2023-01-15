package com.treemiddle.core_domain

import com.treemiddle.core_data.MainRepository
import com.treemiddle.core_domain.base.ResultUseCase
import com.treemiddle.core_domain.model.Pokemon
import com.treemiddle.core_domain.params.PokemonListUseCaseParams
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val mainRepository: MainRepository
) : ResultUseCase<PokemonListUseCaseParams, List<Pokemon>>() {
    override suspend fun execute(params: PokemonListUseCaseParams): List<Pokemon> {
        return mainRepository.fetchPokemonList(params.limit, params.offset)
            .map {
                Pokemon(
                    name = it.name,
                    url = it.url
                )
            }
    }
}
