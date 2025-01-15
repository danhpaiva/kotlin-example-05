package com.example.fitnerd

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitnerd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCadastrar.setOnClickListener {
            exibirInformacoesEdt()
            exibirInformacoesRdb()
            exibirInformacoesServicosCheck()
            exibirReceberEmail()
        }
    }

    fun exibirInformacoesEdt() {
        val nome = binding.edtNome.text.toString()
        Log.d("INFO_CLIENTE", "NOME: ${nome}")

        val email = binding.edtEmail.text.toString()
        Log.d("INFO_CLIENTE", "EMAIL: ${email}")

        val idade = binding.edtIdade.text.toString()
        Log.d("INFO_CLIENTE", "IDADE: ${idade}")

        val senha = binding.edtSenha.text.toString()
        Log.d("INFO_CLIENTE", "SENHA: ${senha}")
    }

    fun exibirInformacoesRdb() {
        val radioButtonMarcadoId = binding.rgSexo.checkedRadioButtonId

        if (radioButtonMarcadoId != -1) {
            val sexoMarcado = findViewById<RadioButton>(radioButtonMarcadoId)
            val sexo = sexoMarcado.text.toString()
            Log.d("INFO_CLIENTE", "SEXO: ${sexo}")
        } else {
            Log.d("INFO_CLIENTE", "SEXO: NAO INFORMADO")
        }
    }

    fun exibirInformacoesServicosCheck() {
        val servicos = mutableListOf<String>()

        if (binding.ckbMusc.isChecked) {
            val musculacao = binding.ckbMusc.text.toString()
            servicos.add(musculacao)
        }

        if (binding.ckbNatacao.isChecked) {
            val natacao = binding.ckbNatacao.text.toString()
            servicos.add(natacao)
        }

        if (binding.ckbZumba.isChecked) {
            val zumba = binding.ckbZumba.text.toString()
            servicos.add(zumba)
        }

        Log.d("INFO_CLIENTE", "Servicos: ${servicos}")
    }

    fun exibirReceberEmail(){
        val zumba = binding.switchReceberEmail.isChecked
        Log.d("INFO_CLIENTE", "EMAIL: ${zumba}")
    }
}