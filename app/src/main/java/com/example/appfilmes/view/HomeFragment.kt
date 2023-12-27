package com.example.appfilmes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.appfilmes.R
import com.example.appfilmes.adpter.AdapterCategoria
import com.example.appfilmes.model.Categoria
import com.example.appfilmes.model.Filme

data class ImageItem(val imageUrl: String, val title: String, var isFavorite: Boolean = false)

private lateinit var adapterCategoria: AdapterCategoria
private val listaCategoria: MutableList<Categoria> = mutableListOf()
//val listaFilmes: MutableList<Filme> = mutableListOf()


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "A população de animais diminuiu 58% em 42 anos.",  ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elefantes e tigres podem se tornar extintos.",  ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "E as pessoas fazem isso.",  ScaleTypes.CENTER_CROP))

        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        // Configuração do RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHorizontal)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

//        // Criando dados fictícios
//        val items = listOf(
//            ImageItem("https://bit.ly/2YoJ77H", "Imagem 1"),
//            ImageItem("https://bit.ly/2BteuF2", "Imagem 2"),
//            ImageItem("https://bit.ly/3fLJf72", "Imagem 3")
//            // Adicione mais itens conforme necessário
//        )
//
//        // Configurando o adaptador
//        recyclerView.adapter = ImageAdapter(items)
//
//        // Configuração do RecyclerView
//        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerViewHorizontal2)
//        recyclerView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//        // Criando dados fictícios
//        val items2 = listOf(
//            ImageItem("https://bit.ly/2YoJ77H", "Imagem 1"),
//            ImageItem("https://bit.ly/2BteuF2", "Imagem 2"),
//            ImageItem("https://bit.ly/3fLJf72", "Imagem 3")
//            // Adicione mais itens conforme necessário
//        )
//
//        // Configurando o adaptador
//        recyclerView2.adapter = ImageAdapter(items2)
//
//        // Configuração do RecyclerView
//        val recyclerView3 = view.findViewById<RecyclerView>(R.id.recyclerViewHorizontal3)
//        recyclerView3.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//        // Criando dados fictícios
//        val items3 = listOf(
//            ImageItem("https://bit.ly/2YoJ77H", "Imagem 1"),
//            ImageItem("https://bit.ly/2BteuF2", "Imagem 2"),
//            ImageItem("https://bit.ly/3fLJf72", "Imagem 3")
//            // Adicione mais itens conforme necessário
//        )
//
//        // Configurando o adaptador
//        recyclerView3.adapter = ImageAdapter(items3)



        // Configurando das categorias
        val recyclerViewFilmes = view.findViewById<RecyclerView>(R.id.recyclerViewVerticalTitulo)
        recyclerViewFilmes.layoutManager = LinearLayoutManager(context)
        recyclerViewFilmes.setHasFixedSize(true)
        adapterCategoria = AdapterCategoria( requireContext(), listaCategoria)
        recyclerViewFilmes.adapter = adapterCategoria


        getCategoria()
//        getFilme()

    }

    private fun getCategoria(){
        val categoria1 = Categoria("Filmes Populares")
        listaCategoria.add(categoria1)
        val categoria2 = Categoria("Novidades")
        listaCategoria.add(categoria2)
        val categoria3 = Categoria("Aventura")
        listaCategoria.add(categoria3)

    }
    // FEITO PARA TESTE
//    private fun getFilme(){
//        val filme1 = Filme(R.drawable.ic_launcher_background)
//        listaFilmes.add(filme1)
//        val filme2 = Filme(R.drawable.ic_launcher_background)
//        listaFilmes.add(filme2)
//        val filme3 = Filme(R.drawable.ic_launcher_background)
//        listaFilmes.add(filme3)
//        val filme4 = Filme(R.drawable.ic_launcher_background)
//        listaFilmes.add(filme4)
//    }
}


