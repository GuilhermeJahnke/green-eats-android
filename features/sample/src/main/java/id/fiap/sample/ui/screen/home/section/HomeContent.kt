package id.fiap.sample.ui.screen.home.section

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.fiap.sample.ui.component.EmptyProduct
import id.fiap.sample.ui.component.ProductItem
import id.fiap.core.data.model.Product


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    modifier: Modifier,
    listProduct: MutableList<Product>?,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (listProduct != null) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(140.dp),
                content = {
                    items(listProduct, key = { it.id ?: -1 }) { product ->
                        ProductItem(
                            product = product,
                            modifier = modifier
                                .fillMaxWidth()
                                .animateItemPlacement(tween(durationMillis = 100))
                            )
                    }
                }, contentPadding = PaddingValues(8.dp)
            )
            if (listProduct.isEmpty()) EmptyProduct()
        } else EmptyProduct()
    }
}