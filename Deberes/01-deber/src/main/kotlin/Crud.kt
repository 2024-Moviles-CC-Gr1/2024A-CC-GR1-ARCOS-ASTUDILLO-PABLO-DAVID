fun crearPais(paises: MutableList<Pais>, nuevoPais: Pais) {
    paises.add(nuevoPais)
}

fun leerPaises(paises: List<Pais>) {
    paises.forEach { println(it) }
}

fun actualizarPais(pais: Pais, nuevoNombre: String) {
    pais.nombre = nuevoNombre
    // Actualizar otros campos según sea necesario
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

fun actualizarCiudad(ciudad: Ciudad, nuevoNombre: String) {
    ciudad.nombre = nuevoNombre
    // Actualizar otros campos según sea necesario
}

fun eliminarCiudad(pais: Pais, nombre: String) {
    pais.ciudades.removeIf { it.nombre == nombre }
}
