package com.example.appfilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appfilmes.R
import com.example.appfilmes.databinding.ActivityFormCadastroBinding
import com.example.appfilmes.databinding.ActivityFormLoginBinding
import com.google.firebase.Firebase

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Firebase
        binding.editEmail.requestFocus()

        binding.btVamosLa.setOnClickListener {
            val email = binding.editEmail.text.toString()

            if (!email.isEmpty()){
                binding.containerSenha.visibility = View.VISIBLE
                binding.btVamosLa.visibility = View.GONE
                binding.btContinuar.visibility = View.VISIBLE
                binding.txtTitulo.setText("Saiba tudo sobre o mundo dos filmes.")
                binding.txtDescricao.setText("Crie uma conta para saber mais")
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")
                binding.containerEmail.helperText = ""
                binding.containerHeader.visibility = View.VISIBLE
            } else{
                binding.containerEmail.helperText = "O email é obrigatório!"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
            }
        }


        binding.btContinuar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (!email.isEmpty() && !senha.isEmpty()){
                Toast.makeText(this,"Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()
            } else if (senha.isEmpty()){
                binding.containerSenha.boxStrokeColor = Color.parseColor("#ff0000")
                binding.containerSenha.helperText = "A senha é obrigatória"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff018786")

            }else if (email.isEmpty()){

                binding.containerEmail.helperText = "O email é obrigatória"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff018786")
            }
        }


        binding.bteEntrar.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)


        }





    }
}