package br.com.berson.pokedexkotlin.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.berson.pokedexkotlin.Controllers.RetrofitInitializer
import br.com.berson.pokedexkotlin.Models.Pokelist
import br.com.berson.pokedexkotlin.Models.Result
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.berson.pokedexkotlin.Adapter.PokemonsAdapter


class MainActivity : AppCompatActivity() {

    private var pokemonList: List<Result>? = null
    private var adapterPokemons: PokemonsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(br.com.berson.pokedexkotlin.R.layout.activity_main)

        pokemons()
    }

    private fun pokemons() {
        val call =  RetrofitInitializer().pokemonService().list()
        call.enqueue(object  : Callback<Pokelist>{
            override fun onResponse(call: Call<Pokelist>?, response: Response<Pokelist>?) {
                pokemonList = response?.body()?.results
                Log.e("POkemons aew caramba", pokemonList.toString())
                adapterPokemons = PokemonsAdapter(this@MainActivity, pokemonList)
                pokelist_rv.layoutManager = LinearLayoutManager(this@MainActivity)
                pokelist_rv.adapter = adapterPokemons
            }

            override fun onFailure(call: Call<Pokelist>?, t: Throwable) {
                Log.e("failure", t.message)
            }
        })
    }
}
