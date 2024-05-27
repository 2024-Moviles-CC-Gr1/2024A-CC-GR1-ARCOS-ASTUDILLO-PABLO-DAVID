import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

fun guardarDatosEnJson(paises: List<Pais>, archivo: String) {
    val gson = Gson()
    val jsonString = gson.toJson(paises)
    File(archivo).writeText(jsonString)
}

fun leerDatosDesdeJson(archivo: String): MutableList<Pais> {
    val file = File(archivo)
    if (!file.exists()) {
        file.createNewFile()
        file.writeText("[]")  // Escribe un arreglo JSON vacío
    }

    val gson = Gson()
    val jsonString = file.readText()
    val listType = object : TypeToken<MutableList<Pais>>() {}.type
    return gson.fromJson(jsonString, listType)
}
