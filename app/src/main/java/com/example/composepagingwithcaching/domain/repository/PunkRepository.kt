package com.example.composepagingwithcaching.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.composepagingwithcaching.domain.model.Beer
import kotlinx.coroutines.flow.Flow

interface PunkRepository {
    fun getBeerPager(): Pager<Int, Beer>
}