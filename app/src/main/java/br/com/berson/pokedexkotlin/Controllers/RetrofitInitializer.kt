package br.com.berson.pokedexkotlin.Controllers

import br.com.berson.pokedexkotlin.Services.PokemonsServices
import br.com.berson.pokedexkotlin.Utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
        private val  retrofit = Retrofit.Builder()
            .baseUrl(Constants.URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun pokemonService ()  = retrofit.create(PokemonsServices::class.java)
}