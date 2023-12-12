package com.example.appfilmes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfilmes.R
import com.example.appfilmes.adpter.AdapterCategoria
import com.example.appfilmes.databinding.ActivityTelaPrincipalBinding
import com.example.appfilmes.model.Categoria

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private lateinit var adapterCategoria: AdapterCategoria
    private val listaCategorias: MutableList<Categoria> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerViewFilmes = binding.recyclerViewFilmes
        recyclerViewFilmes.layoutManager = LinearLayoutManager(this)
        recyclerViewFilmes.setHasFixedSize(true)
        adapterCategoria = AdapterCategoria(this, listaCategorias)
        recyclerViewFilmes.adapter = adapterCategoria
        getCategoria()
    }
    private fun getCategoria(){
        val categoria1 = Categoria("Filmes 01")
        listaCategorias.add(categoria1)
        val categoria2 = Categoria("Filmes 02")
        listaCategorias.add(categoria2)
    }
}