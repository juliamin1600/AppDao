package br.unisanta.appdao.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appdao.R
import br.unisanta.appdao.dao.AlunoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtTurmaAluno = findViewById<TextView>(R.id.edt_turma_aluno)
        val edtNomeAluno = findViewById<TextView>(R.id.edt_nome_aluno)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabavanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        val dao = AlunoDao()
        btnSalvar.setOnClickListener{
            val nomeAluno = edtNomeAluno.text.toString()
            val turmaAluno = edtTurmaAluno.text.toString()
            dao.salvar(nomeAluno,turmaAluno)
            Log.d("ESTADO", "SALVO")
        }
        fabavanca.setOnClickListener{
            val intent = Intent(this, AlunoActivity::class.java)
            startActivity(intent)
        }
    }
}