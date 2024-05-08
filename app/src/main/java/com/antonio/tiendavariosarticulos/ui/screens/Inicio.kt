package com.antonio.tiendavariosarticulos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.antonio.tiendavariosarticulos.R
import com.antonio.tiendavariosarticulos.ui.navigation.Screens
import com.antonio.tiendavariosarticulos.ui.viewmodel.ArticulosViewModel

@Composable
fun Inicio(navController: NavHostController, viewModel: ArticulosViewModel) {
    val context = LocalContext.current
    Column (modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.logo_libreria),
            contentDescription = "logo",
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {

            viewModel.ordenarArticulos(context)
            navController.navigate(route = Screens.Menu.route)

        }) {
            Text(text = "ENTRAR")
        }
    }
}