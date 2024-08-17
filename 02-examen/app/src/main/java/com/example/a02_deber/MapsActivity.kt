package com.example.a02_deber

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.a02_deber.databinding.ActivityMapsBinding
import android.location.Geocoder

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    // Declara un objeto GoogleMap para manejar el mapa
    private lateinit var mMap: GoogleMap
    // Declara el binding para acceder a las vistas de la actividad
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla la vista utilizando ViewBinding para facilitar el acceso a los componentes de la UI
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera el nombre de la ciudad que fue pasado desde la actividad anterior
        val ciudadNombre = intent.getStringExtra("CIUDAD_NOMBRE")

        // Obtiene el fragmento de mapa definido en el layout y establece una llamada cuando el mapa esté listo
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        // Registra el callback para saber cuándo el mapa está listo para usarse
        mapFragment.getMapAsync {
            // Asigna el mapa a la variable mMap cuando está disponible
            mMap = it
            // Si el nombre de la ciudad no es nulo, llama a la función para mostrarla en el mapa
            if (ciudadNombre != null) {
                showCityOnMap(ciudadNombre)
            }
        }
    }

    // Función para mostrar la ciudad en el mapa según el nombre
    private fun showCityOnMap(ciudadNombre: String) {
        // Crea una instancia de Geocoder que permitirá buscar la ciudad
        val geocoder = Geocoder(this)
        // Usa el Geocoder para buscar las coordenadas de la ciudad en base a su nombre
        val addressList = geocoder.getFromLocationName(ciudadNombre, 1)

        // Verifica que la lista de direcciones no sea nula ni vacía
        if (addressList != null && addressList.isNotEmpty()) {
            // Obtiene la primera dirección de la lista
            val address = addressList[0]
            // Convierte la dirección en un objeto LatLng (latitud y longitud)
            val cityLatLng = LatLng(address.latitude, address.longitude)
            // Agrega un marcador en las coordenadas de la ciudad con el nombre de la ciudad como título
            mMap.addMarker(MarkerOptions().position(cityLatLng).title(ciudadNombre))
            // Mueve la cámara del mapa hacia la ciudad con un zoom específico
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityLatLng, 10f))
        }
    }

    // Callback llamado cuando el mapa está listo
    override fun onMapReady(googleMap: GoogleMap) {
        // Asigna el objeto GoogleMap a la variable mMap
        mMap = googleMap
        // No se agrega ningún marcador por defecto en este callback
    }
}
