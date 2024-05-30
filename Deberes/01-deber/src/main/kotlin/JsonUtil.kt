import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

fun leerDatosDesdeJson(ruta: String): MutableList<Pais> {
    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateDeserializer())
        .create()
    val file = File(ruta)
    if (!file.exists()) {
        return mutableListOf()
    }
    val json = file.readText()
    val listType = object : TypeToken<MutableList<Pais>>() {}.type
    return gson.fromJson(json, listType)
}

fun guardarDatosEnJson(paises: MutableList<Pais>, ruta: String) {
    val gson = GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(LocalDate::class.java, LocalDateSerializer())
        .create()
    val json = gson.toJson(paises)
    File(ruta).writeText(json)
}

class LocalDateSerializer : com.google.gson.JsonSerializer<LocalDate> {
    override fun serialize(src: LocalDate, typeOfSrc: java.lang.reflect.Type, context: com.google.gson.JsonSerializationContext): com.google.gson.JsonElement {
        return com.google.gson.JsonPrimitive(src.format(formatter))
    }
}

class LocalDateDeserializer : com.google.gson.JsonDeserializer<LocalDate> {
    override fun deserialize(json: com.google.gson.JsonElement, typeOfT: java.lang.reflect.Type, context: com.google.gson.JsonDeserializationContext): LocalDate {
        return LocalDate.parse(json.asString, formatter)
    }
}
