package br.com.berson.pokedexkotlin.Models


import com.google.gson.annotations.SerializedName

data class Pokelist(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)