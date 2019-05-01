package br.com.berson.pokedexkotlin.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.berson.pokedexkotlin.Controllers.RetrofitInitializer
import br.com.berson.pokedexkotlin.R
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pokemons()

        //CRIAR RECYCLER PARA POR OS RESULTADOS

        val pokelist = pokelist_rv
    }

    private fun pokemons() {
        val call =  RetrofitInitializer().pokemonService().list()
        call.enqueue(object  : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                response?.body()?.let {
                    val pokemons : JsonObject = it
                    Log.e("resp", pokemons.toString())
                }
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable) {
                Log.e("failure", t.message)
            }

        })
    }
}
