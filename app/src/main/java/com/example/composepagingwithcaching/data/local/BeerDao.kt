package com.example.composepagingwithcaching.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BeerDao {

    @Query("SELECT * FROM beers")
    fun pagingSource(): PagingSource<Int, BeerEntity>

    @Upsert
    suspend fun insertAll(beers: List<BeerEntity>)

    @Query("DELETE FROM beers")
    suspend fun clearAll()
}