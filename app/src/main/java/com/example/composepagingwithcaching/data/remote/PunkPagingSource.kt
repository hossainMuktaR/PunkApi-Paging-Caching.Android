package com.example.composepagingwithcaching.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composepagingwithcaching.domain.model.Beer
import javax.inject.Inject

class PunkPagingSource(
    private val punkApi: PunkApi
    ): PagingSource<Int, Beer>() {
    override fun getRefreshKey(state: PagingState<Int, Beer>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Beer> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = punkApi.getBeer(nextPageNumber, params.loadSize)
            return LoadResult.Page(
                data = response.map { it.toBeer() },
                prevKey = null,
                nextKey = nextPageNumber.plus(1)
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}