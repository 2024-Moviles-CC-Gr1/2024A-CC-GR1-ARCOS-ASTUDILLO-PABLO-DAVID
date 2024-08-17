package com.example.a02_deber

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CiudadesActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    private lateinit var ciudadesListView: ListView
    private lateinit var addCiudadButton: Button
    private lateinit var backButton: Button
    private var paisId: Long = 0
    private var selectedCiudadId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        db = DatabaseHelper(this)
        ciudadesListView = findViewById(R.id.listview_ciudades)
        addCiudadButton = findViewById(R.id.button_add_ciudad)
        backButton = findViewById(R.id.button_back)

        paisId = intent.getLongExtra("PAIS_ID", 0)

        loadCiudades()

        addCiudadButton.setOnClickListener {
            val intent = Intent(this, AddCiudadActivity::class.java)
            intent.putExtra("PAIS_ID", paisId)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registerForContextMenu(ciudadesListView)
    }

    private fun loadCiudades() {
        val ciudades = db.getCiudadesByPaisId(paisId)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ciudades.map { it.nombre })
        ciudadesListView.adapter = adapter
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu_ciudad, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val ciudad = db.getCiudadesByPaisId(paisId)[info.position]
        selectedCiudadId = ciudad.id

        return when (item.itemId) {
            R.id.menu_editar_ciudad -> {
                val intent = Intent(this, EditCiudadActivity::class.java)
                intent.putExtra("CIUDAD_ID", selectedCiudadId)
                startActivity(intent)
                true
            }
            R.id.menu_eliminar_ciudad -> {
                db.deleteCiudad(selectedCiudadId)
                loadCiudades()
                true
            }
            R.id.menu_mapa -> {
                // Abre MapsActivity con el nombre de la ciudad
                val intent = Intent(this, MapsActivity::class.java).apply {
                    putExtra("CIUDAD_NOMBRE", ciudad.nombre)
                }
                startActivity(intent)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }




}
