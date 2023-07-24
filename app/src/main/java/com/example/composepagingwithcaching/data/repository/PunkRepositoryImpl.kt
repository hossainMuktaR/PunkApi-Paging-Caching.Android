package com.example.composepagingwithcaching.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.composepagingwithcaching.data.local.BeerEntity
import com.example.composepagingwithcaching.data.remote.PunkApi
import com.example.composepagingwithcaching.domain.model.Beer
import com.example.composepagingwithcaching.domain.repository.PunkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PunkRepositoryImpl @Inject constructor(val pager: Pager<Int, BeerEntity>): PunkRepository {
    override fun getBeerPager(): Pager<Int,BeerEntity> {
        return pager
    }
}