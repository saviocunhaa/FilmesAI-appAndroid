package com.example.appfilmes.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.databinding.CategoriaItemBinding
import com.example.appfilmes.model.Categoria

class AdapterCategoria(private val context: Context, private val listaCategoria: MutableList<Categoria>):
    RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
       val itemLista = CategoriaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoriaViewHolder(itemLista)
    }

    override fun getItemCount() = listaCategoria.size

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
       holder.titulo.text = listaCategoria[position].titulo
    }

    inner class CategoriaViewHolder(binding: CategoriaItemBinding): RecyclerView.ViewHolder(binding.root){
        val titulo = binding.txtTitulo
    }

    

}
