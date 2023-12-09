package com.example.appfilmes.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfilmes.R
import com.example.appfilmes.databinding.ActivityFormCadastroBinding
import com.example.appfilmes.databinding.ActivityFormLoginBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editEmail.requestFocus()

        binding.btCadastrar.setOnClickListener {
            val email = binding.editEmail.text.toString()

            if (email.isEmpty()){
                binding.containerEmail.helperText = "O email é obrigatório!"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
            }
        }



    }
}