package com.antonio.tiendavariosarticulos.ui.model

import java.io.Serializable

class Articulos(
    var id: Int,
    var categoria: String,
    var titulo: String,
    var autor: String,
    var precio: String,
    var selecionado: Boolean
) : Serializable