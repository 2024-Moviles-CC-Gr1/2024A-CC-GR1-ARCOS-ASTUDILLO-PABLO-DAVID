import java.time.LocalDate

fun crearPais(paises: MutableList<Pais>, nuevoPais: Pais) {
    paises.add(nuevoPais)
}

fun leerPaises(paises: List<Pais>) {
    paises.forEach { println(it) }
}

fun actualizarPaisNombre(pais: Pais, nuevoNombre: String) {
    pais.nombre = nuevoNombre
}

fun actualizarPaisSuperficie(pais: Pais, nuevaSuperficie: Double) {
    pais.superficie = nuevaSuperficie
}

fun actualizarPaisIndependencia(pais: Pais, nuevaIndependencia: Boolean) {
    pais.esIndependiente = nuevaIndependencia
}

fun actualizarPaisFechaFundacion(pais: Pais, nuevaFechaFundacion: LocalDate) {
    pais.fechaFundacion = nuevaFechaFundacion
}

fun eliminarPais(paises: MutableList<Pais>, nombre: String) {
    paises.removeIf { it.nombre == nombre }
}

fun crearCiudad(pais: Pais, nuevaCiudad: Ciudad) {
    pais.ciudades.add(nuevaCiudad)
}

fun leerCiudades(pais: Pais) {
    pais.ciudades.forEach { println(it) }
}

fun actualizarCiudadNombre(ciudad: Ciudad, nuevoNombre: String) {
    ciudad.nombre = nuevoNombre
}

fun actualizarCiudadPoblacion(ciudad: Ciudad, nuevaPoblacion: Int) {
    ciudad.poblacion = nuevaPoblacion
}

fun actualizarCiudadArea(ciudad: Ciudad, nuevaArea: Double) {
    ciudad.area = nuevaArea
}

fun actualizarCiudadEsCapital(ciudad: Ciudad, nuevoEsCapital: Boolean) {
    ciudad.esCapital = nuevoEsCapital
}

fun actualizarCiudadFechaEstablecimiento(ciudad: Ciudad, nuevaFechaEstablecimiento: LocalDate) {
    ciudad.fechaEstablecimiento = nuevaFechaEstablecimiento
}

fun eliminarCiudad(pais: Pais, nombre: String) {
    pais.ciudades.removeIf { it.nombre == nombre }
}
