package id.fiap.sample.ui.screen.home.section

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import id.fiap.core.R
import id.fiap.sample.ui.component.EmptyProduct
import id.fiap.sample.ui.component.ProductItem
import id.fiap.core.data.model.Product
import id.fiap.core.ui.theme.md_theme_light_background
import id.fiap.core.util.Extensions.myToast


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    modifier: Modifier,
    listProduct: MutableList<Product>?,
    onProductClick: (Product) -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(md_theme_light_background)
    ) {
        if (listProduct != null) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(140.dp),
                content = {

                    items(listProduct, key = { it.id ?: -1 }) { product ->

                        val strAddCart = stringResource(id = R.string.added_to_cart, product.title.toString())

                        ProductItem(
                            product = product,
                            modifier = modifier
                                .fillMaxWidth()
                                .animateItemPlacement(
                                    tween(durationMillis = 100)
                                ),
                            onClick = {
                                onProductClick(product)
                                context.myToast(strAddCart)
                            }
                        )
                    }
                }, contentPadding = PaddingValues(8.dp)
            )
            if (listProduct.isEmpty()) EmptyProduct()
        } else EmptyProduct()
    }
}