package com.example.composepagingwithcaching.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.composepagingwithcaching.data.remote.PunkApi
import com.example.composepagingwithcaching.data.remote.PunkPagingSource
import com.example.composepagingwithcaching.domain.model.Beer
import com.example.composepagingwithcaching.domain.repository.PunkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    repository: PunkRepository
): ViewModel() {

    val beerPagingFlow = repository
        .getBeerPager()
        .flow
        .cachedIn(viewModelScope)
}