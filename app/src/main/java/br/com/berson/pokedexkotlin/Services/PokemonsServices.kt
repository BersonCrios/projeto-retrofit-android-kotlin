package br.com.berson.pokedexkotlin.Services

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface PokemonsServices {
    @GET("pokemon/")
    fun list() : Call<JsonObject>
}