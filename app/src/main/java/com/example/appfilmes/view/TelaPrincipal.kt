package com.example.appfilmes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfilmes.R
import com.example.appfilmes.adpter.AdapterCategoria
import com.example.appfilmes.databinding.ActivityTelaPrincipalBinding
import com.example.appfilmes.model.Categoria
import com.example.appfilmes.model.Filme
import com.google.android.material.navigation.NavigationView

class TelaPrincipal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
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

        binding.bootomNavigation.background = null
        binding.bootomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragmente(HomeFragment())
                R.id.bottom_favorito -> openFragmente(FavoriteFragment())
                R.id.bottom_user -> openFragmente(UserFragment())
            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragmente(HomeFragment())




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bottom_favorito -> openFragmente(FavoriteFragment())
            R.id.bottom_home -> openFragmente(HomeFragment())
            R.id.bottom_user -> openFragmente(UserFragment())
        }
        return true
    }

    private fun openFragmente( fragment: Fragment ){

        val fragmentHome: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentHome.replace(R.id.fragment_container, fragment)

        fragmentHome.commit()
    }
}