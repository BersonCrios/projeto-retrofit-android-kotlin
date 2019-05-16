package br.com.berson.pokedexkotlin.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import  br.com.berson.pokedexkotlin.Models.Result
import br.com.berson.pokedexkotlin.R


//class PokemonsAdapter(private val mContext: Context, private val bancos: List<Result>?, private val listener: (Any) -> Unit) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {
class PokemonsAdapter(private val mContext: Context, private val bancos: List<Result>?) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {

    init {
        Log.e("sewqqswsq", bancos.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pokemonName.text = bancos?.get(position)!!.name
    }

    override fun getItemCount(): Int {
        return bancos?.size!!
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pokemonName: TextView

        init {
            pokemonName = itemView.findViewById(R.id.nome)

//            itemView.setOnClickListener { v -> listener.onItemClick(bancos[adapterPosition]) }
        }
    }
}