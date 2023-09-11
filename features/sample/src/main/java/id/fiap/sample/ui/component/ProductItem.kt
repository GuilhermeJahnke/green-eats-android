package id.fiap.sample.ui.component


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import id.fiap.core.R
import id.fiap.core.data.model.Product
import id.fiap.core.ui.theme.Gray200
import id.fiap.core.util.UtilFunctions.fromDollarToReal

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product = Product(),
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        modifier = modifier
            .padding(8.dp)
            .defaultMinSize()
    ) {
        Column(
            modifier = modifier.defaultMinSize()
        ) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.thumbnail)
                    .crossfade(true)
                    .build(),
                loading = {
                    CircularProgressIndicator(
                        color = Color.LightGray,
                        modifier = Modifier.padding(48.dp)
                    )
                },
                contentDescription = stringResource(R.string.product_thumbnail),
                contentScale = ContentScale.Crop,
                modifier = modifier.height(180.dp)
            )
            Divider(color = Gray200, thickness = 1.dp)
            Column(
                modifier = modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ) {
                Text(
                    text = product.title ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Box(
                        modifier = Modifier
                        .weight(1f)
                    ) {
                        Column() {
                            Text(
                                text = product.price.fromDollarToReal(),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.subtitle2,
                                color = MaterialTheme.colors.secondary
                            )
                            Text(
                                text = "1kg",
                                style = MaterialTheme.typography.subtitle2,
                                color = MaterialTheme.colors.secondary
                            )
                        }

                    }
                    Box(
                        modifier = Modifier
                            .weight(0.4f)
                    ){
                        FloatingActionButton(
                            onClick = onClick,
                            modifier = Modifier.height(44.dp).fillMaxWidth(),
                            shape = RoundedCornerShape(30.dp),
                            contentColor = Color.White,
                            backgroundColor = MaterialTheme.colors.primary,
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null)
                        }
                    }
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = Product(
            id = 1,
            title = "Product Title",
            price = 100000,
            thumbnail = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
        ),
        modifier = Modifier,
        onClick = {}
    )
}