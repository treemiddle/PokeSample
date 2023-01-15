package com.treemiddle.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val networkDispatchers: NetworkDispatchers)

enum class NetworkDispatchers {
    IO
}
