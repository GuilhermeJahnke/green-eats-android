package id.fiap.sample.ui.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.fiap.sample.ui.screen.cart.section.CartContent
import id.fiap.core.ui.theme.Gray200
import id.fiap.core.util.Dimens
import id.fiap.sample.ui.component.EmptyProduct


@Composable
fun CartScreen(
    viewModel: CartViewModel,
) {
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
                                    // Lógica para iniciar o processo de compra
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
