package com.example.composepagingwithcaching.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.composepagingwithcaching.data.mappers.toBeer
import com.example.composepagingwithcaching.domain.repository.PunkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    repository: PunkRepository
): ViewModel() {

    val beerPagingFlow = repository
        .getBeerPager()
        .flow
        .map { pagingData ->
            pagingData.map {
                it.toBeer()
            }
        }
        .cachedIn(viewModelScope)
}