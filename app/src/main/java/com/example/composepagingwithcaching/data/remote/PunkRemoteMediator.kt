package com.example.composepagingwithcaching.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.composepagingwithcaching.data.local.BeerDatabase
import com.example.composepagingwithcaching.data.local.BeerEntity
import com.example.composepagingwithcaching.data.mappers.toBeerEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class PunkRemoteMediator(
    private val punkApi: PunkApi,
    private val db: BeerDatabase
    ): RemoteMediator<Int, BeerEntity>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, BeerEntity>): MediatorResult {
        return try {
            val pageNo = when(loadType){
                LoadType.REFRESH -> 1
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    (lastItem.id / state.config.pageSize) + 1
                }
            }
            val beers = punkApi.getBeer(
                page = pageNo,
                perPage = state.config.pageSize
            ).map { it.toBeerEntity() }

            db.withTransaction {
                if(loadType == LoadType.REFRESH){
                    db.dao.clearAll()
                }
                db.dao.insertAll(beers)
            }
            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )
        } catch (e: IOException){
            MediatorResult.Error(e)
        } catch(e: HttpException) {
            MediatorResult.Error(e)
        }
    }


}