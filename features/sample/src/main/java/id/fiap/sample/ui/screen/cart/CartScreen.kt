package id.fiap.sample.ui.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import id.fiap.sample.ui.screen.cart.section.CartContent
import id.fiap.core.ui.theme.Gray200
import id.fiap.core.ui.theme.md_theme_light_error
import id.fiap.core.util.Dimens
import id.fiap.sample.ui.component.EmptyProduct


@Composable
fun CartScreen(
    viewModel: CartViewModel,
    navController: NavController = rememberNavController()
) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            modifier = Modifier.padding(0.dp),
            onDismissRequest = { showDialog = false },
            shape= RoundedCornerShape(20.dp),
            title = {
                Text(
                    "Confirmar pedido",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    "Tem certeza de que deseja confirmar a compra? Após a aprovação de pagamento, iremos começar os preparativos para o seu pedido!",

                )
            },
            confirmButton = {
                Box(
                    modifier = Modifier.padding(bottom = 30.dp, end=30.dp)
                ) {
                    Button(
                        modifier=Modifier.height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            showDialog = false
                            viewModel.onConfirmTap(navController)
                        }
                    ) {
                        Text("Confirmar")
                    }
                }
            },
            dismissButton = {
                Box(
                    modifier = Modifier.padding(bottom = 30.dp, end=10.dp)
                ) {
                    Button(
                        modifier=Modifier.height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                }
            }
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            Column(
                modifier =Modifier
                    .padding(
                        start = Dimens.dp16,
                        end = Dimens.dp16,
                        top = Dimens.dp16
                    )
            ) {
                Text(
                    text = "Carrinho",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        },
    ) {
          Surface(
              modifier = Modifier.fillMaxSize(),
              color = MaterialTheme.colors.background
          ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray200)
                    .padding(it)
            ) {

                if (viewModel.isLoading.value) {
                    CircularProgressIndicator()
                } else {
                    when {
                        viewModel.products.isEmpty() -> {
                            EmptyProduct()
                        }
                        else -> {
                            CartContent(
                                products = viewModel.products,
                                viewModel = viewModel
                            )
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(85.dp)
                                    .padding(16.dp)
                                    .align(Alignment.BottomCenter),
                                onClick = {
                                    showDialog = true
                                }
                            ) {
                                Text(text = "Comprar")
                            }
                        }
                    }
                }
            }
        }
    }
}
