package com.example.a02_deber

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CiudadesActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    private lateinit var ciudadesListView: ListView
    private lateinit var addCiudadButton: Button
    private var paisId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        db = DatabaseHelper(this)
        ciudadesListView = findViewById(R.id.listview_ciudades)
        addCiudadButton = findViewById(R.id.button_add_ciudad)

        paisId = intent.getLongExtra("PAIS_ID", 0)

        loadCiudades()

        addCiudadButton.setOnClickListener {
            val intent = Intent(this, AddCiudadActivity::class.java)
            intent.putExtra("PAIS_ID", paisId)
            startActivity(intent)
        }
    }

    private fun loadCiudades() {
        val ciudades = db.getCiudadesByPaisId(paisId)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ciudades.map { it.nombre })
        ciudadesListView.adapter = adapter
    }
}
