package com.example.appfilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.appfilmes.R
import com.example.appfilmes.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.statusBarColor = Color.parseColor("#000000") //definir cor da statusBar do android

        //recuperar campo de email e iniciar ele ja com foco na edição
        binding.editEmail.requestFocus()

        binding.btEntrar.setOnClickListener{


            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            //validação se o campo esta vazio
            if (email.isEmpty()){
                binding.containerEmail.helperText = "Preencha o Email!"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff0000")

            } else{
                binding.containerEmail.helperText = ""
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ffffff")
            }

            if (senha.isEmpty()){
                binding.containerSenha.helperText = "Preencha a Senha!"
                binding.containerSenha.boxStrokeColor = Color.parseColor("#ff0000")

            } else{
                binding.containerSenha.helperText = ""
                binding.containerSenha.boxStrokeColor = Color.parseColor("#ffffff")
            }
        }

        binding.txtCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }


    }
}