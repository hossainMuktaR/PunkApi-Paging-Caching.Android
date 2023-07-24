package com.example.composepagingwithcaching.di

import com.example.composepagingwithcaching.data.repository.PunkRepositoryImpl
import com.example.composepagingwithcaching.domain.repository.PunkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PunkBinds {

    @Binds
    @Singleton
    abstract fun bindPunkRepository(punkRepositoryImpl: PunkRepositoryImpl): PunkRepository
}