package com.example.composepagingwithcaching.di


import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composepagingwithcaching.data.local.BeerDatabase
import com.example.composepagingwithcaching.data.local.BeerEntity
import com.example.composepagingwithcaching.data.remote.PunkApi
import com.example.composepagingwithcaching.data.remote.PunkRemoteMediator
import com.example.composepagingwithcaching.domain.model.Beer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideDatabase(@ApplicationContext context: Context): BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            BeerDatabase.DATABASE_NAME
        ).build()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePager(api: PunkApi, db: BeerDatabase) : Pager<Int, BeerEntity>{
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = PunkRemoteMediator(
                punkApi = api,
                db = db
            ),
            pagingSourceFactory = {
                db.dao.pagingSource()
            }
        )
    }

}