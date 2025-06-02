package com.Ingenieria3.notasrapidas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Ingenieria3.notasrapidas.model.NotasData
import com.Ingenieria3.notasrapidas.model.NotasAdapter


class Notas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notas)

        // Agrego notas de prueba
        NotasData.agregarNota("Hola!", "Esta es mi primera nota")
        NotasData.agregarNota("Otra nota", "Contenido de la segunda nota")

        // Configuro RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNotas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotasAdapter(NotasData.obtenerNotas())

        // Ajustes para sistema de barras
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
