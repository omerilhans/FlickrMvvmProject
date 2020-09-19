package com.omerilhanli.flickrmvvmproject.di

import com.omerilhanli.module_api.repository.IRepository
import com.omerilhanli.module_api.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: RepositoryImpl) : IRepository {
        return repositoryImpl
    }
}