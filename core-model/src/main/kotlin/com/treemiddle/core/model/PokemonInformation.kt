package com.treemiddle.core.model

data class PokemonInformation(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponse>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val exp: Int
) {
    data class TypeResponse(
        val slot: Int,
        val type: Type
    )

    data class Type(
        val name: String
    )

    companion object {
        private const val maxHp = 300
        private const val maxAttack = 300
        private const val maxDefense = 300
        private const val maxSpeed = 300
        private const val maxExp = 1000
    }
}
