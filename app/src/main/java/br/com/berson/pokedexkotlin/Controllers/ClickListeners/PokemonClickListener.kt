package br.com.berson.pokedexkotlin.Controllers.ClickListeners

import  br.com.berson.pokedexkotlin.Models.Result
interface OnItemClickListener {
    fun onItemClick(item: Result)
}