package com.example.appfilmes.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.databinding.ImagemItemBinding
import com.example.appfilmes.model.Filme

class AdpterFilme(private val context: Context?, private val listaFilmes: MutableList<Filme>):
    RecyclerView.Adapter<AdpterFilme.FilmeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
       val itemLista = ImagemItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FilmeViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.capa.setImageResource(listaFilmes[position].capa!!)
    }

    override fun getItemCount() = listaFilmes.count()


    inner class FilmeViewHolder(binding: ImagemItemBinding): RecyclerView.ViewHolder(binding.root){
        val capa = binding.imageView
        val titulo = binding.textViewTitle
    }
}