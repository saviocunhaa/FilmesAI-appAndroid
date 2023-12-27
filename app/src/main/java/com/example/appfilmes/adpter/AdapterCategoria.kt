package com.example.appfilmes.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.databinding.CategoriaItemBinding
import com.example.appfilmes.model.Categoria
import com.example.appfilmes.model.Filme
import com.example.appfilmes.view.ListaFilmes

class AdapterCategoria(private val context: Context, private val listaCategorias: MutableList<Categoria>):
    RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
       val itemLista = CategoriaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoriaViewHolder(itemLista)
    }

    override fun getItemCount() = listaCategorias.size

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
       holder.titulo.text = listaCategorias[position].titulo
        val categoria = listaCategorias[position]

        holder.recyclerViewFilmes.adapter = AdpterFilme(context, categoria.filmes)
        holder.recyclerViewFilmes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }


    inner class CategoriaViewHolder(binding: CategoriaItemBinding): RecyclerView.ViewHolder(binding.root){
        val titulo = binding.txtTitulo
        val recyclerViewFilmes = binding.recyclerViewHorizontal
    }

    

}
