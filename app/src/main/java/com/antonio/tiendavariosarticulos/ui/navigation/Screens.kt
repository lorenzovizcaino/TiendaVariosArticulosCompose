package com.antonio.tiendavariosarticulos.ui.navigation

sealed class Screens(val route:String){
    object Inicio: Screens("initial_screen")//info a aparecer en pantalla
    object Menu: Screens("listado articulos")//info a aparecer en pantalla
    object ResumenCompras: Screens("resumen_compras")//info a aparecer en pantalla
}