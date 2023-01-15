package com.treemiddle.core_data.repository

import com.treemiddle.core.model.Pokemon
import com.treemiddle.core_data.MainRepository
import com.treemiddle.network.Dispatcher
import com.treemiddle.network.NetworkDataSource
import com.treemiddle.network.NetworkDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    @Dispatcher(NetworkDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : MainRepository {
    override fun fetchPokemonList(limit: Int, offset: Int): Flow<List<Pokemon>> = flow {
        val pokemonList = networkDataSource.fetchPokemonList(limit, offset).results
        if (pokemonList.isNotEmpty()) {
            emit(pokemonList)
        } else {
            emit(emptyList())
        }
    }.flowOn(ioDispatcher)
}
