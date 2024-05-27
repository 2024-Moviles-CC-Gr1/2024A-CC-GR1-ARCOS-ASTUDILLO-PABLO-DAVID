import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val paises = leerDatosDesdeJson("paises.json")

    while (true) {
        println("\nMenú CRUD")
        println("1. Crear País")
        println("2. Leer Países")
        println("3. Actualizar País")
        println("4. Eliminar País")
        println("5. Crear Ciudad")
        println("6. Leer Ciudades")
        println("7. Actualizar Ciudad")
        println("8. Eliminar Ciudad")
        println("9. Guardar y Salir")
        println("Elige una opción:")

        when (scanner.nextLine().toInt()) {
            1 -> {
                println("Nombre del País:")
                val nombre = scanner.nextLine()
                println("Superficie:")
                val superficie = scanner.nextLine().toDouble()
                println("Es Independiente (true/false):")
                val esIndependiente = scanner.nextLine().toBoolean()
                println("Fecha de Fundación (YYYY-MM-DD):")
                val fechaFundacion = scanner.nextLine()

                val nuevoPais = Pais(nombre, superficie, esIndependiente, fechaFundacion)
                crearPais(paises, nuevoPais)
            }
            2 -> leerPaises(paises)
            3 -> {
                println("Nombre del País a actualizar:")
                val nombre = scanner.nextLine()
                val pais = paises.find { it.nombre == nombre }
                if (pais != null) {
                    println("Nuevo nombre del País:")
                    val nuevoNombre = scanner.nextLine()
                    actualizarPais(pais, nuevoNombre)
                } else {
                    println("País no encontrado.")
                }
            }
            4 -> {
                println("Nombre del País a eliminar:")
                val nombre = scanner.nextLine()
                eliminarPais(paises, nombre)
            }
            5 -> {
                println("Nombre del País al que pertenece la Ciudad:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    println("Nombre de la Ciudad:")
                    val nombreCiudad = scanner.nextLine()
                    println("Población:")
                    val poblacion = scanner.nextLine().toInt()
                    println("Área:")
                    val area = scanner.nextLine().toDouble()
                    println("Es Capital (true/false):")
                    val esCapital = scanner.nextLine().toBoolean()
                    println("Fecha de Establecimiento (YYYY-MM-DD):")
                    val fechaEstablecimiento = scanner.nextLine()

                    val nuevaCiudad = Ciudad(nombreCiudad, poblacion, area, esCapital, fechaEstablecimiento)
                    crearCiudad(pais, nuevaCiudad)
                } else {
                    println("País no encontrado.")
                }
            }
            6 -> {
                println("Nombre del País para listar sus Ciudades:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    leerCiudades(pais)
                } else {
                    println("País no encontrado.")
                }
            }
            7 -> {
                println("Nombre del País al que pertenece la Ciudad:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    println("Nombre de la Ciudad a actualizar:")
                    val nombreCiudad = scanner.nextLine()
                    val ciudad = pais.ciudades.find { it.nombre == nombreCiudad }
                    if (ciudad != null) {
                        println("Nuevo nombre de la Ciudad:")
                        val nuevoNombre = scanner.nextLine()
                        actualizarCiudad(ciudad, nuevoNombre)
                    } else {
                        println("Ciudad no encontrada.")
                    }
                } else {
                    println("País no encontrado.")
                }
            }
            8 -> {
                println("Nombre del País al que pertenece la Ciudad:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    println("Nombre de la Ciudad a eliminar:")
                    val nombreCiudad = scanner.nextLine()
                    eliminarCiudad(pais, nombreCiudad)
                } else {
                    println("País no encontrado.")
                }
            }
            9 -> {
                guardarDatosEnJson(paises, "paises.json")
                println("Datos guardados. Saliendo...")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}
