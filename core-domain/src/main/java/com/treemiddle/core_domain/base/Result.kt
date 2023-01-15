package com.treemiddle.core_domain.base

sealed class Result<out R> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
