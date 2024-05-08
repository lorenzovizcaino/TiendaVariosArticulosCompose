package com.antonio.tiendavariosarticulos.ui.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.antonio.tiendavariosarticulos.ui.model.Articulos

class ArticulosViewModel {
    var id by mutableStateOf(0)
        private set
    var titulo by mutableStateOf("")
        private set
    var autor by mutableStateOf("")
        private set
    var precio by mutableStateOf("")
        private set
    var selecionado by mutableStateOf(false)
        private set


    var cat by mutableStateOf(" ")
        private set

    var articulo by mutableStateOf(Articulos(0,",","","","",false))

    var listaArticulosIniciales = mutableListOf<Articulos>(
        Articulos(1,"Peliculas", "Torrente 1","Santiago Segura","20.00",false),
        Articulos(2,"Peliculas", "Torrente 2","Santiago Segura","23.00",false),
        Articulos(3,"Peliculas", "Torrente 3","Santiago Segura","24.00",false),
        Articulos(4,"Peliculas", "Torrente 4","Santiago Segura","25.00",false),
        Articulos(5,"Discos", "Luna de Oriente","Mecano","15.00",false),
        Articulos(6,"Discos", "Caballeros","Queen","19.00",false),
        Articulos(7,"Discos", "Nebulosa","Nebulosa","19.00",false),
        Articulos(8,"Discos", "Apatrias Locos","Manolo Escobar","10.00",false),
        Articulos(9,"Discos", "Camino Soria","Loquillo","18.00",false),
        Articulos(10,"Libros","EL NIÑO","FERNANDO ARAMBURU","19.47",false),
        Articulos(11,"Libros","EN AGOSTO NOS VEMOS","GABRIEL GARCIA MARQUEZ","18.90",false),
        Articulos(12,"Libros","TAN POCA VIDA","HANYA YANAGIHARA","23.65",false),
        Articulos(13,"Libros","UN ANIMAL SALVAJE","JOEL DICKER","22.70",false),
    )
        private set

    var listaComprar = mutableListOf<Articulos>()
        private set

    var contadorArticulos by mutableStateOf(0)
        private set

    var sumaProductos by mutableStateOf(0.0)
        private set



    fun ordenarArticulos(context: Context):MutableList<Articulos>{
         listaArticulosIniciales.sortBy {it.categoria }
        return listaArticulosIniciales
    }


    fun sumarProductos(precio: String) {
        var precioD=precio.toDouble()
        sumaProductos+=precioD
    }

    fun restarProductos(precio: String) {
        var precioD=precio.toDouble()
        sumaProductos-=precioD
    }

    fun sumarUnidadeArticulos() {
        contadorArticulos++
    }
    fun restarUnidadeArticulos() {
        contadorArticulos--
    }
    fun setaCat(categoria:String){
        cat=categoria
    }

}
