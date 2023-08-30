package id.rivaldy.core.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.rivaldy.core.domain.repository.product.ProductRepository
import id.rivaldy.core.domain.usecase.product.GetProductByIdUseCase
import id.rivaldy.core.domain.usecase.product.GetProductsUseCase
import id.rivaldy.core.domain.usecase.product.SearchProductUseCase

@Module
@InstallIn(ViewModelComponent::class)
object ProductUseCaseModule {

    @Provides
    fun provideGetProductUseCase(productRepository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(productRepository)
    }

    @Provides
    fun provideSearchProductUseCase(productRepository: ProductRepository): SearchProductUseCase {
        return SearchProductUseCase(productRepository)
    }

    @Provides
    fun provideGetProductByIdUseCase(productRepository: ProductRepository): GetProductByIdUseCase {
        return GetProductByIdUseCase(productRepository)
    }
}