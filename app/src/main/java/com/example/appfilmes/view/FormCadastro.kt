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
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.ktx.Firebase

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                cadastro(email, senha)
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
    private fun cadastro(email: String, senha: String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
            if (cadastro.isSuccessful){
                Toast.makeText(this, "Cadastro Realizado com Sucesso!", Toast.LENGTH_LONG).show()
                navegarTelaLogin()
            }
        }.addOnFailureListener {
           val erro = it

            when{
                erro is FirebaseAuthWeakPasswordException ->{
                    binding.containerSenha.helperText = "Digite uma senha com no minino 6 caracteres"
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#ff0000")
                }
                erro is FirebaseAuthUserCollisionException -> {
                    binding.containerEmail.helperText = "Essa conta já está cadastrado"
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#ff0000")
                }
                erro is FirebaseNetworkException -> {
                    binding.containerSenha.helperText = "Erro de Conexão com a internet"
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#ff0000")
                }
                else -> {
                    Toast.makeText(this, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun navegarTelaLogin(){
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}