package id.rivaldy.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.repository.product.ProductRepositoryImpl
import id.rivaldy.core.domain.repository.product.ProductRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }
}