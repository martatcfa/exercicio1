package com.example.exercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //instancia a tela com o xml = inflar o layout com viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //renderizo a tela
        setContentView(binding.root)

        //Evento clique do botão login
        binding.loginBtn.setOnClickListener {
            //retorna o login
            val login = binding.loginInput.text.toString().trim()
            //retorna a senha
            val senha = binding.senhaInput.text.toString().trim()

            //verificar se o login e senha estão válidos
            if(login == "admin" && senha=="12348910"){
                //passar o login para a tela de dashboard
                //classe intent é responsavel por enviar dados de uma tela para outra
                val intent = Intent(this, MainActivity2::class.java)
                //envia o login para a tela de dashboard usando a declaração LOGIN_USUARIO
                intent.putExtra("LOGIN_USUARIO",login)
                //Abre a tela de dashboard e envia o login
                startActivity(intent)
                //Remove da memoria a tela de login
                finish()
            } else {
                //mostrar mensagem para o usuario
                Toast.makeText(this,"Login e senha incorretos!", Toast.LENGTH_SHORT).show()
            }

        }


    }
}