package com.example.composepagingwithcaching.di


import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.composepagingwithcaching.data.remote.PunkApi
import com.example.composepagingwithcaching.data.remote.PunkPagingSource
import com.example.composepagingwithcaching.domain.model.Beer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PunkModule {

    @Provides
    @Singleton
    fun providePunkApi(): PunkApi {
        return Retrofit.Builder()
            .baseUrl(PunkApi.BASE_URL_PUNK)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create<PunkApi>()
    }

    @Provides
    @Singleton
    fun providePager(api: PunkApi) : Pager<Int, Beer>{
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                PunkPagingSource(api)
            }
        )
    }

}