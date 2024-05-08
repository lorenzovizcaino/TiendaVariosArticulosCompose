package com.antonio.tiendavariosarticulos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antonio.tiendavariosarticulos.ui.screens.Inicio
import com.antonio.tiendavariosarticulos.ui.screens.Menu
import com.antonio.tiendavariosarticulos.ui.screens.ResumenCompras
import com.antonio.tiendavariosarticulos.ui.viewmodel.ArticulosViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController() //linea para recordar NavController entre pantallas
    val viewModel= remember{ ArticulosViewModel() } //linea para recordar viewModel entre pantallas
    NavHost(navController, startDestination = Screens.Inicio.route) {
        //pantalla principal con la navegación
        composable(route = Screens.Inicio.route) {
            Inicio(navController, viewModel) }//Nombre del fichero .kt al que navegar
        composable(route = Screens.Menu.route) {
            Menu(navController, viewModel) }//Nombre del fichero .kt al que navegar
        composable(route = Screens.ResumenCompras.route) {
            ResumenCompras(navController, viewModel) }//Nombre del fichero .kt al que navegar






    }
}



