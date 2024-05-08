package com.antonio.tiendavariosarticulos.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.antonio.tiendavariosarticulos.ui.model.Articulos
import com.antonio.tiendavariosarticulos.ui.navigation.Screens
import com.antonio.tiendavariosarticulos.ui.viewmodel.ArticulosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavHostController, viewModel: ArticulosViewModel) {
    Scaffold(
        topBar = {
            MyTopBar(navController,viewModel)
        },
        content = {padding ->
            Contenido(navController,viewModel)
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavHostController, viewModel: ArticulosViewModel) {
    val context= LocalContext.current
    TopAppBar(


        title = { Text("Libreria TEIS", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
        actions = {





            IconButton(onClick = {navController.navigate(route = Screens.ResumenCompras.route)}) {
                if(viewModel.contadorArticulos>0){
                    BadgedBox(badge = { Badge { Text(text = "${viewModel.contadorArticulos}") } }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AddShoppingCart,
                            contentDescription = "Carrito",
                            tint = Color.White
                        )
                    }
                }else{
                    Icon(
                        imageVector = Icons.Filled.AddShoppingCart,
                        contentDescription = "Carrito",
                        tint = Color.White
                    )
                }

            }





        },


        )
}


@Composable
fun Contenido(navController: NavHostController, viewModel: ArticulosViewModel) {
    val context = LocalContext.current

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 100.dp)
    ) {
        items(viewModel.listaArticulosIniciales){
            ItemArticulos(
                viewModel=viewModel,
                articulo=it,
                navController=navController

            )
        }
    }




}

@Composable
fun ItemArticulos(viewModel: ArticulosViewModel, articulo: Articulos, navController: NavHostController) {

    var isChecked by remember { mutableStateOf(articulo.selecionado) }

   // Column(){
        println("vieModel.cat: "+viewModel.cat)
      //  if(articulo.categoria!=viewModel.cat){

            println(articulo.categoria)
            println(articulo.titulo)
            //println("vieModel.cat: "+viewModel.cat)
            Row(){
                Text(text = "Categoria: "+ articulo.categoria)
            }
           viewModel.setaCat(articulo.categoria)
        //}
        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)) {
            Row(modifier=Modifier.fillMaxWidth())
            {
                Column(modifier=Modifier.padding(10.dp)){
                    Text(text = articulo.titulo)
                    Text(text = articulo.autor)





                }
                Column(horizontalAlignment = Alignment.End, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)){
                    Text(text = articulo.precio.toString())
                    Checkbox(checked = isChecked,
                        onCheckedChange = {
                            isChecked=it
                            articulo.selecionado=isChecked
                            if (isChecked) {
                                viewModel.sumarProductos(articulo.precio)
                                viewModel.sumarUnidadeArticulos()
                                viewModel.listaComprar.add(articulo)

                            } else {
                                viewModel.restarProductos(articulo.precio)
                                viewModel.restarUnidadeArticulos()
                                viewModel.listaComprar.remove(articulo)
                            }


                        })

                }
            }

        }
    //}

}
