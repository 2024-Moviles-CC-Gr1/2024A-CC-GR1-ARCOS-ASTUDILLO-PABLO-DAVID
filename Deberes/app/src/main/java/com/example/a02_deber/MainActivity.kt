package com.example.a02_deber

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    private lateinit var paisesListView: ListView
    private lateinit var addPaisButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)
        paisesListView = findViewById(R.id.listview_paises)
        addPaisButton = findViewById(R.id.button_add_pais)

        loadPaises()

        addPaisButton.setOnClickListener {
            val intent = Intent(this, AddPaisActivity::class.java)
            startActivity(intent)
        }

        paisesListView.setOnItemClickListener { _, _, position, _ ->
            val pais = db.getAllPaises()[position]
            val intent = Intent(this, CiudadesActivity::class.java)
            intent.putExtra("PAIS_ID", pais.id)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadPaises()
    }

    private fun loadPaises() {
        val paises = db.getAllPaises()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises.map { it.nombre })
        paisesListView.adapter = adapter
    }
}
