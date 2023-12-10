package com.example.appfilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.appfilmes.R
import com.example.appfilmes.databinding.ActivityFormLoginBinding
import com.google.firebase.auth.FirebaseAuth

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


            when{
                email.isEmpty() -> {
                    binding.containerEmail.helperText = "Preencha o Email!"
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#ff0000")
                }
                senha.isEmpty() -> {
                    binding.containerSenha.helperText = "Preencha a Senha!"
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#ff0000")
                }
                else -> {
                    binding.containerEmail.helperText = ""
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#ffffff")
                    binding.containerSenha.helperText = ""
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#ffffff")
                    autenticacao(email,senha)
                }
            }
        }

        binding.txtCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }

        }
    private fun autenticacao(email: String, senha: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener { autenticacao ->
                if (autenticacao.isSuccessful){
                    Toast.makeText(this, "Login efetuado com sucesso!",Toast.LENGTH_SHORT ).show()
                    navegarTelaPrincipal()
            }
        }.addOnFailureListener {
                Toast.makeText(this, "Usuario ou senha invalida!",Toast.LENGTH_SHORT ).show()
            }
    }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }


}