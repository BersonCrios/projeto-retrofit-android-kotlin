package br.com.berson.pokedexkotlin.Services

import br.com.berson.pokedexkotlin.Models.Pokelist
import retrofit2.Call
import retrofit2.http.GET


interface PokemonsServices {
    @GET("pokemon/")
    fun list() : Call<Pokelist>
}