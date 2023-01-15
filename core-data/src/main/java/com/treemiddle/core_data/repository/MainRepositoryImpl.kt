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
    override suspend fun fetchPokemonList(limit: Int, offset: Int): List<Pokemon> {
        return networkDataSource.fetchPokemonList(limit, offset).results
    }
//        val pokemonList = networkDataSource.fetchPokemonList(limit, offset).results
//        emit(pokemonList)
//    }
//        .flowOn(ioDispatcher)
}
