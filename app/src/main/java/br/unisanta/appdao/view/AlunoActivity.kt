package br.unisanta.appdao.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appdao.R
import br.unisanta.appdao.dao.AlunoDao
import br.unisanta.appdao.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txvNomeAluno = findViewById<TextView>(R.id.txv_Nome_Aluno)
        val txvTurmaAluno = findViewById<TextView>(R.id.txv_Turma_Aluno)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_Volta)
        val dao = AlunoDao()
        txvNomeAluno.setText("Nome: ${dao.buscar()?.nome}")
        txvTurmaAluno.setText("Turma: ${dao.buscar()?.turma}")
        fabVolta.setOnClickListener{
            finish()
        }
    }
}