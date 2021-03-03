package com.example.blocodenotas

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.blocodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val preferencia = PreferenciaAnotacao(applicationContext)

        val botaoSalvar = binding.fab

        botaoSalvar.setOnClickListener()
        {

            val anotacaoRecuperado = binding.editContainer.editAnotacao.text.toString()

            if(anotacaoRecuperado == "")
            {
                Toast.makeText(this,"Digite alguma coisa.",Toast.LENGTH_SHORT).show()
            }
            else
            {
                preferencia.salvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this,"Anotação Salva.",Toast.LENGTH_SHORT).show()
            }
        }

        val anotacao = preferencia.recuperarAnotacao()
        if(anotacao != "")
        {
            binding.editContainer.editAnotacao.setText(anotacao)
        }
    }
}