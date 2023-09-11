package id.fiap.sample.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import id.fiap.sample.ui.component.ProgressProduct
import id.fiap.sample.ui.screen.home.section.HomeContent
import id.fiap.core.R
import id.fiap.core.data.UiState
import id.fiap.core.ui.component.molecules.SearchBar
import id.fiap.core.ui.template.MainTemplate
import id.fiap.core.ui.theme.Gray200
import id.fiap.core.util.Dimens
import id.fiap.sample.ui.component.GreetingByTime


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    MainTemplate(
        modifier = modifier,
        topBar = {
            Column(
                modifier =Modifier.padding(start = Dimens.dp16, end = Dimens.dp16, top = Dimens.dp16)
            ) {
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                    )
                    Column(
                        modifier = Modifier.padding(start = Dimens.dp10),
                    ) {
                        GreetingByTime()
                        PaddingValues(vertical = Dimens.dp8)
                        Text(text = "user name") //TODO implement username
                    }
                }
                SearchBar(
                    query = "",
                    onQueryChange = {},
                    modifier = Modifier.background(MaterialTheme.colors.primary),
                    isEnabled = false,
                )
            }
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxSize()
                    .background(Gray200)
            ) {
                viewModel.uiStateProduct.collectAsState(initial = UiState.Loading).value.let { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {
                            viewModel.getProductsApiCall()
                            ProgressProduct()
                        }

                        is UiState.Success -> {
                            HomeContent(
                                modifier = modifier,
                                listProduct = uiState.data.products,
                                onProductClick = { 
                                    viewModel.onProductClick(it)
                                }
                            )
                        }

                        is UiState.Error -> {
                            Text(text = stringResource(R.string.error_product), color = MaterialTheme.colors.onSurface)
                        }
                    }
                }
            }
        })
}